package com.stg.mymessage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.mymessage.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
