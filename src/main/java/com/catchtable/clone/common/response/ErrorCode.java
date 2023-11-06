package com.catchtable.clone.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."), // 장애 상황
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),
    COMMON_ENTITY_NOT_FOUND("존재하지 않는 엔티티입니다."),
    COMMON_ILLEGAL_STATUS("잘못된 상태값입니다."),

    // MEMBER
    MEMBER_NOT_FOUND("아이디 또는 비밀번호를 확인해주세요."),
    MEMBER_NEED_LOGIN("로그인이 필요합니다."),
    MEMBER_LOGOUT("로그아웃 되었습니다."),

    // SHOP
    SHOP_NOT_FOUND("아이디 또는 비밀번호를 확인해주세요."),
    SHOP_NEED_LOGIN("로그인이 필요합니다."),
    SHOP_LOGOUT("로그아웃 되었습니다.");

    private final String errorMsg;

    public String getErrorMsg(Object... arg) {
        return String.format(errorMsg, arg);
    }
}
