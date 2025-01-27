package home.jarnobookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import home.jarnobookstore.domain.Book;
import home.jarnobookstore.domain.BookRepository;

@SpringBootApplication
public class JarnobookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(JarnobookstoreApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(JarnobookstoreApplication.class);

	@Bean
	public CommandLineRunner clr(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("good book 1", "Author 1", 2020, "dfvhzdvcjsgf", 50.32));
			repository.save(new Book("good book 2", "Author 2", 1999, "abcdeafttss2", 11.59));
			repository.save(new Book("good book 3", "Author 3", 2000, "123-12312322", 5.99));
			repository.save(new Book("good book 4", "Author 1", 2015, "mdkfdskfsjfd", 10.00));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
