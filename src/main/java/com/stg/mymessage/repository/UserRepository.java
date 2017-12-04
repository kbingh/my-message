package com.stg.mymessage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.mymessage.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByFirstName(String firstName);
}
