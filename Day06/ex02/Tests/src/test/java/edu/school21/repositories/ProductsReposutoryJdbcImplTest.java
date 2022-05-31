package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ProductsReposutoryJdbcImplTest {

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(0L, "AAAAA", 111),
            new Product(1L, "BBBBB", 222),
            new Product(2L, "CCCCC", 333),
            new Product(3L, "DDDDD", 444),
            new Product(4L, "IIIII", 555)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(3L, "DDDDD", 444);
    final Product EXPECTED_SAVE_PRODUCT = new Product(5L, "FFFFF", 666);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(4L, "OOOOO", 999);
    final Product EXPECTED_AFTER_DELETE_PRODUCT = new Product(4L, "IIIII", 555);

    private EmbeddedDatabase datab;
    private ProductsReposutoryJdbcImpl product;

    @BeforeEach
    void init() {
        datab = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        product = new ProductsReposutoryJdbcImpl(datab);
    }

    @Test
    void testFindById() throws SQLException {
        Assertions.assertEquals(product.findById(3L).get(), EXPECTED_FIND_BY_ID_PRODUCT);
    }

    @Test
    void testUpdate() throws SQLException {
        product.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(product.findById(4L).get(), EXPECTED_UPDATED_PRODUCT);
    }

    @Test
    void testSave() throws SQLException {
        product.save(EXPECTED_SAVE_PRODUCT);
        Assertions.assertEquals(product.findById(5L).get(), EXPECTED_SAVE_PRODUCT);
    }

    @Test
    void testDelete() throws SQLException {
        product.delete(3L);
        Assertions.assertEquals(product.findById(4L).get(), EXPECTED_AFTER_DELETE_PRODUCT);
    }

    @Test
    void testFindAll() throws SQLException {
        Assertions.assertEquals(product.findAll(), EXPECTED_FIND_ALL_PRODUCTS);
    }
}
