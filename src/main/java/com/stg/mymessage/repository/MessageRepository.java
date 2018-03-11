package com.stg.mymessage.repository;

import com.stg.mymessage.model.Message;
import com.stg.mymessage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> getMessageByReceiverList(User user);
}
