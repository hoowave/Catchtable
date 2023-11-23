package com.catchtable.clone.reserve.interfaces.dto;

import com.catchtable.clone.reserve.domain.info.MemberReserveInfo;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;

public class MemberReserveInfoListDto {
    @Getter
    @ToString
    public static class response {
        HashMap<Integer, MemberReserveInfo> reserveInfo = new HashMap<>();

        public response(List<MemberReserveInfo> memberReserveInfoList) {
            for (int i = 0; i < memberReserveInfoList.size(); i++) {
                reserveInfo.put(i, memberReserveInfoList.get(i));
            }
        }
    }
}
