package com.example.demo.Service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class CustomUserService implements UserDetailsService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public CustomUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//ユーザー情報を取得してUserDetailsの型に変換
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				new ArrayList());

	}

	public void registerUser(User user) {
		//PWのハッシュ化
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		//ユーザー情報をデータベースに保存
		userRepository.save(user);
	}

}
