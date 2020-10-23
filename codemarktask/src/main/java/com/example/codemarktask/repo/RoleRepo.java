package com.example.codemarktask.repo;

import com.example.codemarktask.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer > {
    Role findByName(String name);
}
