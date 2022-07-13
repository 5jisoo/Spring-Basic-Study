package hello.hellosping.controller;

import hello.hellosping.domain.Member;
import hello.hellosping.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired  //생성자에 이게 붙으면? 스프링이 컨테이너에 있는 memberService를 가져다가 연결을 시켜줌
    //Dependency Injection 의존관계를 주입해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return("members/createMemberForm");
    }

    @PostMapping("/members/new")
    public String create (MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        //System.out.println("member = " + member.getName());

        memberService.join(member);
        return "redirect:/"; //회원 가입이 끝나면 홈 화면으로 되돌아가게 함
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
