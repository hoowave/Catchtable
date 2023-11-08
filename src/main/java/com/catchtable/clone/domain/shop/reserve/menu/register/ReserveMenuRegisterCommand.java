package com.catchtable.clone.domain.shop.reserve.menu.register;

import com.catchtable.clone.domain.shop.reserve.menu.ReserveMenu;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Time;

@Getter
@Builder
@ToString
public class ReserveMenuRegisterCommand {
    private final String shopToken;
    private final ReserveMenu.Type type;
    private final String reserveMenu;
    private final String reserveMenuIntro;
    private final int reserveMenuPrice;
    private final Time startAt;
    private final Time lastAt;

    public ReserveMenu toEntity() {
        return ReserveMenu.builder()
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
