package com.springbootblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springbootblog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    // This interface extends JpaRepository, which provides CRUD operations for the 'Post' entity.
    // You don't need to write any implementation for these methods; Spring Data JPA handles it.

    // Additional custom methods specific to your application can be defined here.
    // For example:
    // List<Post> findByAuthor(String author);
    // Post findByTitle(String title);
}
