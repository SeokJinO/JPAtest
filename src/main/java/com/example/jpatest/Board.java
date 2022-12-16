package com.example.jpatest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "board")
@Getter
@Setter
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
