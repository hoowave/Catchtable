package com.catchtable.clone.vo;

import com.catchtable.clone.dto.JoinDTO;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class UserVO {
    private int mno;
    private String name;
    private String phone;
    private String password;
    private String nickname;
    private LocalDate date;

    public UserVO(JoinDTO joinDTO){
        if(!nameValidate(joinDTO.getName())){
            throw new IllegalArgumentException("이름이 잘못되었습니다.");
        }
        this.name = joinDTO.getName();

        if(!phoneValidate(joinDTO.getPhone())){
            throw new IllegalArgumentException("휴대폰 번호가 잘못되었습니다.");
        }
        this.phone = joinDTO.getPhone();

        if(!passwordValidate(joinDTO.getPassword())){
            throw new IllegalArgumentException("비밀번호가 잘못되었습니다.");
        }
        this.password = joinDTO.getPassword();

        this.nickname = joinDTO.getNickname();

        // 서버에서 값을 초기화 시켜주니, 유효성 검사를 안 해도 되겠죠..??
        this.date = LocalDate.now();
    }

    private boolean nameValidate(String name){
        if(name.equals("")){
            return false;
        }
        return true;
    }

    private boolean phoneValidate(String phone){
        if(phone.equals("")){
            return false;
        }
        return true;
    }

    private boolean passwordValidate(String password){
        if(password.equals("")){
            return false;
        }
        return true;
    }
}
