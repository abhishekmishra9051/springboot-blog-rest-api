package com.springbootblog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springbootblog.entity.Post;
import com.springbootblog.exception.ResourceNotFoundException;
import com.springbootblog.payload.PostDto;
import com.springbootblog.repository.PostRepository;
import com.springbootblog.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	private PostRepository postRepository;

	/**
     * Constructor for dependency injection.
     *
     * @param postRepository the repository to manage posts.
     */
	
	public PostServiceImpl(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}

	/**
	 * This method is used to create a new post.
	 *
	 * @param postDto Data Transfer Object (DTO) containing the details of the post.
	 * @return PostDto Returns a DTO of the newly created post.
	 */
	@Override
	public PostDto createPost(PostDto postDto) {
	    
	    // Convert DTO to entity
	    // The mapToEntity method is used for this conversion.
	    Post post = mapTOEntity(postDto);
	    
	    // Save the new post entity in the database
	    // The save method of postRepository is used for this operation.
	    Post newPost = postRepository.save(post);
	    
	    // Convert the saved entity back to DTO
	    // The mapToDTO method is used for this conversion.
	    PostDto postResponse = mapToDTO(newPost);
	    
	    // Return the DTO of the new post
	    return postResponse;
	}


	/**
     * Get all posts.
     *
     * @return the list of all posts.
     */
	@Override
	public List<PostDto> getAllPosts() {
		// Fetch all posts from the database
		List<Post> posts = postRepository.findAll();
		// Convert each post entity to DTO and collect as a list
		return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
	}
	
	/**
     * Convert Entity to DTO.
     *
     * @param post the post entity to convert.
     * @return the converted post DTO.
     */
	private PostDto mapToDTO(Post post) {
		PostDto postDto = new PostDto();
		postDto.setId(post.getId());
		postDto.setTitle(post.getTitle());
		postDto.setDescription(post.getDescription());
		postDto.setContent(post.getContent());
		return postDto;
	}

	/**
     * Convert DTO to Entity.
     *
     * @param postDto the post DTO to convert.
     * @return the converted post entity.
     */
	private Post mapTOEntity(PostDto postDto){
		Post post = new Post();
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		return post;
	}
	

	/**
     * Get a specific post by its unique identifier (ID).
     *
     * @param id the ID of the post to retrieve.
     * @return the corresponding PostDto.
     * @throws ResourceNotFoundException if the post with the given ID is not found.
     */
	@Override
	public PostDto getPostById(Long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		return mapToDTO(post);
	}

	/**
     * Update an existing post with the provided ID.
     *
     * @param postDto the updated post details.
     * @param id the ID of the post to update.
     * @return the updated PostDto.
     * @throws ResourceNotFoundException if the post with the given ID is not found.
     */
	@Override
	public PostDto updatePost(PostDto postDto, long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		
		Post updatedPost = postRepository.save(post);
		
		return mapToDTO(updatedPost);
	}

	/**
     * Delete a post by its unique identifier (ID).
     *
     * @param id the ID of the post to delete.
     * @throws ResourceNotFoundException if the post with the given ID is not found.
     */
	@Override
	public void deletePostById(long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		postRepository.delete(post);
	}
	
}
