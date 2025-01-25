package backend.model_view.web;

import org.springframework.web.bind.annotation.RequestMapping;
import backend.model_view.domain.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

    // tehtävä 2
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getStudents(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kate", "Dole"));
        students.add(new Student("Dan", "Brown"));
        students.add(new Student("Mike", "Mars"));
        model.addAttribute("students", students);
        return "studentlist";
    }
}
