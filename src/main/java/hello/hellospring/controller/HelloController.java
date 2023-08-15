package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello") //handle GET method path:hello
    public String Hello(Model model){
        model.addAttribute("data","{data from HelloController}");
        return "hello"; // view resolver view name mapping to "templates/"+"hello"+".html"
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name,Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
}
