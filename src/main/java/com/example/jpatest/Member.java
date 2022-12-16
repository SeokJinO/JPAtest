package com.example.jpatest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "Member")
@Getter
@Setter
@ToString
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames = {"NAME", "AGE"})})
public class Member {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name", nullable = false, length = 10)
    private String username;

    //매핑 정보가 없는 필드
    private Integer age;

}
