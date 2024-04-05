package dev.Patika.Library.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "serial")
    private int id;
    @Column(name = "category_name", length = 100, nullable = false)
    private String name;
    @Column(name = "category_description", length = 200, nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "book",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<Book> bookList;


}