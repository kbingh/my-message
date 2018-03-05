package com.stg.mymessage.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private int messageId;

    @Column(name = "message")
    private String message;

    @Column(name = "subject")
    private String subject;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name="user_message",
            joinColumns = @JoinColumn( name="message_id"),
            inverseJoinColumns = @JoinColumn( name="user_id")
    )
    private List<User> userList;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
