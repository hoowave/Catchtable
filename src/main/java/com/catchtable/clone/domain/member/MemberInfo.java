package com.catchtable.clone.domain.member;
import lombok.Getter;

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

    public MemberInfo(){
        //로그인 실패 시 Member 객체가 null로 반환되었을 때
        this.id = (long) -1;
        this.memberToken = "";
        this.name = "";
        this.phone = "";
        this.password = "";
        this.nickname = "";
        this.status = Member.Status.DISABLE;
    }
}
