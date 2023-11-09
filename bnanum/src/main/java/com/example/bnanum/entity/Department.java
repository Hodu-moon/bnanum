package com.example.bnanum.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum Department {
    COMPUTER("computer"),
    ELECTRONICS("electronics"),
    Artificial_Intelligence("artificial_intelligence");
    private final String value;
}
