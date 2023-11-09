package com.example.bnanum.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {
    public String id;
    public String password;
    public String member_name;
    public String department;
}
