package com.catchtable.clone.reserve.domain.info;

import com.catchtable.clone.reserve.domain.Reserve;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReserveInfo {
    private final Long id;
    private final String memberToken;
    private final String shopToken;
    private final LocalDateTime reserveAt;
    private final int personnel;
    private final Long reserveMenu;
    private final Reserve.visit visit;
    private final String message;
    private final int errorCode;

    public ReserveInfo(Reserve reserve) {
        this.id = reserve.getId();
        this.memberToken = reserve.getMemberToken();
        this.shopToken = reserve.getShopToken();
        this.reserveAt = reserve.getReserveAt();
        this.personnel = reserve.getPersonnel();
        this.reserveMenu = reserve.getReserveMenu();
        this.visit = reserve.getVisit();
        this.message = reserve.getMessage();
        this.errorCode = 0;
    }

    public ReserveInfo(int errorCode) {
        this.id = 0L;
        this.memberToken = "";
        this.shopToken = "";
        this.reserveAt = null;
        this.personnel = 0;
        this.reserveMenu = 0L;
        this.visit = null;
        this.message = "";
        this.errorCode = errorCode;
    }
}
