package com.catchtable.clone.reserve.domain;

import com.catchtable.clone.common.exception.BaseException;
import com.catchtable.clone.common.response.ErrorCode;

public class ReserveException extends BaseException {
    public ReserveException(ErrorCode errorCode) {
        super(errorCode);
    }
}
