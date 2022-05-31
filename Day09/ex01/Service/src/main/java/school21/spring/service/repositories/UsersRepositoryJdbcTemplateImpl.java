package school21.spring.service.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.models.User;

import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM Email WHERE Id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(User.class))
                        .stream().findAny().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM Email", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO Email (Email) VALUES (?)", entity.getEmail());

    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE Email SET Email = ? WHERE Id = ? ",
                entity.getEmail(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM Email WHERE Id = ?", id);

    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = jdbcTemplate.query("SELECT * FROM Email WHERE email = ?",
                        new Object[]{email},
                        new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
        return Optional.of(user);
    }
}

