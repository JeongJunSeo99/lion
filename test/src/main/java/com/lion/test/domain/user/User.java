package com.lion.test.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity // DB에 저장 할 객체
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    //protected User(){} // JPA를 사용하기 위해서는 생성자를 꼭 만들어 줘야 함 -> 위에 NoArgs... 어노테이션으로 대체

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increament
    private Long id = null;

    @Column(nullable = false, length = 20) //nullable은 not null
    private String name;
    private Integer age; //null 안나오게 하려고 int 대신 integer 씀

    public User(String name, Integer age){
        this.name =name;
        this.age = age;
    }
}
