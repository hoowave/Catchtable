package com.catchtable.clone.interfaces.member;

import com.catchtable.clone.domain.member.Member;
import com.catchtable.clone.domain.member.register.MemberRegisterCommand;
import com.catchtable.clone.domain.member.MemberInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

public class MemberRegisterDto {
    // static inner class 사용해보자

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        @NotEmpty(message = "name 은 필수값입니다.")
        private String name;
        @NotEmpty(message = "phone 은 필수값입니다.")
        private String phone;
        @NotEmpty(message = "password 은 필수값입니다.")
        private String password;
        private String nickname;

        public MemberRegisterCommand toCommand() {
            return MemberRegisterCommand.builder()
                    .name(name)
                    .phone(phone)
                    .password(password)
                    .nickname(nickname)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class RegisterResponse {
        private final String memberToken;
        private final String name;
        private final String phone;
        private final String password;
        private final String nickname;
        private final Member.Status status;

        public RegisterResponse(MemberInfo memberInfo) {
            this.memberToken = memberInfo.getMemberToken();
            this.name = memberInfo.getName();
            this.phone = memberInfo.getPhone();
            this.password = memberInfo.getPassword();
            this.nickname = memberInfo.getNickname();
            this.status = memberInfo.getStatus();
        }
    }
}
