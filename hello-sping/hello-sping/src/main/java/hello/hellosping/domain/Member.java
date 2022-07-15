package hello.hellosping.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity     // jpa가 관리하는 entity 임을 명시
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    // pk(primary key): id, DB에서 id값을 알아서 자동생성 해주고 있기 때문에 - identity
    private Long id; //데이터 구분을 위한 시스템이 지정하는 아이디

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
