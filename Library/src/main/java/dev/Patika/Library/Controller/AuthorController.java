package dev.Patika.Library.Controller;

import dev.Patika.Library.Repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/")
public class AuthorController {

    private AuthorRepository authorRepository;



    @GetMapping("/")
    public String author() {
        return "Yazar";
    }
}
