package com.catchtable.clone.interfaces.member;

import com.catchtable.clone.domain.member.reserve.Reserve;
import com.catchtable.clone.domain.member.reserve.ReserveCommand;
import com.catchtable.clone.domain.member.reserve.ReserveInfo;
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

        public ReserveCommand toCommand(String memberToken) {
            return ReserveCommand.builder()
                    .memberToken(memberToken)
                    .shopId(shopId)
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
