package com.example.apfastspringboot.controller;

import com.example.apfastspringboot.entity.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.example.apfastspringboot.entity.Role;
import com.example.apfastspringboot.entity.RoleId;
import com.example.apfastspringboot.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @GetMapping("/{userId}/{role}")
    public ResponseEntity<Role> getRoleById(@PathVariable String userId, @PathVariable RoleType role) {
        RoleId roleId = new RoleId();
        roleId.setUserId(userId);
        roleId.setRole(role);
        Optional<Role> roleEntity = roleService.findById(roleId);
        return roleEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.save(role);
    }

    @PutMapping("/{userId}/{role}")
    public ResponseEntity<Role> updateRole(@PathVariable String userId, @PathVariable RoleType role, @RequestBody Role roleDetails) {
        RoleId roleId = new RoleId();
        roleId.setUserId(userId);
        roleId.setRole(role);
        Optional<Role> roleEntity = roleService.findById(roleId);
        if (roleEntity.isPresent()) {
            Role updatedRole = roleEntity.get();
            updatedRole.setMember(roleDetails.getMember());
            return ResponseEntity.ok(roleService.save(updatedRole));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userId}/{role}")
    public ResponseEntity<Void> deleteRole(@PathVariable String userId, @PathVariable RoleType role) {
        RoleId roleId = new RoleId();
        roleId.setUserId(userId);
        roleId.setRole(role);
        roleService.deleteById(roleId);
        return ResponseEntity.noContent().build();
    }
}

