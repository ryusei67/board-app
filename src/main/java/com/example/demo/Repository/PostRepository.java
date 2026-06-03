package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	//部分一致
	Page<Post> findByTitleContainingOrContentContaining(String titleKeyword, String contentKeyword, Pageable pageable);

	//前方一致
	Page<Post> findByTitleStartingWithOrContentStartingWith(String titleKeyword, String contentKeyword,
			Pageable pageable);

	//後方一致
	Page<Post> findByTitleEndingWithOrContentEndingWith(String titleKeyword, String contentKeyword, Pageable pageable);

}
