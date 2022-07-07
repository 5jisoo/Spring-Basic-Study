package hello.hellosping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /*웹 어플리케이션에서 /hello라고 들어오면 아래 메소드를 호출해줌.*/
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name, Model model){
        /*RequestParam? 이번에는 직접 사용자로부터 입력을 받음*/
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    /* http(통신프로토콜)에서 Body부분에 return된 'hello " + name을 직접 넣어주겠다는 뜻 */
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 디폴트: Json 방식으로 return
    }
    static class Hello{
        private String name;
        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

    }

}
