package com.example.membersgenerator.controller;

import com.example.membersgenerator.model.Member;
import com.example.membersgenerator.MemberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberGenerator memberGenerator;

    @GetMapping(value = "/new-member", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Member> getMember(){
        return memberGenerator.generate();
    }
}
