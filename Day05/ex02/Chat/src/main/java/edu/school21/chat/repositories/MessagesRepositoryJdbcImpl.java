package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.*;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private HikariDataSource dataSource;

    public MessagesRepositoryJdbcImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {

        Message message = null;
        Statement statement = dataSource.getConnection().createStatement();

        String query = "SELECT * FROM Messages\n" +
                "JOIN Users on Messages.Author = Users.UserId\n" +
                "JOIN Chatrooms ON Messages.Room = Chatrooms.ChatId\n" +
                "WHERE Messages.MessageId = " + id;

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();
        Long messageId = resultSet.getLong("MessageId");

        Long userId = resultSet.getLong("Author");
        String userLogin = resultSet.getString("Login");
        String userPassword = resultSet.getString("Password");
        User user = new User(userId, userLogin, userPassword);

        Long messageRoom = resultSet.getLong("Room");
        String nameRoom = resultSet.getString("Name");
        Chatroom chatRoom = new Chatroom(messageRoom, nameRoom);

        String text = resultSet.getString("Text");
        LocalDateTime date = resultSet.getTimestamp("Date_time").toLocalDateTime();
        message = new Message(messageId, user, chatRoom, text, date);

        statement.close();
        resultSet.close();

        Optional<Message> optionalMessage = Optional.of(message);
        return optionalMessage;
    }

    @Override
    public void save(Message message) throws SQLException {

        Long id = 0L;

        String query = "INSERT INTO Messages (Author, Room, Text, Date_time)\n" +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement prepareStatement = dataSource.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        prepareStatement.setLong(1, message.getAuthor().getUserId());
        prepareStatement.setLong(2, message.getChatroom().getChatId());
        prepareStatement.setString(3, message.getText());
        prepareStatement.setObject(4, message.getDateTime());
        try {
            prepareStatement.executeUpdate();
            ResultSet rs = prepareStatement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
                prepareStatement.close();
                rs.close();
            }
        } catch (
                Exception ex) {
            throw new NotSavedSubEntityException();
        }
        message.setMessageId(id);
    }
}


