package com.example.bnanum.repository;

import com.example.bnanum.domain.Member;
import com.example.bnanum.entity.Department;
import com.example.bnanum.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Test
    public void signUpTest(){
        for (int i = 0; i < 100; i++) {
            Member member = Member.builder()
                    .memberId("member" + i)
                    .password("pass" + i)
                    .build();

            member.setRole(Role.USER);
            member.setDepartment(Department.COMPUTER);

            memberRepository.save(member);
        }
    }

    @Test
    public void insertMember_300(){
        for (int i = 0; i < 300; i++) {
            Member member = Member.builder()
                    .memberId("member" + i)
                    .password("pass" + i)
                    .build();

            member.setRole(Role.USER);
            member.setDepartment(Department.COMPUTER);

            memberRepository.save(member);
        }
    }
}