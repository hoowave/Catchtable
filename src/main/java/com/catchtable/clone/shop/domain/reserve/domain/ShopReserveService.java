package com.catchtable.clone.shop.domain.reserve.domain;

import com.catchtable.clone.shop.domain.reserve.domain.info.ShopReserveMenuInfo;
import com.catchtable.clone.shop.domain.reserve.domain.command.ShopReserveMenuRegisterCommand;
import com.catchtable.clone.shop.domain.reserve.domain.info.ShopReservePersonnelInfo;
import com.catchtable.clone.shop.domain.reserve.domain.command.ShopReservePersonnelRegisterCommand;

public interface ShopReserveService {

    ShopReserveMenuInfo menuRegister(ShopReserveMenuRegisterCommand reserveMenuRegisterCommand);

    ShopReservePersonnelInfo personnelRegister(ShopReservePersonnelRegisterCommand reservePersonnelRegisterCommand);
}
