package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {
    private Long messageId;
    private User author;
    private Chatroom chatroom;
    private String text;
    private LocalDateTime dateTime;

    public Message(Long messageId, User author, Chatroom chatroom, String text, LocalDateTime dateTime) {
        this.messageId = messageId;
        this.author = author;
        this.chatroom = chatroom;
        this.text = text;
        this.dateTime = dateTime;
    }

    public Long getMessageId() {
        return messageId;
    }

    public User getAuthor() {
        return author;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "Message: { \n" +
                "messageId=" + messageId +
                ", \nauthor=" + author +
                ", \nchatroom=" + chatroom +
                ", \ntext='" + text + '\'' +
                ", \ndateTime=" + dateTime.format(DateTimeFormatter.ofPattern("d/MM/uuuu HH:mm")) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(messageId, message.messageId) && Objects.equals(author, message.author) && Objects.equals(chatroom, message.chatroom) && Objects.equals(text, message.text) && Objects.equals(dateTime, message.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, author, chatroom, text, dateTime);
    }
}