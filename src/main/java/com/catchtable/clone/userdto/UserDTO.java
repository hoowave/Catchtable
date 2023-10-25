package com.catchtable.clone.userdto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private int mno;
    private String name;
    private String phone;
    private String password;
    private String nickname;
    private LocalDate date;
}
