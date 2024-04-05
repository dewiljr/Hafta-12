package dev.Patika.Library.Repository;

import dev.Patika.Library.Entities.Author;
import dev.Patika.Library.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    Optional<Book> findByNameAndAuthor(String name, Author author);


}
