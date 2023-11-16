package com.catchtable.clone.shop.domain.command;

import com.catchtable.clone.shop.domain.Category;
import com.catchtable.clone.shop.domain.Shop;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ShopRegisterCommand {
    private final String shopId;
    private final String shopPw;
    private final Category category;
    private final String shopName;
    private final String shopIntroduction;

    public Shop toEntity() {
        return Shop.builder()
                .shopId(shopId)
                .shopPw(shopPw)
                .category(category)
                .shopName(shopName)
                .shopIntroduction(shopIntroduction)
                .build();
    }
}
