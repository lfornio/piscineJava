package edu.school21.repositories;

import edu.school21.models.Product;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsReposutoryJdbcImpl implements ProductsRepository {

    private final EmbeddedDatabase db;

    public ProductsReposutoryJdbcImpl(EmbeddedDatabase data) {
        db = data;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> list = new ArrayList<>();

        Statement statement = db.getConnection().createStatement();

        String query = "SELECT * FROM Product";

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            list.add(new Product(resultSet.getLong("Id"),
                    resultSet.getString("Name"),
                    resultSet.getInt("Price")));
        }
        return list;
    }

    @Override
    public Optional<Product> findById(Long id) throws SQLException {

        String query = "SELECT * FROM Product WHERE Id = " + id;

        Statement statement = db.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();
        Long idProduct = resultSet.getLong("Id");
        String nameProduct = resultSet.getString("Name");
        int priceProduct = resultSet.getInt("Price");

        Product product = new Product(idProduct, nameProduct, priceProduct);

        Optional<Product> optionalProduct = Optional.of(product);
        return optionalProduct;
    }

    @Override
    public void update(Product product) throws SQLException {

        String query = "UPDATE Product SET Name = ?, Price = ? WHERE Id = " + product.getId();

        PreparedStatement prepareStatement = db.getConnection().prepareStatement(query);
        prepareStatement.setString(1, product.getName());
        prepareStatement.setInt(2, product.getPrice());
        prepareStatement.executeUpdate();
    }

    @Override
    public void save(Product product) throws SQLException {

        String query = "INSERT INTO Product (Name, Price) VALUES (?, ?)";
        PreparedStatement prepareStatement = db.getConnection().prepareStatement(query);
        prepareStatement.setString(1, product.getName());
        prepareStatement.setInt(2, product.getPrice());
        prepareStatement.executeUpdate();
    }

    @Override
    public void delete(Long id) throws SQLException {

        String query = "DELETE FROM Product WHERE Id = " + id;

        Statement statement = db.getConnection().createStatement();
        statement.executeUpdate(query);
    }
}
