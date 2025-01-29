package home.jarnobookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import home.jarnobookstore.domain.Book;
import home.jarnobookstore.domain.BookRepository;
import home.jarnobookstore.domain.Category;
import home.jarnobookstore.domain.CategoryRepository;

@SpringBootApplication
public class JarnobookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(JarnobookstoreApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(JarnobookstoreApplication.class);

	@Bean
	public CommandLineRunner clr(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			Category category1 = new Category("Sci-fi");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Manga");
			Category category4 = new Category("Literary classic");
			Category category5 = new Category("Nonfiction");

			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);
			categoryRepository.save(category5);

			log.info("fetch all categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}

			bookRepository.save(new Book("good book 1", "Author 1", 2020, "dfvhzdvcjsgf", 50.32, category1));
			bookRepository.save(new Book("good book 2", "Author 2", 1999, "abcdeafttss2", 11.59, category2));
			bookRepository.save(new Book("good book 3", "Author 3", 2000, "123-12312322", 5.99, category1));
			bookRepository.save(new Book("good book 4", "Author 1", 2015, "mdkfdskfsjfd", 10.00, category5));

			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
