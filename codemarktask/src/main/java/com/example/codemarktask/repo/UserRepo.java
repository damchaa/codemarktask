package com.example.codemarktask.repo;

import com.example.codemarktask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    User findByLogin(String login);
}
