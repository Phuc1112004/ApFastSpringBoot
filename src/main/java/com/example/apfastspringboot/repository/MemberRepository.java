package com.example.apfastspringboot.repository;

import com.example.apfastspringboot.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
