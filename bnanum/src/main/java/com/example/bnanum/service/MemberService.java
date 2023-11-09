package com.example.bnanum.service;

import com.example.bnanum.domain.Member;
import com.example.bnanum.dto.LoginForm;
import com.example.bnanum.dto.MemberDTO;
import com.example.bnanum.entity.Department;
import com.example.bnanum.entity.Role;
import com.example.bnanum.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    /**
     * 회원가입
     * memberDTO에
     * 회원아이디
     * 비밀번호
     * 학과과 department (Enum key타입 써줄것 )
     *
     * @param memberDTO
     */
    public void join(MemberDTO memberDTO){
        Member member = Member.builder()
                .memberId((memberDTO.getId()))
                .password(memberDTO.getPassword())
                .member_name(memberDTO.getMember_name())
                .build();

        member.setRole(Role.USER);
        // department 의 computer를
        member.setDepartment(Department.valueOf(memberDTO.getDepartment()));

        memberRepository.save(member);
    }

    public Member login(LoginForm loginForm){
        Member member = memberRepository.findByMemberId(loginForm.getId());

        if(member.getPassword() != loginForm.getPassword()){
            return null;
        }

        return member;
    }

    public int checkDuplicate(MemberDTO memberDTO) {
        Member member = memberRepository.findAll().stream().
                filter(memberDTO.getId()::equals)
                .findFirst().
                orElse(null);

        if (member == null) {
            return 1;
        } else
            return 0;
    }
}
