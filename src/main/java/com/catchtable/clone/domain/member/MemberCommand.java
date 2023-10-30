package com.catchtable.clone.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class MemberCommand {
    private final String name;
    private final String phone;
    private final String password;
    private final String nickname;

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .phone(phone)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
