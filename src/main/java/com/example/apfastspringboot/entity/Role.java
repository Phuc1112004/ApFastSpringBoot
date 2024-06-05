package com.example.apfastspringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @EmbeddedId
    private RoleId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private Member member;

    // Getters and Setters
    public RoleId getId() {
        return id;
    }

    public void setId(RoleId id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
