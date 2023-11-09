package com.example.bnanum.session;

import com.example.bnanum.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class SessionTest {

    SessionManager sessionManager = new SessionManager();
    @Test
    public void test1(){

        //세션 생성 클라이언트 -> 서버
        MockHttpServletResponse response = new MockHttpServletResponse();
        Member member = new Member();
        sessionManager.createSession(member, response);

        // 서버 -> 클라이언트
        // 요청에 응답 쿠키 저장
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        // 세션조회
        Object result = sessionManager.getSession(request);
        Assertions.assertThat(result).isEqualTo(member);



    }
}
