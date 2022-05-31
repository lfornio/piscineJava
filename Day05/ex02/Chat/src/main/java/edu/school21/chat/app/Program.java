package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;


public class Program {
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/chat";

    public static void main(String[] args){

        HikariDataSource dataSources = new HikariDataSource();
        dataSources.setJdbcUrl(CONNECTION_URL);
        dataSources.setUsername(USER_NAME);
        dataSources.setPassword(PASSWORD);


        MessagesRepositoryJdbcImpl messagesRepository  = new MessagesRepositoryJdbcImpl(dataSources);

        User creator = new User(0L, "DDDDD", "ddddd", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(3L, "Chat_3", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());

        try {
            messagesRepository.save(message);
            System.out.println("id = " + message.getMessageId());

        } catch (NotSavedSubEntityException e) {


            System.exit(-1);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        dataSources.close();
    }
}
