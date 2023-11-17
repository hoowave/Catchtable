package com.catchtable.clone.shop.domain;

import com.catchtable.clone.common.exception.BaseException;
import com.catchtable.clone.common.response.ErrorCode;

public class ShopException extends BaseException {

    public ShopException(ErrorCode errorCode) {
        super(errorCode);
    }
}
