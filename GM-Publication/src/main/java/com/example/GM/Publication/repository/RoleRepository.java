package com.example.GM.Publication.repository;


import com.example.GM.Publication.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
