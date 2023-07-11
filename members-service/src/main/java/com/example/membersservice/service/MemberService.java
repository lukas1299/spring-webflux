package com.example.membersservice.service;

import com.example.membersservice.model.Member;
import com.example.membersservice.model.MemberRequest;
import com.example.membersservice.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void create(MemberRequest memberRequest) {
        memberRepository.save(new Member(memberRequest.name())).subscribe();
    }

    public Mono<Member> findById(Integer id) {
        return memberRepository.findById(id);
    }

    public Flux<Member> findAll() {
        return memberRepository.findAll();
    }

    public Mono<Void> delete(Integer id) {
        return memberRepository.deleteById(id);
    }
}
