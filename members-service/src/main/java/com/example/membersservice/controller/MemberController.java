package com.example.membersservice.controller;

import com.example.membersservice.model.Member;
import com.example.membersservice.model.MemberRequest;
import com.example.membersservice.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/members")
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void save(@RequestBody MemberRequest memberRequest) {
        memberService.create(memberRequest);
    }

    @GetMapping
    public Flux<Member> getAll() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Member> getById(@PathVariable Integer id) {
        return memberService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) {
        return memberService.delete(id);
    }

}
