package com.example.apfastspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.apfastspringboot.entity.Role;
import com.example.apfastspringboot.entity.RoleId;
import com.example.apfastspringboot.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(RoleId roleId) {
        return roleRepository.findById(roleId);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public void deleteById(RoleId roleId) {
        roleRepository.deleteById(roleId);
    }
}

