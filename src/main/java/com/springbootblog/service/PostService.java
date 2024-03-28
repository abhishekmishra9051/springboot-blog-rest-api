
package com.springbootblog.service;

import java.util.List;
import com.springbootblog.payload.PostDto;

/**
 * PostService is an interface that provides a contract for managing posts in the blog.
 * It defines methods for creating, retrieving, updating, and deleting posts.
 */
public interface PostService {
	
    /**
     * Creates a new post.
     * @param postDto The data transfer object containing the details of the post to be created.
     * @return The created post.
     */
	PostDto createPost(PostDto postDto);
	
    /**
     * Retrieves all posts.
     * @return A list of all posts.
     */
	List<PostDto> getAllPosts();
	
    /**
     * Retrieves a post by its ID.
     * @param id The ID of the post to be retrieved.
     * @return The post with the given ID.
     */
	PostDto getPostById(Long id);
	
    /**
     * Updates a post.
     * @param postDto The data transfer object containing the updated details of the post.
     * @param id The ID of the post to be updated.
     * @return The updated post.
     */
	PostDto updatePost(PostDto postDto, long id);
	
    /**
     * Deletes a post by its ID.
     * @param id The ID of the post to be deleted.
     */
	void deletePostById(long id);
}
