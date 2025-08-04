package com.example.demo.Member;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Saving member information to the database
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    // Retrieving a list of all members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
