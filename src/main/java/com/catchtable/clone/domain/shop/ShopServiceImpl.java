package com.catchtable.clone.domain.shop;

import com.catchtable.clone.domain.shop.login.ShopLoginCommand;
import com.catchtable.clone.domain.shop.register.ShopInformationRegisterCommand;
import com.catchtable.clone.domain.shop.register.ShopRegisterCommand;
import com.catchtable.clone.infrastructure.shop.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    @Override
    @Transactional
    public ShopInfo registerShop(ShopRegisterCommand shopRegisterCommand,
                                 ShopInformationRegisterCommand shopInformationRegisterCommand) {
        var initShop = shopRegisterCommand.toEntity();
        var initShopInformation = shopInformationRegisterCommand.toEntity(initShop.getShopToken());
        shopRepository.shopStore(initShop);
        shopRepository.shopInformationStore(initShopInformation);
        return new ShopInfo(initShop);
    }

    @Override
    @Transactional
    public ShopInfo loginShop(ShopLoginCommand shopLoginCommand) {
        var initShop = shopLoginCommand.toEntity();
        Optional<Shop> shop = shopRepository.login(initShop);
        if (!shop.isEmpty()) {
            return new ShopInfo(shop.get());
        } else {
            return new ShopInfo();
        }
    }
}
