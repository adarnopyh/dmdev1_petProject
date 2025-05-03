package now.qty.dao.impl;

import now.qty.dao.ProductDao;
import now.qty.entity.ClientEntity;
import now.qty.entity.ProductEntity;
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

public class ProductDaoImpl implements ProductDao {

    private static ProductDaoImpl instance;

    private static final String PRODUCT_ID = "id";
    private static final String PRODUCT_NAME = "name";
    private static final String PRODUCT_SKU = "sku";

    private static final String GET_ALL_PRODUCTS_SQL = """
            SELECT *
            FROM products
            """;

    private static final String GET_PRODUCT_BY_ID_SQL = """
            SELECT *
            FROM products
            WHERE products.id = ?;
            """;

    private static final String INSERT_PRODUCT_SQL = """
            INSERT INTO products
            (name, sku)
            VALUES (?, ?)
            RETURNING id;
            """;

    private static final String UPDATE_PRODUCT_SQL = """
            UPDATE products
            SET name=?, sku=?
            WHERE id=?
            """;

    private static final String DELETE_PRODUCT_BY_ID_SQL = """
            DELETE
            FROM products
            WHERE id = ?
            """;


    private ProductDaoImpl() {
    }

    public static synchronized ProductDaoImpl getInstance() {
        if (instance == null) {
            instance = new ProductDaoImpl();
        }
        return instance;
    }

    @Override
    public Optional<ProductEntity> findById(Integer id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(GET_PRODUCT_BY_ID_SQL)) {

            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(buildProductFromResult(resultSet));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            System.out.println("Can not find client by id: " + id);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductEntity> findAll() {
        return List.of();
    }

    @Override
    public ProductEntity create(ProductEntity entity) {
        return null;
    }

    @Override
    public ProductEntity update(ProductEntity entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    private ProductEntity buildProductFromResult(ResultSet resultSet) throws SQLException {
        try {
            return ProductEntity
                    .builder()
                    .id(resultSet.getInt(PRODUCT_ID))
                    .name(resultSet.getString(PRODUCT_NAME))
                    .sku(resultSet.getString(PRODUCT_SKU))
                    .build();
        } catch (SQLException e) {
            System.out.println("Can't fetch data from resultSet");
            throw new RuntimeException(e);
        }
    }


}
