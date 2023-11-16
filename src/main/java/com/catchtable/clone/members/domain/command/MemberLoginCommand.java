package com.catchtable.clone.members.domain.command;

import com.catchtable.clone.members.domain.Member;
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
