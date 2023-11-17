package com.catchtable.clone.reserve.domain.info;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberReserveInfo {
    private String shopName;
    private LocalDateTime reserveAt;
    private int personnel;
    private String reserveMenu;
    private int reserveMenuPrice;
    private String visit;
    private String message;
}
