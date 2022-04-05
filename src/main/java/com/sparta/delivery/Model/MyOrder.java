package com.sparta.delivery.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class MyOrder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
}
