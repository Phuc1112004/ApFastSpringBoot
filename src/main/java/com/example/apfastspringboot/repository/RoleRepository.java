package com.example.apfastspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.apfastspringboot.entity.Role;
import com.example.apfastspringboot.entity.RoleId;

@Repository
public interface RoleRepository extends JpaRepository<Role, RoleId> {
}

