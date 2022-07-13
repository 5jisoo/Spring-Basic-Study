package hello.hellosping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // "/"의 의미? 처음 localhost:8080 으로 들어갈때 이게 호출된다는 소리
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
