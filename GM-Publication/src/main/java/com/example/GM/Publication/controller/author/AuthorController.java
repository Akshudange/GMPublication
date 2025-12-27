package com.example.GM.Publication.controller.author;

import com.example.GM.Publication.entity.Author;
import com.example.GM.Publication.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/profile")
    public Author getMyProfile(Authentication auth) {
        String email = auth.getName(); // logged-in user's email
        return authorRepository.findByEmail(email);
    }
}
