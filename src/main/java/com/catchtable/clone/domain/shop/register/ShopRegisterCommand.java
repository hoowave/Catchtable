package com.catchtable.clone.domain.shop.register;

import com.catchtable.clone.domain.shop.Category;
import com.catchtable.clone.domain.shop.Shop;
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
