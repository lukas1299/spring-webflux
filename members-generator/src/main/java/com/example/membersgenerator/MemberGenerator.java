package com.example.membersgenerator;

import com.example.membersgenerator.model.Member;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Component
public class MemberGenerator {

    public Flux<Member> generate() {
        return Flux.fromStream(Stream.generate(() -> new Member("example-name")))
                .delayElements(Duration.ofSeconds(3));
    }
}
