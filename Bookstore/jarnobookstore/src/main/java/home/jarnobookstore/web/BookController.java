package home.jarnobookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import home.jarnobookstore.domain.Book;
import home.jarnobookstore.domain.BookRepository;
import home.jarnobookstore.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    
    @Autowired 
    private CategoryRepository categoryRepository;

    public BookController(BookRepository repository) {
        this.bookRepository = repository;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String requestMethodName(@RequestParam String param) {
        return "index";
    }

    // tehtävä 2
    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    // tehtävä 3
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNewBook(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id")Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:../booklist";
    }

    //tehtävä 4
    @RequestMapping(value= "/edit/{id}", method=RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", bookRepository.findById(bookId));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }
}
