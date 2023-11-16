package com.catchtable.clone.shop.domain.reserve.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.sql.Time;

@Slf4j
@Getter
@NoArgsConstructor
@ToString
public class ShopReservePersonnel {
    private Long id;
    private String shopToken;
    private Time reserveAt;
    private int personnel;

    @Builder
    public ShopReservePersonnel(String shopToken, Time reserveAt, int personnel) {
        this.shopToken = shopToken;
        this.reserveAt = reserveAt;
        this.personnel = personnel;
    }

}
