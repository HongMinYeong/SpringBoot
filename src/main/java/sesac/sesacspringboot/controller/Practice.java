
package sesac.sesacspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class Practice {
    @GetMapping("/practice") //하이라는 경로로 들어오면 실행되는 메서드 정의
    public String getHi(Model model){
//        // Model model: 컨트롤러 클래스의 메소드가 파라미터로 받을 수 있는 객체
//        model.addAttribute("msg","Hi~");


        Age age = new Age(10);
        Age age2 = new Age(20);

        model.addAttribute("Age",age);
        model.addAttribute("Age2",age2);


        return "practice";
    }
    class Age {
        private int age;

        public Age(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }
}
