package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class ContactData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "入力必須です")
	@Size(max = 100, message = "入力は100文字までとしてください")
	private String name;
	@NotBlank(message = "入力必須です")
	@Size(max = 100, message = "入力は100文字までとしてください")
	@Email(message = "メールアドレスの形式にしてください")
	private String email;
	@NotBlank(message = "入力必須です")
	@Size(max = 100, message = "入力は100文字までとしてください")
	private String message;

	public ContactData() {

	}

	public ContactData(String name, String email, String message) {
		this.name = name;
		this.email = email;
		this.message = message;

	}
}
