package com.catchtable.clone.shop.infrastructure;

import com.catchtable.clone.shop.domain.Shop;
import com.catchtable.clone.shop.domain.info.ShopInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ShopDao {
    Long shopStore(Shop initShop);

    Long shopInformationStore(ShopInformation initShopInformation);

    Optional<Shop> login(Shop initShop);
    Optional<String> ShopIdToShopToken(String shopName);
}
