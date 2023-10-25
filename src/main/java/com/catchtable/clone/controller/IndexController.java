package com.catchtable.clone.controller;

import com.catchtable.clone.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    //최상위 디렉터리 접근
    @GetMapping("/")
    public String index(HttpSession session, Model model){
        // index 접근 시, session에 저장된 회원 객체를 얻음
        // Guest 회원 처리 따로 해줄 것
        UserVO userVO = (UserVO) session.getAttribute("userVO");
        model.addAttribute("userSession", userVO);
        return "index";
    }
}
