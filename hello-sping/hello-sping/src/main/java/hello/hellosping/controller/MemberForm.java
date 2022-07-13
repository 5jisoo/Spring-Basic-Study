package hello.hellosping.controller;

public class MemberForm {
    private String name;
    //createMemberForm.html 에서 입력된 name이 여기 들어옴

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
