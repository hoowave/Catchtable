package com.catchtable.clone.shop;

import com.catchtable.clone.shop.domain.info.ShopInfo;
import com.catchtable.clone.shop.domain.command.ShopLoginCommand;
import com.catchtable.clone.shop.domain.command.ShopInformationRegisterCommand;
import com.catchtable.clone.shop.domain.command.ShopRegisterCommand;
import com.catchtable.clone.shop.domain.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopFacade {
    private final ShopService shopService;

    public ShopInfo registerShop(ShopRegisterCommand shopRegisterCommand,
                                 ShopInformationRegisterCommand shopInformationRegisterCommand) {
        var shopInfo = shopService.registerShop(shopRegisterCommand, shopInformationRegisterCommand);
        return shopInfo;
    }

    public ShopInfo loginShop(ShopLoginCommand shopLoginCommand) {
        var shopInfo = shopService.loginShop(shopLoginCommand);
        return shopInfo;
    }

    public String ShopIdToShopToken(String shopId) {
        String shopToken = shopService.ShopIdToShopToken(shopId);
        return shopToken;
    }

    public void loginCheck(HttpSession session) {
        shopService.loginCheck(session);
    }

}
