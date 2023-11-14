package com.catchtable.clone.domain.member.login;

import com.catchtable.clone.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class MemberLoginCommand {
    private String loginId;
    private String loginPw;

    public Member toEntity(){
        return new Member(loginId, loginPw);
    }
}
