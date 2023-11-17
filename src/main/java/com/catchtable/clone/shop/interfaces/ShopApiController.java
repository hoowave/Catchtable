package com.catchtable.clone.shop.interfaces;

import com.catchtable.clone.shop.ShopFacade;
import com.catchtable.clone.common.response.CommonResponse;
import com.catchtable.clone.common.response.ErrorCode;
import com.catchtable.clone.shop.interfaces.dto.ShopLoginDto;
import com.catchtable.clone.shop.interfaces.dto.ShopRegisterDto;
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
        var response = new ShopLoginDto.LoginResponse(shopInfo);
        session.setAttribute("shop", response);
        return CommonResponse.success(response);
    }

    @GetMapping("/info")
    public CommonResponse infoShop(HttpSession session) {
        shopFacade.loginCheck(session);
        return CommonResponse.success(session.getAttribute("shop"));
    }

    @GetMapping("/logout")
    public CommonResponse logoutShop(HttpSession session) {
        shopFacade.loginCheck(session);
        session.invalidate();
        return CommonResponse.success(ErrorCode.SHOP_LOGOUT);
    }
}
