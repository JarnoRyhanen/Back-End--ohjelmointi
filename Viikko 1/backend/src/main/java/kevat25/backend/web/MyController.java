package kevat25.backend.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    @RequestMapping("/main")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("sayHello")
    @ResponseBody
    public String returnGreeting(@RequestParam (name="nimesi") String firstName) {
        return "Hello " + firstName + "!";
    }

    @RequestMapping("/index")
    @ResponseBody
    public String mainPageGreeting() {
        return "This is the main page";
    }

    @RequestMapping("/contact")
    @ResponseBody
    public String contactPageGreeting() {
        return "This is the contact page";
    }

    @RequestMapping("hello")
    @ResponseBody
    public String returnHelloGreeting(@RequestParam (name="location") String location, @RequestParam (name="name") String name) {
        return "Welcome to the " + location + " " + name + "!";
    }

}
