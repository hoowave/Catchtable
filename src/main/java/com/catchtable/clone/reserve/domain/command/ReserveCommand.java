package com.catchtable.clone.reserve.domain.command;

import com.catchtable.clone.reserve.domain.Reserve;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class ReserveCommand {
    private final String memberToken;
    private final String shopToken;
    private final LocalDateTime reserveAt;
    private final int personnel;
    private final Long reserveMenu;
    private final String message;

    public Reserve toEntity() {
        return Reserve.builder()
                .memberToken(memberToken)
                .shopToken(shopToken)
                .reserveAt(reserveAt)
                .personnel(personnel)
                .reserveMenu(reserveMenu)
                .message(message)
                .build();
    }
}
