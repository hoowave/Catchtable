package com.catchtable.clone.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JoinDTO {
    // 사용자에게 전달받은 값
    private int mno;
    private String name;
    private String phone;
    private String password;
    private String nickname;
    // 여기는 사용자의 입력 값을 받는것이니, date는 VO로 옮김과 동시에 현재시간으로 초기화시킴
    // private LocalDate date = LocalDate.now();
    private int tno;
    private String peristalsis;
    private String terms_1;
    private String terms_2;
    private String terms_3;
    private String terms_4;
    private String terms_5;
    private String terms_6_1;
    private String terms_6_2;
    private String terms_6_3;
}
