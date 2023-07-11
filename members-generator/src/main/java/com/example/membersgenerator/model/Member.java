package com.example.membersgenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "Members")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    private int id;

    private String name;

    public Member(String name) {
        this.name = name;
    }
}
