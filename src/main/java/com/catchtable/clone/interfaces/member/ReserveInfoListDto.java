package com.catchtable.clone.interfaces.member;

import com.catchtable.clone.domain.member.MemberReserveInfo;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;

public class ReserveInfoListDto {
    @Getter
    @ToString
    public static class response {
        LinkedHashMap<Integer, MemberReserveInfo> map = new LinkedHashMap<>();

        public response(List<MemberReserveInfo> memberReserveInfoList) {
            for (int i = 0; i < memberReserveInfoList.size(); i++) {
                map.put(i, memberReserveInfoList.get(i));
            }

        }
    }
}
