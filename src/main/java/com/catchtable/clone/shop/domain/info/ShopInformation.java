package com.catchtable.clone.shop.domain.info;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor
@ToString
public class ShopInformation {
    // tbl_shop_information
    private Long id;
    private String shopToken;
    private String phone;
    private String infoIntroduction;
    private String opening;
    private String holiday;
    private String instruction;
    private String homepage;

    @Builder
    public ShopInformation(String shopToken,
                           String phone,
                           String infoIntroduction,
                           String opening,
                           String holiday,
                           String instruction,
                           String homepage) {
        this.shopToken = shopToken;
        this.phone = phone;
        this.infoIntroduction = infoIntroduction;
        this.opening = opening;
        this.holiday = holiday;
        this.instruction = instruction;
        this.homepage = homepage;
    }
}
