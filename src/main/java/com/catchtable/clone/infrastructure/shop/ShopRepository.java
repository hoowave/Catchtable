package com.catchtable.clone.infrastructure.shop;

import com.catchtable.clone.domain.shop.Shop;
import com.catchtable.clone.domain.shop.ShopInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ShopRepository {
    Long shopStore(Shop initShop);

    Long shopInformationStore(ShopInformation initShopInformation);

    Optional<Shop> login(Shop initShop);
}
