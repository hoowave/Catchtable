package com.catchtable.clone.application.shop;

import com.catchtable.clone.domain.shop.ShopInfo;
import com.catchtable.clone.domain.shop.ShopService;
import com.catchtable.clone.domain.shop.login.ShopLoginCommand;
import com.catchtable.clone.domain.shop.register.ShopInformationRegisterCommand;
import com.catchtable.clone.domain.shop.register.ShopRegisterCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

}
