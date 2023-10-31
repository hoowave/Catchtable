package com.catchtable.clone.interfaces.member;

import com.catchtable.clone.application.member.MemberFacade;
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
    public void registerMember(@RequestBody @Valid MemberRegisterDto.RegisterRequest request) {
        var command = request.toCommand();
        var memberInfo = memberFacade.registerMember(command);
        var response = new MemberRegisterDto.RegisterResponse(memberInfo);
        System.out.println("response = " + response);
    }

    @RequestMapping("/login")
    @PostMapping
    public void loginMember(@RequestBody @Valid MemberLoginDto.LoginRequest request, HttpSession session) {
        var command = request.toCommand();
        var memberInfo = memberFacade.loginMember(command);
        if (memberInfo.getId() != -1) {
            var response = new MemberLoginDto.LoginResponse(memberInfo);
            session.setAttribute("member", response);
            System.out.println("로그인성공 = " + response);
        } else {
            //로그인 실패 처리 Exception과 연관이 있을텐데 감이 안옴.. ㅠ
            //throw new AuthenticationException("로그인 실패"); 이게 맞을까요?
            System.out.println("로그인 실패");
        }
    }

    @GetMapping("/info")
    public void infoMember(HttpSession session){
        System.out.println("session.getAttribute(\"member\") = " + session.getAttribute("member"));
    }

    @GetMapping("/logout")
    public void logoutMember(HttpSession session){
        if(session.getAttribute("member") != null){
            session.invalidate();
            System.out.println("로그아웃 성공");
        }else{
            System.out.println("로그아웃 상태");
        }

    }
}
