package school21.spring.service.repositories;

import school21.spring.service.models.User;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private DataSource dataSource;

    public UsersRepositoryJdbcImpl(HikariDataSource hikariDataSource) {
        this.dataSource = hikariDataSource;
    }

    @Override
    public User findById(Long id) throws SQLException {
        String query = "SELECT * FROM Email WHERE Id = " + id;

        Statement statement = dataSource.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        Long idUser = resultSet.getLong("Id");
        String emailUser = resultSet.getString("Email");
        User user = new User(idUser, emailUser);
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> list = new ArrayList<>();
        Statement statement = dataSource.getConnection().createStatement();

        String query = "SELECT * FROM Email";

        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            list.add(new User(resultSet.getLong("Id"),
                    resultSet.getString("Email")));
        }
        statement.close();
        resultSet.close();
        return list;
    }

    @Override
    public void save(User entity) throws SQLException {
        String query = "INSERT INTO Email (Email) VALUES (?)";

        PreparedStatement prepareStatement = dataSource.getConnection().prepareStatement(query);
        prepareStatement.setString(1, entity.getEmail());
        prepareStatement.executeUpdate();
        prepareStatement.close();
    }

    @Override
    public void update(User entity) throws SQLException {
        String query = "UPDATE Email SET Email = ? WHERE Id = " + entity.getId();

        PreparedStatement prepareStatement = dataSource.getConnection().prepareStatement(query);
        prepareStatement.setString(1, entity.getEmail());
        prepareStatement.executeUpdate();
        prepareStatement.close();
    }

    @Override
    public void delete(Long id) throws SQLException {
        String query = "DELETE FROM Email WHERE Id = " + id;

        Statement statement = dataSource.getConnection().createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    @Override
    public Optional<User> findByEmail(String email) throws SQLException {

        User user = null;
        String query = "SELECT * FROM Email";

        Statement statement = dataSource.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()) {
            Long idUser = resultSet.getLong("Id");
            String emailUser = resultSet.getString("Email");
            if (emailUser.equals(email)) {
                user = new User(idUser, emailUser);
                break;
            }
        }
        statement.close();
        resultSet.close();
        return Optional.of(user);
    }
}

