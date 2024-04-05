package dev.Patika.Library.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book_borrowing")
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "borrower_name", nullable = false)
    private String name;

    @Column(name = "borrow_date", nullable = false)
    private LocalDate borrow_date;

    @Column(name = "return_date", nullable = false)
    private LocalDate return_date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "borrowed_book_id", referencedColumnName = "book_id")
    private Book book;


    @Override
    public String toString() {
        return "BookBorrowing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borrow_date=" + borrow_date +
                ", return_date=" + return_date +
                '}';
    }
}