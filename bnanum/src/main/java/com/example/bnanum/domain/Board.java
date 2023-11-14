package com.example.bnanum.domain;

import com.example.bnanum.entity.BasicEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BasicEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long  board_no;

    @Column(length = 40)
    private String category;
    // computer11 -> 1학년 1학기

    @Column(length = 40)
    private String title;

    @Column(length = 255)
    private String text;

    @ManyToOne
    @JoinColumn(name = "id")
    private Member member;

}

