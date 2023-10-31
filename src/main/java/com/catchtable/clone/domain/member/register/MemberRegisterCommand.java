package com.catchtable.clone.domain.member.register;
import com.catchtable.clone.domain.member.Member;
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

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .phone(phone)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
