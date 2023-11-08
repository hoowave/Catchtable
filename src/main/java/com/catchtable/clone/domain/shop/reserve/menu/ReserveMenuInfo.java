package com.catchtable.clone.domain.shop.reserve.menu;

import lombok.Getter;

import java.sql.Time;

@Getter
public class ReserveMenuInfo {
    private final Long id;
    private final String shopToken;
    private final ReserveMenu.Type type;
    private final String reserveMenu;
    private final String reserveMenuIntro;
    private final int reserveMenuPrice;
    private final Time startAt;
    private final Time lastAt;

    public ReserveMenuInfo(ReserveMenu reserveMenu) {
        this.id = reserveMenu.getId();
        this.shopToken = reserveMenu.getShopToken();
        this.type = reserveMenu.getType();
        this.reserveMenu = reserveMenu.getReserveMenu();
        this.reserveMenuIntro = reserveMenu.getReserveMenuIntro();
        this.reserveMenuPrice = reserveMenu.getReserveMenuPrice();
        this.startAt = reserveMenu.getStartAt();
        this.lastAt = reserveMenu.getLastAt();
    }
}