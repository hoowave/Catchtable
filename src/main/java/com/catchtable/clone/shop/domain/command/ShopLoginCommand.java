package com.catchtable.clone.shop.domain.command;

import com.catchtable.clone.shop.domain.Shop;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ShopLoginCommand {
    private String shopId;
    private String shopPw;

    public Shop toEntity() {
        return new Shop(shopId, shopPw);
    }
}
