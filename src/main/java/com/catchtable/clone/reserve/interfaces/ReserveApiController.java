package com.catchtable.clone.reserve.interfaces;

import com.catchtable.clone.common.response.CommonResponse;
import com.catchtable.clone.common.response.ErrorCode;
import com.catchtable.clone.members.MemberFacade;
import com.catchtable.clone.members.interfaces.dto.MemberLoginDto;
import com.catchtable.clone.reserve.ReserveFacade;
import com.catchtable.clone.reserve.interfaces.dto.ReserveDto;
import com.catchtable.clone.reserve.interfaces.dto.ReserveInfoListDto;
import com.catchtable.clone.shop.ShopFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reserve")
public class ReserveApiController {
    private final MemberFacade memberFacade;
    private final ShopFacade shopFacade;
    private final ReserveFacade reserveFacade;

    @PostMapping("/info")
    public CommonResponse reserveInfo(HttpSession session) {
        memberFacade.loginCheck(session);
        var memberInfo = (MemberLoginDto.LoginResponse) session.getAttribute("member");
        var reserveInfoList = reserveFacade.reserveInfo(memberInfo.getMemberToken());
        var response = new ReserveInfoListDto.response(reserveInfoList);
        return CommonResponse.success(response);
    }

    @PostMapping("/reserve")
    public void reserve(HttpSession session,
                                  @RequestBody @Valid ReserveDto.request request) {
        memberFacade.loginCheck(session);
        var memberInfo = (MemberLoginDto.LoginResponse) session.getAttribute("member");
        String memberToken = memberInfo.getMemberToken();
        String shopToken = shopFacade.ShopIdToShopToken(request.getShopId());
        var reserveCommand = request.toCommand(memberToken, shopToken);
        var reserveInfo = reserveFacade.reserve(reserveCommand);
//        switch (reserveInfo.getErrorCode()) {
//            case -1:
//                return CommonResponse.fail(ErrorCode.SHOP_TOKEN_NOT_FOUND);
//            case -2:
//                return CommonResponse.fail(ErrorCode.RESERVE_NOT_AVAILABLE_PERSONNEL);
//            default:
//                var response = new ReserveDto.response(reserveInfo);
//                return CommonResponse.success(response);
//        }
    }
}
