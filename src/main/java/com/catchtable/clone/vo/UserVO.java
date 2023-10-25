package com.catchtable.clone.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class UserVO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;
    private String name;
    private String phone;
    private String password;
    private String nickname;
    private LocalDate date;

    public UserVO(String name, String phone, String password, String nickname, LocalDate date){
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.nickname = nickname;
        this.date = date;
    }
}
