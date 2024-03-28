package com.springbootblog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Post is an entity class that represents a post in the blog.
 * It's annotated with @Data, @AllArgsConstructor, and @NoArgsConstructor from Project Lombok to automatically generate getters, setters, constructors, equals, and hashCode methods.
 * It's also annotated with @Entity indicating that it's a JPA entity.
 * The @Table annotation specifies the 'posts' table that this entity maps to and a unique constraint on the 'title' column.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {
	
    /**
     * The unique ID of the post.
     * It's annotated with @Id and @GeneratedValue to indicate that this field is the primary key and its value is auto-generated.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    /**
     * The title of the post.
     * It's annotated with @Column, indicating that this field maps to a column in the database. The 'nullable = false' attribute ensures that the title cannot be null.
     */
	@Column( name = "title", nullable = false)
	private String title;
	
    /**
     * The description of the post.
     * It's annotated with @Column, indicating that this field maps to a column in the database. The 'nullable = false' attribute ensures that the description cannot be null.
     */
	@Column( name = "description", nullable = false)
	private String description;
	
    /**
     * The content of the post.
     * It's annotated with @Column, indicating that this field maps to a column in the database. The 'nullable = false' attribute ensures that the content cannot be null.
     */
	@Column( name = "content", nullable = false)
	private String content;
}
