package com.example.demo.Member;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Adding a new member
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    // Retrieving a list of all members
    @GetMapping
    public List<Member> getMembers() {
        return memberService.getAllMembers();
    }

}
