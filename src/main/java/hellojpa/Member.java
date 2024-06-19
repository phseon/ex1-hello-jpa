package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name = "MBR")
public class Member {
    
    @Id
    private Long id;
    @Column(name = "USERNAME")
    private String name;
    private String qwer1234;

    //JPA는 기본적으로 리플렉션 등을 쓰기 때문에 객체를 동적으로 생성해야 하므로 기본 생성자 필요
    public Member() {

    }
    
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
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
