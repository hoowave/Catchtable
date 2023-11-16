package com.catchtable.clone.shop.domain.reserve.infrastructure;

import com.catchtable.clone.shop.domain.reserve.domain.ShopReserveMenu;
import com.catchtable.clone.shop.domain.reserve.domain.ShopReservePersonnel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopReserveDao {
    Long reserveMenuStore(ShopReserveMenu initReserveMenu);

    Long reservePersonnelStore(ShopReservePersonnel initReservePersonnel);
}
