package com.catchtable.clone.domain.shop.reserve.menu;

import com.catchtable.clone.domain.shop.reserve.menu.register.ReserveMenuRegisterCommand;
import com.catchtable.clone.domain.shop.reserve.personnel.ReservePersonnelInfo;
import com.catchtable.clone.domain.shop.reserve.personnel.register.ReservePersonnelRegisterCommand;

public interface ReserveMenuService {
    ReserveMenuInfo menuRegister(ReserveMenuRegisterCommand reserveMenuRegisterCommand);

    ReservePersonnelInfo personnelRegister(ReservePersonnelRegisterCommand reservePersonnelRegisterCommand);
}
