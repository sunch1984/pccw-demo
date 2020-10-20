package com.example.pccw.controllers;

import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.pccw.Util;
import com.example.pccw.entity.ID;
import com.example.pccw.entity.Login;
import com.example.pccw.entity.Register;
import com.example.pccw.entity.Token;
import com.example.pccw.entity.User;
import com.example.pccw.exception.GlobalException;





@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	
	@PostMapping(produces="application/json")
	public ID register(@RequestBody Register register) {
     
		String id = UUID.randomUUID().toString();
		User user = new User(id,register.getFirst(),register.getLast(),register.getEmail(),register.getPassword());
		Util.register.put(user.getEmail(), user);	
		ID response =  new ID(id);
		return response;
	}

	
	@PostMapping(value = "/login")
	public Token login(@RequestBody Login  login) throws GlobalException {
		String token = "87ff3ecd-b902-46c3-b6e9-46b4e2fa09f8";
		//it is exception example
		if(Util.register.get(login.getEmail())==null) {
		  throw new GlobalException("404","email is wrong");
		}
		Util.logined.put(token, Util.register.get(login.getEmail()));
		return new Token(token);
	}

	@GetMapping
	public User getProfile(@RequestHeader(value="token", defaultValue = "token") String token) {
		User user = Util.logined.get(token);
		return user;
	}

	@PostMapping(value = "/logout")
	public void logout(@RequestBody Token token) {
		Util.logined.remove(token.getToken());
	}

}
