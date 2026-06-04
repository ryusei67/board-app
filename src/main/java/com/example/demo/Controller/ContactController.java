package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.Entity.ContactData;
import com.example.demo.Service.EmailService;

@Controller
@RequestMapping("/contact")
@SessionAttributes("contactData")
public class ContactController {
	private EmailService emailService;

	public ContactController(EmailService emailService) {
		this.emailService = emailService;
	}

	@GetMapping
	public String contactForm(Model model) {
		if (!model.containsAttribute("contactData")) {
			model.addAttribute("contactData", new ContactData());
		}
		return "contact/form";
	}

	@PostMapping("/confirm")
	public String confirmContact(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("message") String message,
			Model model) {
		model.addAttribute("contactData", new ContactData(name, email, message));
		return "contact/confirm";

	}

	@GetMapping("/complete")
	public String completeForm() {
		return "contact/complete";
	}

	@PostMapping("/submit")
	public String submitContact(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("message") String message,
			Model model) {
		//ユーザに送るメール送信内容
		String userSubject = "問い合わせありがとうございます。";
		String userBody = String.format(
				"\nお問い合わせありがとうございます。\n以下の内容で受け付けました。\n\n[問い合わせ内容]\n名前：%s\n内容：%s",
				name,
				message);
		//運営者に送る送信メール内容
		String adminSubject = "新しい問い合わせが届きました";
		String adminBody = String.format(
				"\n新しい問い合わせが届きました。\n\n[お名前]%s\nメールアドレス：%s\n問い合わせ内容：\n%s",
				name,
				email,
				message);
		//ユーザ宛にメール送信
		emailService.sendUserEmail(email, userSubject, userBody);
		//運営者宛にメール送信
		emailService.sendAdminEmail(adminSubject, adminBody);
		return "redirect:/contact/complete";

	}
}
