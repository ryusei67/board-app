package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostForm {
	@NotBlank(message = "入力は必須です")
	@Size(max = 100, message = "入力は100文字までとしてくてください")
	private String title;
	@NotBlank(message = "入力は必須です")
	@Size(max = 100, message = "入力は100文字までとしてくてください")
	private String content;
}
