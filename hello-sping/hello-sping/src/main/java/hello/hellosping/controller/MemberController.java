package hello.hellosping.controller;

import hello.hellosping.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired  //생성자에 이게 붙으면? 스프링이 컨테이너에 있는 memberService를 가져다가 연결을 시켜줌
    //Dependency Injection 의존관계를 주입해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
