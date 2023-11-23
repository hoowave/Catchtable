package com.catchtable.clone.reserve.domain.info;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShopReserveInfo {
    private String memberName;
    private LocalDateTime reserveAt;
    private int personnel;
    private String visit;
    private String message;
    private String reserveMenu;
    private int reserveMenuPrice;
}
