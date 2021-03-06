package com.hamidur.springBootCRUDRESTfulWebservices.services;

import com.hamidur.springBootCRUDRESTfulWebservices.dbModels.Author;
import com.hamidur.springBootCRUDRESTfulWebservices.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService
{
    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthorById(Long authorId)
    {
        Optional<Author> author = authorRepository.findById(authorId);
        return author.isPresent() ? author.get() : null;
    }

    public Author insertAuthor(Author author)
    {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Author author)
    {
        Author newAuthor = authorRepository.findById(author.getAuthorId()).get();

        newAuthor.setAuthorId(author.getAuthorId());
        newAuthor.setFirstName(author.getFirstName());
        newAuthor.setLastName(author.getLastName());

        return authorRepository.save(newAuthor);
    }

    public List<Author> getAuthors()
    {
        return authorRepository.findAll();
    }

    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    public void deleteAuthor(Author author)
    {
        authorRepository.delete(author);
    }
}
