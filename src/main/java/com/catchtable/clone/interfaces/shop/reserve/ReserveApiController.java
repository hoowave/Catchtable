package com.catchtable.clone.interfaces.shop.reserve;

import com.catchtable.clone.application.shop.ReserveFacade;
import com.catchtable.clone.common.response.CommonResponse;
import com.catchtable.clone.common.response.ErrorCode;
import com.catchtable.clone.domain.shop.Shop;
import com.catchtable.clone.domain.shop.ShopInfo;
import com.catchtable.clone.interfaces.shop.ShopLoginDto;
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
@RequestMapping("/api/v1/shop/reserve")
public class ReserveApiController {

    private final ReserveFacade reserveFacade;

    @PostMapping("/menu/register")
    public CommonResponse registerReserveMenu(HttpSession session,
                                              @RequestBody @Valid ReserveMenuRegisterDto.request request) {
        var shopInfo = (ShopLoginDto.LoginResponse) session.getAttribute("shop");
        if (shopInfo != null) {
            var reserveMenuCommand = request.toCommand(shopInfo.getShopToken());
            var reserveMenuInfo = reserveFacade.registerReserveMenu(reserveMenuCommand);
            var response = new ReserveMenuRegisterDto.response(reserveMenuInfo);
            return CommonResponse.success(response);
        } else {
            return CommonResponse.fail(ErrorCode.SHOP_NEED_LOGIN);
        }
    }

    @PostMapping("/personnel/register")
    public CommonResponse registerReservePersonnel(HttpSession session,
                                                   @RequestBody @Valid ReservePersonnelRegisterDto.request request) {
        var shopInfo = (ShopLoginDto.LoginResponse) session.getAttribute("shop");
        if (shopInfo != null) {
            var reservePersonnelCommand = request.toCommand(shopInfo.getShopToken());
            var reservePersonnelInfo = reserveFacade.registerReservePersonnel(reservePersonnelCommand);
            var response = new ReservePersonnelRegisterDto.response(reservePersonnelInfo);
            return CommonResponse.success(response);
        } else {
            return CommonResponse.fail(ErrorCode.SHOP_NEED_LOGIN);
        }
    }
}
