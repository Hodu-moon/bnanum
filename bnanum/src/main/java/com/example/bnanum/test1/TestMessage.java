package com.example.bnanum.test1;

import lombok.Data;

@Data
public class TestMessage {
    private StatusEnum status;
    private String message;
    private Object data;

    public TestMessage(){
        this.status = StatusEnum.BAD_REQUEST;
        this.data = null;
        this.message = null;
    }
}
