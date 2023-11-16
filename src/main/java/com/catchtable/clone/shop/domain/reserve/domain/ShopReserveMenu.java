package com.catchtable.clone.shop.domain.reserve.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;
import java.time.LocalTime;

@Slf4j
@Getter
@NoArgsConstructor
@ToString
public class ShopReserveMenu {
    private Long id;
    private String shopToken;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Size(max = 100, message = "메뉴이름은 최대 100자로 입력해주세요.")
    private String reserveMenu;
    @Size(max = 300, message = "메뉴이름은 최대 300자로 입력해주세요.")
    private String reserveMenuIntro;
    private int reserveMenuPrice;
    private LocalTime startAt;
    private LocalTime lastAt;


    @Getter
    @RequiredArgsConstructor
    public enum Type {
        MAIN("메인메뉴"), SINGLE("단품메뉴");
        private final String description;
    }

    @Builder
    public ShopReserveMenu(String shopToken, Type type, String reserveMenu, String reserveMenuIntro,
                           int reserveMenuPrice, LocalTime startAt, LocalTime lastAt) {
        this.shopToken = shopToken;
        this.type = type;
        this.reserveMenu = reserveMenu;
        this.reserveMenuIntro = reserveMenuIntro;
        this.reserveMenuPrice = reserveMenuPrice;
        this.startAt = startAt;
        this.lastAt = lastAt;
    }

}
