package now.qty.dao.impl;

import now.qty.dao.ClientDao;
import now.qty.entity.BankAccountEntity;
import now.qty.entity.ClientEntity;
import now.qty.entity.PriceLevelEntity;
import now.qty.util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDaoImpl implements ClientDao {

    private static ClientDaoImpl instance;

    private static final String CLIENT_ID = "id";
    private static final String CLIENT_NAME = "name";
    private static final String CLIENT_IS_LEGAL = "is_legal";
    private static final String CLIENT_IS_VAT_PAYER = "is_vat_payer";
    private static final String ADDRESS_ID = "address_id";
    private static final String CLIENT_REG_NUMBER = "reg_number";
    private static final String CLIENT_VAT_NUMBER = "vat_number";
    private static final String BANK_ACCOUNT_ID = "bank_account_id";
//    private static final String IBAN = "iban";
    private static final String PRICE_LEVEL_ID = "price_level_id";


    private static final String GET_ALL_CLIENTS_SQL = """
            SELECT *
            FROM clients
            """;

    private static final String GET_CLIENT_BY_ID_SQL = """
            SELECT *
            FROM clients
            WHERE clients.id = ?;
            """;

    private static final String INSERT_CLIENT_SQL = """
            INSERT INTO clients
            (name, is_legal, is_vat_payer, address_id, reg_number, vat_number, bank_account_id, price_level_id)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            RETURNING id;
            """;

    private static final String UPDATE_CLIENT_SQL = """
            UPDATE clients
            SET name=?, is_legal=?, is_vat_payer=?, address_id=?, reg_number=?, vat_number=?, bank_account_id=?, price_level_id=?
            WHERE id=?
            """;

    private static final String DELETE_CLIENT_BY_ID_SQL = """
            DELETE
            FROM clients
            WHERE id = ?
            """;


    private ClientDaoImpl() {
    }

    public static synchronized ClientDaoImpl getInstance() {
        if (instance == null) {
            instance = new ClientDaoImpl();
        }
        return instance;
    }


    @Override
    public List<ClientEntity> findAll() {
        try (Connection connection = ConnectionManager.get(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_CLIENTS_SQL);
            List<ClientEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                ClientEntity clientEntity = buildClientFromResult(resultSet);
                list.add(clientEntity);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Can't get all clients from database");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<ClientEntity> findById(Integer id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(GET_CLIENT_BY_ID_SQL)) {

            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(buildClientFromResult(resultSet));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            System.out.println("Can not find client by id: " + id);
            throw new RuntimeException(e);
        }
    }

    @Override
    public ClientEntity create(ClientEntity entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL)) {

            setParams(preparedStatement, entity);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                entity.setId(resultSet.getInt(CLIENT_ID));
                return entity;
            }

        } catch (SQLException e) {
            System.out.println("Can't create client: " + entity.getId());
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public ClientEntity update(ClientEntity entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_SQL)) {

            setParams(preparedStatement, entity);
            preparedStatement.setInt(9, entity.getId());

            if (preparedStatement.executeUpdate() > 0) {
                return entity;
            }
        } catch (SQLException e) {
            System.out.println("Can't update client: " + entity.getId());
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to delete client with ID: " + id);
            throw new RuntimeException(e);
        }
    }

    private void setParams(PreparedStatement preparedStatement, ClientEntity client) throws SQLException {
        preparedStatement.setString(1, client.getName());
        preparedStatement.setBoolean(2, client.getIsLegal());
        if (client.getIsVatPayer() != null) preparedStatement.setBoolean(3, client.getIsVatPayer());
        else preparedStatement.setNull(3, Types.BOOLEAN);
        if (client.getAddressId() != null) preparedStatement.setInt(4, client.getAddressId());
        else preparedStatement.setNull(4, Types.INTEGER);
        preparedStatement.setString(5, client.getRegNumber());
        if (client.getVatNumber() != null) preparedStatement.setString(6, client.getVatNumber());
        else preparedStatement.setNull(6, Types.VARCHAR);
        if (client.getBankAccount() != null) preparedStatement.setInt(7, client.getBankAccount().getId());
        else preparedStatement.setNull(7, Types.INTEGER);
        if (client.getPriceLevel() != null) preparedStatement.setInt(8, client.getPriceLevel().getId());
        else preparedStatement.setNull(8, Types.INTEGER);

    }


    private ClientEntity buildClientFromResult(ResultSet resultSet) throws SQLException {
        try {
            return ClientEntity
                    .builder()
                    .id(resultSet.getInt(CLIENT_ID))
                    .name(resultSet.getString(CLIENT_NAME))
                    .isLegal(resultSet.getBoolean(CLIENT_IS_LEGAL))
                    .isVatPayer(resultSet.getBoolean(CLIENT_IS_VAT_PAYER))
                    .addressId(resultSet.getObject(ADDRESS_ID) != null ? resultSet.getInt(ADDRESS_ID) : null)
                    .regNumber(resultSet.getString(CLIENT_REG_NUMBER))
                    .vatNumber(resultSet.getObject(CLIENT_VAT_NUMBER) != null ? resultSet.getString(CLIENT_VAT_NUMBER) : null)
                    .bankAccount(resultSet.wasNull() ? null : BankAccountEntity.builder().id(resultSet.getInt(BANK_ACCOUNT_ID)).build())
                    .priceLevel(resultSet.wasNull() ? null : PriceLevelEntity.builder().id(resultSet.getInt(PRICE_LEVEL_ID)).build())
                    .build();
        } catch (SQLException e) {
            System.out.println("Can't fetch data from resultSet");
            throw new RuntimeException(e);
        }
    }

}