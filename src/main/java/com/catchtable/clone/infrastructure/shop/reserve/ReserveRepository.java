package com.catchtable.clone.infrastructure.shop.reserve;

import com.catchtable.clone.domain.shop.reserve.menu.ReserveMenu;
import com.catchtable.clone.domain.shop.reserve.personnel.ReservePersonnel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReserveRepository {
    Long reserveMenuStore(ReserveMenu initReserveMenu);

    Long reservePersonnelStore(ReservePersonnel initReservePersonnel);
}
