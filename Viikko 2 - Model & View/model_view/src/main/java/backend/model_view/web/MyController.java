package backend.model_view.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyController {

    @RequestMapping("/form")
    public String home(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "form";
    }

    //tehtävä 1
    @RequestMapping(value="/hello_thymeleaf", method = RequestMethod.GET)
    public String returnHelloGreeting(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "age") String age,
            Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "hello_thymeleaf";
    }
}
