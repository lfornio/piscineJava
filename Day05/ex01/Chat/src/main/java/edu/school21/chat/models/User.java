package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private Long userId;
    private String login;
    private String password;
    private ArrayList<Chatroom> createdRooms;
    private ArrayList<Chatroom> chatrooms;

    public User(Long userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }

    public User(Long userId, String login, String password, ArrayList<Chatroom> createdRooms, ArrayList<Chatroom> chatrooms) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.chatrooms = chatrooms;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", chatrooms=" + chatrooms +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public ArrayList<Chatroom> getChatrooms() {
        return chatrooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(createdRooms, user.createdRooms) && Objects.equals(chatrooms, user.chatrooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, createdRooms, chatrooms);
    }
}
