package home.jarnobookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import home.jarnobookstore.domain.Book;
import home.jarnobookstore.domain.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    public BookController(BookRepository repository){
        this.bookRepository = repository;
    }

    
    @RequestMapping(value= "/index", method=RequestMethod.GET)
    public String requestMethodName(@RequestParam String param) {
        return "index";
    }
    

    //tehtävä 2
    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }
}
