package com.example.demo.Tournament;

import com.example.demo.Member.Member;
import com.example.demo.Member.MemberRepository;
import org.springframework.stereotype.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;
    private final MemberRepository memberRepository;

    public TournamentService(TournamentRepository tournamentRepository, MemberRepository memberRepository) {
        this.tournamentRepository = tournamentRepository;
        this.memberRepository = memberRepository;
    }

    public Tournament saveTournament(Tournament tournament) {
        Set<Member> members = tournament.getParticipatingMembers();
        Set<Member> attachedMembers = new HashSet<>();

        if (members != null) {
            for (Member member : members) {
                if (member.getId() != null) {
                    memberRepository.findById(member.getId()).ifPresent(attachedMembers::add);
                }
            }
        }
        tournament.setParticipatingMembers(attachedMembers);
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }
}

