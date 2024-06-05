package com.example.apfastspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.example.apfastspringboot.entity.Member;
import com.example.apfastspringboot.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable String id) {
        Optional<Member> member = memberService.findById(id);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.save(member);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable String id, @RequestBody Member memberDetails) {
        Optional<Member> member = memberService.findById(id);
        if (member.isPresent()) {
            Member updatedMember = member.get();
            updatedMember.setPassword(memberDetails.getPassword());
            updatedMember.setActive(memberDetails.isActive());
            updatedMember.setRoles(memberDetails.getRoles());
            return ResponseEntity.ok(memberService.save(updatedMember));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable String id) {
        memberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


