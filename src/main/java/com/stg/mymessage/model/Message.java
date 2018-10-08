package com.stg.mymessage.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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

    @OneToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "user_id")
    private User sender;

    @OneToMany(cascade = {CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinTable(
            name="user_message",
            joinColumns = @JoinColumn( name="message_id"),
            inverseJoinColumns = @JoinColumn( name="receiver_id")
    )
    private List<User> receiverList;

    @Column(name = "create_date")
    private Date createDate;

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

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public List<User> getReceiverList() {
        return receiverList;
    }

    public void setReceiverList(List<User> receiverList) {
        this.receiverList = receiverList;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
