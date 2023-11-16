package com.catchtable.clone.shop.domain;

import com.catchtable.clone.common.response.ErrorCode;
import com.catchtable.clone.shop.domain.info.ShopInfo;
import com.catchtable.clone.shop.domain.command.ShopLoginCommand;
import com.catchtable.clone.shop.domain.command.ShopInformationRegisterCommand;
import com.catchtable.clone.shop.domain.command.ShopRegisterCommand;
import com.catchtable.clone.shop.infrastructure.ShopDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopDao shopDao;

    @Override
    @Transactional
    public ShopInfo registerShop(ShopRegisterCommand shopRegisterCommand,
                                 ShopInformationRegisterCommand shopInformationRegisterCommand) {
        var initShop = shopRegisterCommand.toEntity();
        var initShopInformation = shopInformationRegisterCommand.toEntity(initShop.getShopToken());
        shopDao.shopStore(initShop);
        shopDao.shopInformationStore(initShopInformation);
        return new ShopInfo(initShop);
    }

    @Override
    @Transactional
    public ShopInfo loginShop(ShopLoginCommand shopLoginCommand) {
        var initShop = shopLoginCommand.toEntity();
        Optional<Shop> shop = shopDao.login(initShop);
        if (!shop.isEmpty()) return new ShopInfo(shop.get());
        else throw new ShopException(ErrorCode.SHOP_NOT_FOUND);
    }

    @Override
    public void loginCheck(HttpSession session) {
        if (session.getAttribute("shop") == null) {
            throw new ShopException(ErrorCode.SHOP_NEED_LOGIN);
        }
    }

    @Override
    public String ShopIdToShopToken(String shopId) {
        Optional<String> shopToken = shopDao.ShopIdToShopToken(shopId);
        if (shopToken.isEmpty()) {
            throw new ShopException(ErrorCode.SHOP_TOKEN_NOT_FOUND);
        }
        return shopToken.get();
    }

}
