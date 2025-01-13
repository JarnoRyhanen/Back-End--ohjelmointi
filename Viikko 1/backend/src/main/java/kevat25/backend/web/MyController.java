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
    public String returnGreeting(@RequestParam (name="") String firstName) {
        return "Hello " + firstName + "!";
    }
}
