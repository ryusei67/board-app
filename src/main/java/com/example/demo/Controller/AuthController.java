package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.User;
import com.example.demo.Service.CustomUserService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	private final CustomUserService customUserService;

	public AuthController(CustomUserService customUserService) {
		this.customUserService = customUserService;
	}

	//ログインページ
	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}

	//登録ページ
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "auth/register";
	}

	//登録処理
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {
		customUserService.registerUser(user);
		return "redirect:/auth/login";
	}
}
