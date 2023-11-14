package com.example.bnanum.controller;

import com.example.bnanum.domain.Member;
import com.example.bnanum.dto.MemberDTO;
import com.example.bnanum.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입
     * memberDTO에
     * 회원아이디 id
     * 비밀번호 password
     * 이름 name
     * 학과과 department COMPUTER
     * (Enum key타입 써줄것 )
     *
     * @param memberDTO
     */
    @PostMapping()
    public void join(@ModelAttribute MemberDTO memberDTO, BindingResult bindingResult){
        memberService.join(memberDTO);

        String pattern = "^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣|\s]*$";


        if(Pattern.matches(pattern, memberDTO.getPassword()))
            bindingResult.addError(
                    new FieldError("memberDTO", "password",memberDTO.getPassword() ,false, null, null,
                            "특수문자 포함해야합니다."));



        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);
        }

        int checkDuplicate = memberService.checkDuplicate(memberDTO);
        if(checkDuplicate == 0){
            bindingResult.addError(new FieldError("memberDTO", "id",null
                    ,false, null, null, "중복"));
        }

        
    }

    // TODO 테스트 후 삭제할 것
    @GetMapping("/list")
    public Page<Member> list(){
        Page<Member> paging = this.memberService.getList(0);

        return paging;
    }



}
