package com.catchtable.clone.shop.domain.reserve.domain.info;

import com.catchtable.clone.shop.domain.reserve.domain.ShopReserveMenu;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class ShopReserveMenuInfo {
    private final Long id;
    private final String shopToken;
    private final ShopReserveMenu.Type type;
    private final String reserveMenu;
    private final String reserveMenuIntro;
    private final int reserveMenuPrice;
    private final LocalTime startAt;
    private final LocalTime lastAt;

    public ShopReserveMenuInfo(ShopReserveMenu reserveMenu) {
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
