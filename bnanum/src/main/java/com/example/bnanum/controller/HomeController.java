package com.example.bnanum.controller;

import com.example.bnanum.domain.Member;
import com.example.bnanum.session.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final SessionManager sessionManager;

    //TODO url 설정
    @GetMapping("/")
    public void homeLogin(HttpServletRequest request, Model model){

        //세션 관리자에 저장된 회원 정보 조회
        Member loginMember = (Member)sessionManager.getSession(request);

        if(loginMember == null){
            return ;
            // 로그인 되지 않은 초기 화면
        }

        model.addAttribute("member", loginMember);
        return ;
        // 로그인 된 화면 보여주기

    }
}
