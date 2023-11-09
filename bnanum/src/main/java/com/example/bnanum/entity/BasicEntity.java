package com.example.bnanum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;



@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BasicEntity {
    @CreatedDate @Column(updatable = false)
    private LocalDateTime regDate;
    @LastModifiedDate
    private LocalDateTime modDate;


}
