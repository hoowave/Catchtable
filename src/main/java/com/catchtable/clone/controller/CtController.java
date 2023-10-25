package com.catchtable.clone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/ct")
// ct 디렉터리 접근
public class CtController {
    // 비즈니스 로직에 맞게 구현할 것 - 최대한 클라이언트측 요청, 응답만 여기서 처리해보자

    @GetMapping("/login")
    public String login() {
        return "/ct/login";
    }

    @GetMapping("/join")
    public String join() {
        return "/ct/join";
    }

    @GetMapping("/loginPhone")
    public String loginPhone() {
        return "/ct/loginPhone";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
