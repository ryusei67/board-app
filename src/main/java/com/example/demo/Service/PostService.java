package com.example.demo.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Post;
import com.example.demo.Repository.PostRepository;

@Service
public class PostService {
	public final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public Page<Post> findAll(String sortBy, String orderBy, int page, int size) {
		//sort・orderを使ってソート順を設定
		Sort.Order order;
		if (orderBy.equals("asc")) {
			order = new Sort.Order(Sort.Direction.ASC, sortBy);
		} else {
			order = new Sort.Order(Sort.Direction.DESC, sortBy);
		}
		//Sortオブジェクトの作成
		Sort sort = Sort.by(order);

		//ページ情報作成
		Pageable pageable = PageRequest.of(page, size, sort);
		return postRepository.findAll(pageable);
	}

	public Page<Post> serchPosts(String keyword, String matchType, String sortBy, String orderBy, int page, int size) {
		//sort・orderを使ってソート順を設定
		Sort.Order order;
		if (orderBy.equals("asc")) {
			order = new Sort.Order(Sort.Direction.ASC, sortBy);
		} else {
			order = new Sort.Order(Sort.Direction.DESC, sortBy);
		}
		//Sortオブジェクトの作成
		Sort sort = Sort.by(order);

		//ページ情報作成
		Pageable pageable = PageRequest.of(page, size, sort);
		switch (matchType) {
		//前方一致
		case "startsWith":
			return postRepository.findByTitleStartingWithOrContentStartingWith(keyword, keyword, pageable);
		case "endsWith":
			//後方一致
			return postRepository.findByTitleEndingWithOrContentEndingWith(keyword, keyword, pageable);
		case "contains":
			//部分一致
		default:
			return postRepository.findByTitleContainingOrContentContaining(keyword, keyword, pageable);
		}
	}

	public Post save(Post post) {
		return postRepository.save(post);
	}

	public Optional<Post> findById(Long id) {
		return postRepository.findById(id);
	}

	public void deleteById(Long id) {
		postRepository.deleteById(id);
	}

}
