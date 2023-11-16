package com.catchtable.clone.shop.domain.info;

import com.catchtable.clone.shop.domain.Category;
import com.catchtable.clone.shop.domain.Shop;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShopInfo {
    private final Long id;
    private final String shopToken;
    private final String shopId;
    private final Category category;
    private final String shopName;
    private final String shopIntroduction;
    private final LocalDateTime createdAt;

    public ShopInfo(Shop shop) {
        this.id = shop.getId();
        this.shopToken = shop.getShopToken();
        this.shopId = shop.getShopId();
        this.category = shop.getCategory();
        this.shopName = shop.getShopName();
        this.shopIntroduction = shop.getShopIntroduction();
        this.createdAt = shop.getCreatedAt();
    }
}
