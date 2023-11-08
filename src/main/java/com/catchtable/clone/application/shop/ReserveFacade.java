package com.catchtable.clone.application.shop;

import com.catchtable.clone.domain.shop.reserve.menu.ReserveMenuInfo;
import com.catchtable.clone.domain.shop.reserve.menu.ReserveMenuService;
import com.catchtable.clone.domain.shop.reserve.menu.register.ReserveMenuRegisterCommand;
import com.catchtable.clone.domain.shop.reserve.personnel.ReservePersonnelInfo;
import com.catchtable.clone.domain.shop.reserve.personnel.register.ReservePersonnelRegisterCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReserveFacade {

    private final ReserveMenuService reserveMenuService;

    public ReserveMenuInfo registerReserveMenu(ReserveMenuRegisterCommand reserveMenuRegisterCommand) {
        var reserveInfo = reserveMenuService.menuRegister(reserveMenuRegisterCommand);
        return reserveInfo;
    }

    public ReservePersonnelInfo registerReservePersonnel(ReservePersonnelRegisterCommand reservePersonnelRegisterCommand) {
        var reserveInfo = reserveMenuService.personnelRegister(reservePersonnelRegisterCommand);
        return reserveInfo;
    }

}
