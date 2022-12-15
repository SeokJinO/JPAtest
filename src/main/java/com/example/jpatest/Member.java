package com.example.jpatest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME")
    private String username;

    //매핑 정보가 없는 필드
    private Integer age;

}
