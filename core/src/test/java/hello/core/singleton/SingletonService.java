package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 내부의 private으로 만듦.
    // static 으로 만들었기 때문에? **딱 하나만 존재하게 됨** >> 이건 자바 기본의 static 영역에 대해 공부하면 이해 가능..!

    // 이렇게 하면 JVM. 자바가 딱 뜰 때 바로 instance에 자기 자신의 객체를 만들어서 참조로 넣어놓음.
    // 자기 자신의 객체 인스턴스를 하나 생성해서 instance 안에 들어가 있는 것!

    // 1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance(){
        return instance;
    }

    // 3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다!!
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
