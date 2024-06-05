package com.example.apfastspringboot.service;

import com.example.apfastspringboot.entity.Member;
import com.example.apfastspringboot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member getMemberByUsername(String username) {
        return memberRepository.findByUsername(username);
    }
}
