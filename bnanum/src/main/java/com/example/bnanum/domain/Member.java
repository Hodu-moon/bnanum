package com.example.bnanum.domain;

import com.example.bnanum.entity.BasicEntity;
import com.example.bnanum.entity.Department;
import com.example.bnanum.entity.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Member extends BasicEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false, length = 30, name="memberId")
    private String memberId;
    @Column(nullable = false, length = 30)
    private String password;

    @Column(length = 20)
    private String member_name;
    @Enumerated(EnumType.STRING)
    private Department department;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member")
    private final List<Board> boardList = new ArrayList<>();


}
