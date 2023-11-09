package com.example.bnanum.controller;

import com.example.bnanum.domain.Member;
import com.example.bnanum.dto.LoginForm;
import com.example.bnanum.service.MemberService;
import com.example.bnanum.session.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final MemberService memberService;
    private final SessionManager sessionManager;


    // TODO url 설정
    @PostMapping("/login")
    public void login( @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletResponse response){
        log.info("Controller loginPost");

        if(bindingResult.hasErrors()){
            return ;
            // 로그인 하는곳 다시
        }

        // BindingResult ?? 바인딩 할때 에러를 model 뒤에 와야한다.
        // 원래 400에러 가 뜸

        Member loginMember = memberService.login(form);
        if(loginMember == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
        }

        sessionManager.createSession(loginMember, response);

    }


    // TODO url 설정
    @PostMapping("/logout")
    public void logout(HttpServletRequest request){
        sessionManager.expire(request);
        return ;
    }
}
