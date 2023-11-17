package com.catchtable.clone.shop.domain;

import com.catchtable.clone.shop.domain.info.ShopInfo;
import com.catchtable.clone.shop.domain.command.ShopLoginCommand;
import com.catchtable.clone.shop.domain.command.ShopInformationRegisterCommand;
import com.catchtable.clone.shop.domain.command.ShopRegisterCommand;

import javax.servlet.http.HttpSession;

public interface ShopService {
    ShopInfo registerShop(ShopRegisterCommand shopRegisterCommand,
                          ShopInformationRegisterCommand shopInformationRegisterCommand);

    ShopInfo loginShop(ShopLoginCommand shopLoginCommand);

    void loginCheck(HttpSession session);

    String ShopIdToShopToken(String shopId);

}
