package com.example.bnanum.domain;

import com.example.bnanum.entity.BasicEntity;
import jakarta.persistence.*;

@Entity
public class Board extends BasicEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    public Long  board_no;

    @Column(length = 255)
    public String text;
    @ManyToOne
    @JoinColumn(name = "id")
    public Member member;

}

