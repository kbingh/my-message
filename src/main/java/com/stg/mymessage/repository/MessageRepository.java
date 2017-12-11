package com.stg.mymessage.repository;

import com.stg.mymessage.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findByFromUserName(String fromUserName);
    List<Message> findByToUserName(String toUserName);
}
