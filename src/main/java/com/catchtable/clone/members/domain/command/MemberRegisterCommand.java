package com.catchtable.clone.members.domain.command;

import com.catchtable.clone.members.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class MemberRegisterCommand {
    private final String name;
    private final String phone;
    private final String password;
    private final String nickname;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .phone(phone)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
