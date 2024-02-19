package com.mahmoudi.library;

import com.mahmoudi.library.entity.Book;
import com.mahmoudi.library.repository.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner run (BookRepo bookRepo){
		return args -> {
			bookRepo.save(new Book(null, "MOjo Jojo" , "11566664545","15/06/1995" ));
			bookRepo.save(new Book(null, "MOjo koko" , "1mljkllkgght445","15/06/1995" ));
			bookRepo.save(new Book(null, "MOjo lolo" , "jkjjjkhk54cw4","15/06/1995" ));
			bookRepo.save(new Book(null, "MOjo dodo" , "115fdgsfdg445","15/06/1995" ));
			bookRepo.save(new Book(null, "MOjo hoho" , "115sdgvx445","15/06/1995" ));
			bookRepo.save(new Book(null, "MOjo fofo" , "115fggbvn5","15/06/1995" ));
			bookRepo.save(new Book(null, "MOjo bobo" , "115retry45","15/06/1995" ));


		};
	}

}
