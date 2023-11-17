package com.catchtable.clone.reserve.interfaces.dto;

import com.catchtable.clone.reserve.domain.Reserve;
import com.catchtable.clone.reserve.domain.command.ReserveCommand;
import com.catchtable.clone.reserve.domain.info.ReserveInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

public class ReserveDto {

    @Getter
    @Setter
    @ToString
    public static class request {
        private String shopId;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        private LocalDateTime reserveAt;
        private int personnel;
        private Long reserveMenu;
        private String message;

        public ReserveCommand toCommand(String memberToken, String shopToken) {
            return ReserveCommand.builder()
                    .memberToken(memberToken)
                    .shopToken(shopToken)
                    .reserveAt(reserveAt)
                    .personnel(personnel)
                    .reserveMenu(reserveMenu)
                    .message(message)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class response {
        private final String memberToken;
        private final String shopToken;
        private final LocalDateTime reserveAt;
        private final int personnel;
        private final Long reserveMenu;
        private final Reserve.visit visit;
        private final String message;
        private final int errorCode;

        public response(ReserveInfo reserveInfo) {
            this.memberToken = reserveInfo.getMemberToken();
            this.shopToken = reserveInfo.getShopToken();
            this.reserveAt = reserveInfo.getReserveAt();
            this.personnel = reserveInfo.getPersonnel();
            this.reserveMenu = reserveInfo.getReserveMenu();
            this.visit = reserveInfo.getVisit();
            this.message = reserveInfo.getMessage();
            this.errorCode = reserveInfo.getErrorCode();
        }
    }
}
