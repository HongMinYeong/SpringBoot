package sesac.sesacspringboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter //어노테이션으로 겟,셋함수 만들기 가능 해당 위에다가
@Setter
public class UserDTO {
    private String name;

    private String age;


//    public String getName() {
//        return name;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
}
