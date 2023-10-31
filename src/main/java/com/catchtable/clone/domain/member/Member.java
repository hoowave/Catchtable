package com.catchtable.clone.domain.member;

import com.catchtable.clone.common.util.TokenGenerator;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Slf4j
@Getter
@NoArgsConstructor
@ToString
public class Member {
    private static final String PREFIX_MEMBER = "mb_";

    private Long id;
    private String memberToken;
    private String name;
    private String phone;
    private String password;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String loginId;
    private String loginPw;


    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("사용계정"), DISABLE("휴먼계정");
        private final String description;
    }

    @Builder
    public Member(String name, String phone, String password, String nickname) {
        if (StringUtils.isEmpty(name)) System.out.println("empty Name");
        if (StringUtils.isEmpty(phone)) System.out.println("empty Phone");
        if (StringUtils.isEmpty(password)) System.out.println("empty Password");


        this.memberToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_MEMBER);
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.nickname = nickname;
        this.status = Status.ENABLE;
        this.createdAt = LocalDateTime.now();
    }

    public Member(String loginId, String loginPw){
        if (StringUtils.isEmpty(loginId)) System.out.println("empty loginId");
        if (StringUtils.isEmpty(loginPw)) System.out.println("empty loginPw");

        this.loginId = loginId;
        this.loginPw = loginPw;
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }
}
