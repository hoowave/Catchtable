package com.catchtable.clone.shop.domain.reserve.domain.command;

import com.catchtable.clone.shop.domain.reserve.domain.ShopReserveMenu;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@Builder
@ToString
public class ShopReserveMenuRegisterCommand {
    private final String shopToken;
    private final ShopReserveMenu.Type type;
    private final String reserveMenu;
    private final String reserveMenuIntro;
    private final int reserveMenuPrice;
    private final LocalTime startAt;
    private final LocalTime lastAt;

    public ShopReserveMenu toEntity() {
        return ShopReserveMenu.builder()
                .shopToken(shopToken)
                .type(type)
                .reserveMenu(reserveMenu)
                .reserveMenuIntro(reserveMenuIntro)
                .reserveMenuPrice(reserveMenuPrice)
                .startAt(startAt)
                .lastAt(lastAt)
                .build();
    }
}
