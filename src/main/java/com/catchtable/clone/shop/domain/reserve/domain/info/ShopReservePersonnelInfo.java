package com.catchtable.clone.shop.domain.reserve.domain.info;

import com.catchtable.clone.shop.domain.reserve.domain.ShopReservePersonnel;
import lombok.Getter;

import java.sql.Time;

@Getter
public class ShopReservePersonnelInfo {
    private String shopToken;
    private Time reserveAt;
    private int personnel;

    public ShopReservePersonnelInfo(ShopReservePersonnel reservePersonnel) {
        this.shopToken = reservePersonnel.getShopToken();
        this.reserveAt = reservePersonnel.getReserveAt();
        this.personnel = reservePersonnel.getPersonnel();
    }
}
