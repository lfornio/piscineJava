package edu.school21.chat.repositories;

import edu.school21.chat.models.*;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
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
}
