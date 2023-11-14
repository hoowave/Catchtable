package com.catchtable.clone.domain.shop.reserve.personnel.register;

import com.catchtable.clone.domain.shop.reserve.personnel.ReservePersonnel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Time;

@Getter
@Builder
@ToString
public class ReservePersonnelRegisterCommand {
    private final String shopToken;
    private final Time reserveAt;
    private final int personnel;

    public ReservePersonnel toEntity() {
        return ReservePersonnel.builder()
                .shopToken(shopToken)
                .reserveAt(reserveAt)
                .personnel(personnel)
                .build();
    }
}
