package com.catchtable.clone.members.interfaces;

import com.catchtable.clone.members.MemberFacade;
import com.catchtable.clone.common.response.CommonResponse;
import com.catchtable.clone.common.response.ErrorCode;
import com.catchtable.clone.members.interfaces.dto.MemberLoginDto;
import com.catchtable.clone.members.interfaces.dto.MemberRegisterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberApiController {
    private final MemberFacade memberFacade;

    @RequestMapping("/register")
    @PostMapping
    public CommonResponse registerMember(@RequestBody @Valid MemberRegisterDto.RegisterRequest request) {
        var memberCommand = request.toMemberCommand();
        var termsCommand = request.toTermsCommand();
        var memberInfo = memberFacade.registerMember(memberCommand, termsCommand);
        var response = new MemberRegisterDto.RegisterResponse(memberInfo);
        return CommonResponse.success(response);
    }

    @RequestMapping("/login")
    @PostMapping
    public CommonResponse loginMember(@RequestBody @Valid MemberLoginDto.LoginRequest request, HttpSession session) {
        var command = request.toCommand();
        var memberInfo = memberFacade.loginMember(command);
        var response = new MemberLoginDto.LoginResponse(memberInfo);
        session.setAttribute("member", response);
        return CommonResponse.success(session.getAttribute("member"));
    }

    @GetMapping("/info")
    public CommonResponse infoMember(HttpSession session) {
        memberFacade.loginCheck(session);
        return CommonResponse.success(session.getAttribute("member"));
    }

    @GetMapping("/logout")
    public CommonResponse logoutMember(HttpSession session) {
        memberFacade.loginCheck(session);
        session.invalidate();
        return CommonResponse.success(ErrorCode.MEMBER_LOGOUT);
    }
}
