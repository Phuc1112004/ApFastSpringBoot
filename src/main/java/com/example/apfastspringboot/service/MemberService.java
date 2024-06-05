package com.example.apfastspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.apfastspringboot.entity.Member;
import com.example.apfastspringboot.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Optional<Member> findById(String userId) {
        return memberRepository.findById(userId);
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public void deleteById(String userId) {
        memberRepository.deleteById(userId);
    }
}

