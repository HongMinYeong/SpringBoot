package sesac.sesacspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller //처음에 컨트롤러 어노테이션
//@RestController : Controller 면서 모든 메소드가 @ResponseBody를 갖도록 하는 친구
public class MainController {
    @GetMapping("/api") //api라는 메소드 만듬
    public String getApi(){return "request";}

    //1) get : ?key=value
    // 검색/ 해시태그
    // /get/response1?name=abc
    @GetMapping("/get/response1")
//    public String getResponse(@RequestParam(value="name") String name, Model model){
        public String getResponse(@RequestParam(value="name") String name,
                                    @RequestParam(value="age",required = false) String age,
                                                            Model model){
        //@Requestparam : 요청의 파라미터를 매개변수로 받을 때 적는 어노테이션
        // value = ? 뒤에 넘어온 key
        // required 값을 설정할 수 있다. = true/false -> 기본값은 true
        // required가 true 로 되어있으면 ?뒤에 해당되는 key가 없을 경우 메소드를 찾지 못한다.
        model.addAttribute("name",name);
//        model.addAttribute("age",age);
        return "response"; //해당 html 파일로 전달
    }
    // /get/response2?
    @GetMapping("/get/response2")
    public String getResponse2(@RequestParam(value="name",required = false) String name,
                              Model model){ //required = false는 쿼리값이 없어도 된다.
        model.addAttribute("name",name);
        return "response";
    }
    // /get/response3/이름/나이
    // uri에 변수가 들어올 때 그 값을 가져오는 방법
    @GetMapping("/get/response3/{name}/{age}")
    public String getResponse3(@PathVariable(value="name") String n, //다른 변수명 이용할때 표현법
                               @PathVariable String age, //동일하게 쓸거라면 value값 설정 안해줘도됨
                               Model model){
        model.addAttribute("name",n);
        model.addAttribute("age",age);
        return "response";
    }

    @GetMapping({"/get/response4/{name}","/get/response4/{name}/{age}"})
    public String getResponse4(@PathVariable String name,
                               @PathVariable(required = false) String age,
                               Model model){
        // @PathVariable 에 required 설정이 가능하나, 기본값은 true
        // @PathVariable에 required를 설정할 때는 GetMapping에 url도 같이 설정해줘야 한다.
        // required 값이 false인 친구는 뒤로 가야한다.
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "response";
    }

    @GetMapping("/introduce/{name}")
    public String introduce(@PathVariable String name,
                               Model model){
        model.addAttribute("name",name);
        return "response";
    }
    @GetMapping("/introduce2")
    public String getResponse2(@RequestParam(value="name") String name,
                               @RequestParam(value="age") int age,
                               Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "response";
    }


    ////////////////////////////////////////////////////////////////////////////////
    // post 로 값을 전달할 때 그 값을 controller에서 받는 방법은 @RequestParam
    @PostMapping("/post/response1")
    public String postResponse1(@RequestParam(value="name") String name, Model model){
        model.addAttribute("name",name);
        return "response";
    }

    @PostMapping("/post/response2")
    public String postResponse2(@RequestParam(value="name",required = false) String name, Model model){
        model.addAttribute("name",name);
        return "response";
    }

    @PostMapping("/post/response3")
    @ResponseBody // res.send
    // return 하는 문자열의 template 파일을 불러오는 게 아니라
    // return 하는 문자열 그대로 값을 전달하는 것
    public String postResponse3(@RequestParam(value="name",required = false) String name, Model model){
        model.addAttribute("name",name);
        return "response" + name;
    }

    @PostMapping("/post/practice")
    @ResponseBody
    public String postResponse3(@RequestParam(value="username",required = false) String username,
                                @RequestParam(value="gender",required = false) String gender,
                                @RequestParam(value="birthYear",required = false) Integer birthYear,
                                @RequestParam(value="birthMonth",required = false) Integer birthMonth,
                                @RequestParam(value="birthDay",required = false) Integer birthDay,
                                @RequestParam(value="hobby",required = false) String hobby,
                                Model model){

        model.addAttribute("username",username);
        model.addAttribute("gender",gender);
        model.addAttribute("birthYear",birthYear);
        model.addAttribute("birthMonth",birthMonth);
        model.addAttribute("birthDay",birthDay);
        model.addAttribute("hobby",hobby);
        return "이름 : " + username  + "성별 : " + gender  + "생년월일 : " + birthYear + "-" + birthMonth + "-" +
                birthDay  + "관심사 : " + hobby;
    }


}
