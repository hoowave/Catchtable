package com.catchtable.clone.reserve.interfaces.dto;
import com.catchtable.clone.reserve.domain.info.ShopReserveInfo;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;

public class ShopReserveInfoListDto {
    @Getter
    @ToString
    public static class response {
        HashMap<Integer, ShopReserveInfo> reserveInfo = new HashMap<>();

        public response(List<ShopReserveInfo> shopReserveInfoList) {
            for (int i = 0; i < shopReserveInfoList.size(); i++) {
                reserveInfo.put(i, shopReserveInfoList.get(i));
            }
        }
    }
}
