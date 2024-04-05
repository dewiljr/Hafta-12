package dev.Patika.Library.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", columnDefinition = "serial")
    private Long id; // book_id

    @Column(name = "book_name", unique = true, length = 100, nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "book_pub_year", unique = true, nullable = false)
    private LocalDate pubYear;


    @Column(name = "book_stock", nullable = false)
    private int stock;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")

    private Author author;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Borrower> borrowerList;

    @ManyToMany(mappedBy = "bookList")
    @JsonIgnore
    List<Category> categoryList;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pubYear=" + pubYear +
                ", stock=" + stock +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
