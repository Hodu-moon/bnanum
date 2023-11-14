package com.example.bnanum.test1;


import com.example.bnanum.domain.Member;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpTestController {

    @GetMapping("response-entity")
    public ResponseEntity getResponseEntity(){
        System.out.println("-- http return ");
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("test-data")
    public ResponseEntity<TestMessage> testMessage(){

        Member member = Member.builder()
                .memberId("test")
                .password("psps")
                .build();
        TestMessage testMessage = new TestMessage();
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(new MediaType("application", "json"));

        testMessage.setStatus(StatusEnum.OK);
        testMessage.setMessage("성공코드");
        testMessage.setData(member);

        return new ResponseEntity<>(testMessage, httpHeaders, HttpStatus.OK);
    }
}
