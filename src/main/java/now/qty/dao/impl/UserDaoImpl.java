package now.qty.dao.impl;

import lombok.SneakyThrows;
import now.qty.dao.UserDao;
import now.qty.entity.ClientEntity;
import now.qty.entity.ProductEntity;
import now.qty.entity.Role;
import now.qty.entity.UserEntity;
import now.qty.util.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDaoImpl implements UserDao {

    private static UserDaoImpl instance;

    private static final String USER_ID = "id";
    private static final String USER_USERNAME = "username";
    private static final String USER_PASSWORD = "password";
    private static final String USER_EMAIL = "email";
    private static final String USER_ROLE = "role";

    private static final String INSERT_USER_SQL = """
            INSERT INTO "user"
            (username, password, email, role)
            VALUES (?, ?, ?, ?);
            """;


    public UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }


    @Override
    public Optional<UserEntity> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<UserEntity> findAll() {
        return List.of();
    }

    @Override
    @SneakyThrows
    public UserEntity create(UserEntity entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL, RETURN_GENERATED_KEYS)) {

            setParams(preparedStatement, entity);
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));

            return entity;
        }
    }

    @Override
    public UserEntity update(UserEntity entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    private void setParams(PreparedStatement preparedStatement, UserEntity user) throws SQLException {
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getRole().name());
    }


    private UserEntity buildUserFromResult(ResultSet resultSet) throws SQLException {
        try {
            return UserEntity
                    .builder()
                    .id(resultSet.getInt(USER_ID))
                    .username(resultSet.getString(USER_USERNAME))
                    .password(resultSet.getString(USER_PASSWORD))
                    .email(resultSet.getString(USER_EMAIL))
                    .role(Role.valueOf(resultSet.getString(USER_ROLE)))
                    .build();
        } catch (SQLException e) {
            System.out.println("Can't fetch data from resultSet");
            throw new RuntimeException(e);
        }
    }


}
