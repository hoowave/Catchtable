package com.catchtable.clone.interfaces.shop;

import com.catchtable.clone.application.shop.ShopFacade;
import com.catchtable.clone.common.response.CommonResponse;
import com.catchtable.clone.common.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shop")
public class ShopApiController {
    private final ShopFacade shopFacade;

    @PostMapping("/register")
    public CommonResponse registerShop(@RequestBody @Valid ShopRegisterDto.registerRequest request) {
        var shopCommand = request.toShopCommand();
        var ShopInformationCommand = request.toShopInformationCommand();
        var shopInfo = shopFacade.registerShop(shopCommand, ShopInformationCommand);
        var response = new ShopRegisterDto.RegisterResponse(shopInfo);
        return CommonResponse.success(response);
    }

    @PostMapping("/login")
    public CommonResponse loginShop(@RequestBody @Valid ShopLoginDto.LoginRequest request, HttpSession session) {
        var command = request.toCommand();
        var shopInfo = shopFacade.loginShop(command);
        if (shopInfo.getId() != -1) {
            var response = new ShopLoginDto.LoginResponse(shopInfo);
            session.setAttribute("shop", response);
            return CommonResponse.success(response);
        } else {
            return CommonResponse.fail(ErrorCode.SHOP_NOT_FOUND);
        }
    }

    @GetMapping("/info")
    public CommonResponse infoShop(HttpSession session) {
        if (session.getAttribute("shop") != null) {
            return CommonResponse.success(session.getAttribute("shop"));
        } else {
            return CommonResponse.fail(ErrorCode.SHOP_NEED_LOGIN);
        }
    }

    @GetMapping("/logout")
    public CommonResponse logoutShop(HttpSession session) {
        if (session.getAttribute("shop") != null) {
            session.invalidate();
            return CommonResponse.success(ErrorCode.SHOP_LOGOUT);
        } else {
            return CommonResponse.fail(ErrorCode.SHOP_NEED_LOGIN);
        }
    }
}
