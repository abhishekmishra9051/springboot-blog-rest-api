package com.springbootblog.payload;

import lombok.Data;

/**
 * PostDto is a data transfer object for Post.
 * It is a plain old java object (POJO) used to encapsulate the data of a Post.
 */
@Data
public class PostDto {
    /**
     * Unique identifier for the Post.
     */
    private long id;

    /**
     * Title of the Post.
     */
    private String title;

    /**
     * Brief description about the Post.
     */
    private String description;

    /**
     * Content of the Post.
     */
    private String content;
}