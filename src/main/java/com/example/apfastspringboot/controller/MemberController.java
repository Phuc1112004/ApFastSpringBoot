package com.example.apfastspringboot.controller;

import com.example.apfastspringboot.entity.Member;
import com.example.apfastspringboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/{username}")
    public Member getMemberByUsername(@PathVariable String username) {
        return memberService.getMemberByUsername(username);
    }
}

