package sesac.sesacspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class Practice2 {
    @GetMapping("practice2")
    public String getHi(Model model) {
        List<Person> list = new ArrayList<>();
        Person person1 = new Person("kim", 10);
        Person person2 = new Person("lee", 20);
        Person person3 = new Person("hong", 30);
        Person person4 = new Person("park", 40);
        Person person5 = new Person("shin", 50);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);



        model.addAttribute("list", list);

        return "practice2";
    }

    class Person {
        private String name;
        private  int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}