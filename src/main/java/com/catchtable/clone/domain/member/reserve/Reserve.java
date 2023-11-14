package com.catchtable.clone.domain.member.reserve;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Getter
@NoArgsConstructor
@ToString
public class Reserve {
    private Long id;
    private String memberToken;
    private String shopToken;
    private LocalDateTime reserveAt;
    private int personnel;
    private Long reserveMenu;
    private visit visit;
    private String message;

    @Getter
    @RequiredArgsConstructor
    public enum visit {
        Y("방문"), N("미방문");
        private final String description;
    }

    public void visitY() {
        this.visit = visit.Y;
    }

    public void visitN() {
        this.visit = visit.N;
    }

    @Builder
    public Reserve(String memberToken, String shopToken,
                   LocalDateTime reserveAt, Long reserveMenu,
                   int personnel, String message) {
        this.memberToken = memberToken;
        this.shopToken = shopToken;
        this.reserveAt = reserveAt;
        this.reserveMenu = reserveMenu;
        this.personnel = personnel;
        this.visit = visit.N;
        this.message = message;
    }

}
