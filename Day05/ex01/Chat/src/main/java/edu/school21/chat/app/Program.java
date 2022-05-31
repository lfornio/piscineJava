package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.Optional;
import java.util.Scanner;


public class Program {
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/chat";

    public static void main(String[] args) {

        HikariDataSource dataSources = new HikariDataSource();
        dataSources.setJdbcUrl(CONNECTION_URL);
        dataSources.setUsername(USER_NAME);
        dataSources.setPassword(PASSWORD);

        System.out.println("Enter a message ID");
        System.out.print("->");

        MessagesRepositoryJdbcImpl message = new MessagesRepositoryJdbcImpl(dataSources);

        try {
            Optional<Message> msg = message.findById(new Scanner(System.in).nextLong());
            if (msg.isPresent()) {
                System.out.println(msg.get().toString());
            }
        } catch (Exception e) {
            System.out.println("Message not found");
            System.exit(-1);
        }
        dataSources.close();
    }
}

