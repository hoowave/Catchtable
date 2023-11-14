package com.catchtable.clone.domain.shop.reserve.personnel;

import lombok.Getter;

import java.sql.Time;

@Getter
public class ReservePersonnelInfo {
    private String shopToken;
    private Time reserveAt;
    private int personnel;

    public ReservePersonnelInfo(ReservePersonnel reservePersonnel) {
        this.shopToken = reservePersonnel.getShopToken();
        this.reserveAt = reservePersonnel.getReserveAt();
        this.personnel = reservePersonnel.getPersonnel();
    }
}
