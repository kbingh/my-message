package com.stg.mymessage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.mymessage.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
