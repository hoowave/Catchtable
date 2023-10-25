package com.catchtable.clone.api;

import com.catchtable.clone.service.CtService;
import com.catchtable.clone.userdto.JoinDTO;
import com.catchtable.clone.vo.UserVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/ct")
public class CtApi {

    // ajax를 통해 닉네임 중복 검사 및 회원가입 로그인 처리 등을 담당

    private CtService ctService;

    public CtApi(CtService ctService) {
        this.ctService = ctService;
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDTO joinDTO) {
        // 정규화 시킨 두 테이블 데이터를 JoinDTO 객체로 받아옴
        if (!ctService.join(joinDTO)) {
            return new ResponseEntity<>("유효하지 않은 값입니다.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("회원가입 성공", HttpStatus.OK);
    }

    @PostMapping("/nicknamechk")
    public ResponseEntity<String> nicknameCheck(@RequestBody JoinDTO joinDTO) {
        if (!ctService.nicknameCheck(joinDTO)) {
            return new ResponseEntity<>("false", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("true", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody JoinDTO joinDTO, HttpSession session, Model model) {
        UserVO userVO = ctService.login(joinDTO);
        if (userVO == null) {
            return new ResponseEntity<>("아이디 또는 비밀번호를 확인해주세요.", HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("userVO", userVO);
        return new ResponseEntity<>(userVO.getName() + "님 안녕하세요.", HttpStatus.OK);
    }

}
