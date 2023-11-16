package com.catchtable.clone.members.interfaces.dto;

import com.catchtable.clone.members.domain.command.MemberLoginCommand;
import com.catchtable.clone.members.domain.Member;
import com.catchtable.clone.members.domain.info.MemberInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

public class MemberLoginDto {

    @Getter
    @Setter
    @ToString
    public static class LoginRequest{
        @NotEmpty(message = "name 또는 phone 은 필수값입니다.")
        private String loginId;
        @NotEmpty(message = "password 는 필수값입니다.")
        private String loginPw;

        public MemberLoginCommand toCommand(){
            return MemberLoginCommand.builder()
                    .loginId(loginId)
                    .loginPw(loginPw)
                    .build();
        }
    }
    @Getter
    @ToString
    public static class LoginResponse {
        //비밀번호는 보안상 제공하지 않는것이 좋다는 정보를 얻음
        private final String memberToken;
        private final String name;
        private final String phone;
        private final String nickname;
        private final Member.Status status;

        public LoginResponse(MemberInfo memberInfo) {
            this.memberToken = memberInfo.getMemberToken();
            this.name = memberInfo.getName();
            this.phone = memberInfo.getPhone();
            this.nickname = memberInfo.getNickname();
            this.status = memberInfo.getStatus();
        }

    }

}
