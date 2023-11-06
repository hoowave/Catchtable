package com.catchtable.clone.domain.shop.register;

import com.catchtable.clone.domain.shop.Shop;
import com.catchtable.clone.domain.shop.ShopInformation;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ShopInformationRegisterCommand {
    private String shopToken;
    private final String phone;
    private final String infoIntroduction;
    private final String opening;
    private final String holiday;
    private final String instruction;
    private final String homepage;

    public ShopInformation toEntity(String shopToken) {
        return ShopInformation.builder()
                .shopToken(shopToken)
                .phone(phone)
                .infoIntroduction(infoIntroduction)
                .opening(opening)
                .holiday(holiday)
                .instruction(instruction)
                .homepage(homepage)
                .build();
    }
}
