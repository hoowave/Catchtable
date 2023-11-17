package com.catchtable.clone.members.domain;

import com.catchtable.clone.common.util.TokenGenerator;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Slf4j
@Getter
@NoArgsConstructor
@ToString
public class Member {
    private static final String PREFIX_MEMBER = "mb_";

    private Long id;
    private String memberToken;
    @Size(min = 2, max = 5, message = "ERROR name")
    private String name;
    @Size(min = 10, max = 12, message = "ERROR phone")
    private String phone;
    @Pattern(regexp = "^(?:(?=.*[A-Za-z])(?=.*[0-9])|(?=.*[A-Za-z])(?=.*[^A-Za-z0-9])|(?=.*[0-9])(?=.*[^A-Za-z0-9])).{8,20}$",
            message = "ERROR Password")
    private String password;
    @Size(max = 10, message = "ERROR nickname")
    private String nickname;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @NotEmpty(message = "name 또는 phone 은 필수값입니다.")
    private String loginId;
    @NotEmpty(message = "password 는 필수값입니다.")
    private String loginPw;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("사용계정"), DISABLE("휴먼계정");
        private final String description;
    }

    @Builder
    public Member(String name, String phone, String password, String nickname) {
        this.memberToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_MEMBER);
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.nickname = nickname;
        this.status = Status.ENABLE;
        this.createdAt = LocalDateTime.now();
    }

    public Member(String loginId, String loginPw){
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
