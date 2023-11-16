package com.catchtable.clone.members.domain;

import com.catchtable.clone.common.exception.BaseException;
import com.catchtable.clone.common.response.ErrorCode;

public class MemberException extends BaseException {
    public MemberException(ErrorCode errorCode) {
        super(errorCode);
    }
}
