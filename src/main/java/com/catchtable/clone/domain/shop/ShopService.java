package com.catchtable.clone.domain.shop;

import com.catchtable.clone.domain.shop.login.ShopLoginCommand;
import com.catchtable.clone.domain.shop.register.ShopInformationRegisterCommand;
import com.catchtable.clone.domain.shop.register.ShopRegisterCommand;

public interface ShopService {
    ShopInfo registerShop(ShopRegisterCommand shopRegisterCommand,
                          ShopInformationRegisterCommand shopInformationRegisterCommand);

    ShopInfo loginShop(ShopLoginCommand shopLoginCommand);
}
