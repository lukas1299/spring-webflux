package com.example.membersservice;

import com.example.membersservice.model.Member;
import com.example.membersservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
@Log4j2
public class MemberListener {

    private final MemberRepository memberRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void listen() {
        final var members = WebClient.create()
                .get()
                .uri("http://localhost:8081/new-member")
                .retrieve()
                .bodyToFlux(Member.class)
                .flatMap(memberRepository::save);

        memberRepository.deleteAll().thenMany(members).subscribe(member -> log.info("Add new member: " + member.getName()));
    }
}
