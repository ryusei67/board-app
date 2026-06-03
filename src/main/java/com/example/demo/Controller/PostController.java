package com.example.demo.Controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Post;
import com.example.demo.Service.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {
	public final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	//一覧表示
	@GetMapping()
	public String home(
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "matchType", required = false, defaultValue = "contains") String matchType,
			@RequestParam(value = "sortBy", required = false, defaultValue = "createAt") String sortBy,
			@RequestParam(value = "orderBy", required = false, defaultValue = "asc") String orderBy,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			Model model) {
		//サイズを固定(例：1０件ずつ表示)
		int size = 1;
		//検索フォームの入力値
		Page<Post> posts;
		if (keyword != null && !keyword.isEmpty() && matchType != null && !matchType.isEmpty()) {
			posts = postService.serchPosts(keyword, matchType, sortBy, orderBy, page, size);
		} else {
			posts = postService.findAll(sortBy, orderBy, page, size);
		}
		model.addAttribute("posts", posts);
		return "posts/list";
	}

	//新規登録
	@GetMapping("/create")
	public String create(Post post) {
		return "posts/create";
	}

	@PostMapping("/save")
	public String save(Model model, Post post) {
		Post posts = postService.save(post);
		model.addAttribute("posts", posts);
		return "redirect:/posts";
	}

	//詳細情報
	@GetMapping("/{id}")
	public String detail(@PathVariable Long id, Model model) {
		Post post = postService.findById(id).orElseThrow();
		model.addAttribute("post", post);
		return "posts/detail";
	}

	//編集情報
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Post post = postService.findById(id).orElseThrow();
		model.addAttribute("post", post);
		return "posts/edit";
	}

	@PostMapping("/{id}")
	public String update(@PathVariable Long id, @ModelAttribute Post post) {
		Post update = postService.findById(id).orElseThrow();
		update.setTitle(post.getTitle());
		update.setContent(post.getContent());
		postService.save(update);
		return "redirect:/posts";
	}

	//削除情報
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		postService.deleteById(id);
		return "redirect:/posts";
	}

}
