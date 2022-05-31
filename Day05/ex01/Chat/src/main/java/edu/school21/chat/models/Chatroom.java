package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class Chatroom {
    private Long chatId;
    private String name;
    private User owner;
    private ArrayList<Message> messages;

    public Chatroom(Long chatId, String name, User owner) {
        this.chatId = chatId;
        this.name = name;
        this.owner = owner;
    }

    public Chatroom(Long chatId, String name, User owner, ArrayList<Message> messages) {
        this.chatId = chatId;
        this.name = name;
        this.owner = owner;
        this.messages = messages;
    }

    public Chatroom(Long chatId, String name) {
        this.chatId = chatId;
        this.name = name;
    }

    public Long getChatId() {
        return chatId;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "chatId=" + chatId +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", messages=" + messages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return Objects.equals(chatId, chatroom.chatId) && Objects.equals(name, chatroom.name) && Objects.equals(owner, chatroom.owner) && Objects.equals(messages, chatroom.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, name, owner, messages);
    }
}






