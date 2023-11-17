package com.catchtable.clone.shop.domain.reserve;

import com.catchtable.clone.shop.domain.reserve.domain.info.ShopReserveMenuInfo;
import com.catchtable.clone.shop.domain.reserve.domain.ShopReserveService;
import com.catchtable.clone.shop.domain.reserve.domain.command.ShopReserveMenuRegisterCommand;
import com.catchtable.clone.shop.domain.reserve.domain.info.ShopReservePersonnelInfo;
import com.catchtable.clone.shop.domain.reserve.domain.command.ShopReservePersonnelRegisterCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopReserveFacade {

    private final ShopReserveService reserveService;

    public ShopReserveMenuInfo registerReserveMenu(ShopReserveMenuRegisterCommand reserveMenuRegisterCommand) {
        var reserveInfo = reserveService.menuRegister(reserveMenuRegisterCommand);
        return reserveInfo;
    }

    public ShopReservePersonnelInfo registerReservePersonnel(ShopReservePersonnelRegisterCommand reservePersonnelRegisterCommand) {
        var reserveInfo = reserveService.personnelRegister(reservePersonnelRegisterCommand);
        return reserveInfo;
    }

}
