package com.catchtable.clone.domain.member;

import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public class MemberInfo {
    private final Long id;
    private final String memberToken;
    private final String name;
    private final String phone;
    private final String password;
    private final String nickname;
    private final Member.Status status;

    public MemberInfo(Member member){
        this.id = member.getId();
        this.memberToken = member.getMemberToken();
        this.name = member.getName();
        this.phone = member.getPhone();
        this.password = member.getPassword();
        this.nickname = member.getNickname();
        this.status = member.getStatus();
    }
}
