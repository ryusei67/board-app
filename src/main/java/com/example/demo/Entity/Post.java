package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Entity
@Data
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String content;
	private LocalDateTime createAt = LocalDateTime.now();
	private LocalDateTime updateAt = LocalDateTime.now();

	@PrePersist
	public void onCreate() {
		createAt = LocalDateTime.now();
	}

	@PreUpdate
	public void onupdate() {
		updateAt = LocalDateTime.now();
	}
}
