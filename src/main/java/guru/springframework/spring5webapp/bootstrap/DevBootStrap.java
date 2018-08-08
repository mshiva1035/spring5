package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Author eric = new Author("Eric", "Evans");
        Publisher publisher = new Publisher("Harper Collins","Jameson Street, SA");
        publisher.setName("Harper Collins");
        Book book1 = new Book("Domain Driven Design","45674" ,publisher);
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);
        authorRepository.save(eric);
        publisherRepository.save(publisher);
        bookRepository.save(book1);

        Author rod = new Author("Rod","Johnson");
        Publisher publisher2 = new Publisher("Pearson", "Pepe John Road, CA");
        Book noEJB = new Book("J2EE Development without EJB","459898",publisher2);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(publisher2);
        bookRepository.save(noEJB);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
