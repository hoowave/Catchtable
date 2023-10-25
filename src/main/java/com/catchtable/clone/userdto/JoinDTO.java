package com.catchtable.clone.userdto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JoinDTO {
    private int mno;
    private String name;
    private String phone;
    private String password;
    private String nickname;

    private LocalDate date = LocalDate.now();

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
