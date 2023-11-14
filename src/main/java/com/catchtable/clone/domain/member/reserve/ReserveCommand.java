package com.catchtable.clone.domain.member.reserve;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class ReserveCommand {
    private final String memberToken;
    private final String shopId;
    private final LocalDateTime reserveAt;
    private final int personnel;
    private final Long reserveMenu;
    private final String message;

    public Reserve toEntity(String shopToken) {
        return Reserve.builder()
                .memberToken(memberToken)
                // 여기서 shopName -> shopToken으로 Entity 초기화
                .shopToken(shopToken)
                .reserveAt(reserveAt)
                .personnel(personnel)
                .reserveMenu(reserveMenu)
                .message(message)
                .build();
    }
}
