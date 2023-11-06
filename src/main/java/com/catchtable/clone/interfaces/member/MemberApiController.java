package com.catchtable.clone.interfaces.member;

import com.catchtable.clone.application.member.MemberFacade;
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
        if (memberInfo.getId() != -1) {
            var response = new MemberLoginDto.LoginResponse(memberInfo);
            session.setAttribute("member", response);
            return CommonResponse.success(session.getAttribute("member"));
        } else {
            return CommonResponse.fail(ErrorCode.MEMBER_NOT_FOUND);
        }
    }

    @GetMapping("/info")
    public CommonResponse infoMember(HttpSession session) {
        if (session.getAttribute("member") != null) {
            return CommonResponse.success(session.getAttribute("member"));
        } else {
            return CommonResponse.fail(ErrorCode.MEMBER_NEED_LOGIN);
        }
    }

    @GetMapping("/logout")
    public CommonResponse logoutMember(HttpSession session) {
        if (session.getAttribute("member") != null) {
            session.invalidate();
            return CommonResponse.success(ErrorCode.MEMBER_LOGOUT);
        } else {
            return CommonResponse.fail(ErrorCode.MEMBER_NEED_LOGIN);
        }
    }
}
