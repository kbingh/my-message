package com.bingham.mymessage.repository;

import com.bingham.mymessage.model.Message;
import com.bingham.mymessage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> getMessageByReceiverList(List<User> receiverList);
}
