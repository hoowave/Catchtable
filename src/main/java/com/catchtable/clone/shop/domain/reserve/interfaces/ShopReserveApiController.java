package com.catchtable.clone.shop.domain.reserve.interfaces;

import com.catchtable.clone.shop.ShopFacade;
import com.catchtable.clone.shop.domain.reserve.interfaces.dto.ShopReserveMenuRegisterDto;
import com.catchtable.clone.shop.domain.reserve.interfaces.dto.ShopReservePersonnelRegisterDto;
import com.catchtable.clone.shop.domain.reserve.ShopReserveFacade;
import com.catchtable.clone.common.response.CommonResponse;
import com.catchtable.clone.common.response.ErrorCode;
import com.catchtable.clone.shop.interfaces.dto.ShopLoginDto;
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
public class ShopReserveApiController {

    private final ShopFacade shopFacade;

    private final ShopReserveFacade shopReserveFacade;

    @PostMapping("/menu/register")
    public CommonResponse registerReserveMenu(HttpSession session,
                                              @RequestBody @Valid ShopReserveMenuRegisterDto.request request) {
        shopFacade.loginCheck(session);
        var shopInfo = (ShopLoginDto.LoginResponse) session.getAttribute("shop");
        var reserveMenuCommand = request.toCommand(shopInfo.getShopToken());
        var reserveMenuInfo = shopReserveFacade.registerReserveMenu(reserveMenuCommand);
        var response = new ShopReserveMenuRegisterDto.response(reserveMenuInfo);
        return CommonResponse.success(response);
    }

    @PostMapping("/personnel/register")
    public CommonResponse registerReservePersonnel(HttpSession session,
                                                   @RequestBody @Valid ShopReservePersonnelRegisterDto.request request) {
        shopFacade.loginCheck(session);
        var shopInfo = (ShopLoginDto.LoginResponse) session.getAttribute("shop");
        var reservePersonnelCommand = request.toCommand(shopInfo.getShopToken());
        var reservePersonnelInfo = shopReserveFacade.registerReservePersonnel(reservePersonnelCommand);
        var response = new ShopReservePersonnelRegisterDto.response(reservePersonnelInfo);
        return CommonResponse.success(response);
    }
}
