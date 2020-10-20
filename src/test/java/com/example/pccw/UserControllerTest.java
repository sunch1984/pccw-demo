package com.example.pccw;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.example.pccw.controllers.UserController;
import com.example.pccw.entity.Login;
import com.example.pccw.entity.Register;
import com.example.pccw.entity.Token;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

@WebMvcTest(UserController.class)
@AutoConfigureRestDocs
public class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testRegister() throws Exception {

		Register register = new Register("firstName4", "lastName4", "email4@mail.com", "password");
		mockMvc.perform(MockMvcRequestBuilders.post("/user").content(asJsonString(register))
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andDo(document("user-register", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));
	}

	@Test
	public void login() throws Exception {

		Login login = new Login("email4@mail.com", "password");
		mockMvc.perform(MockMvcRequestBuilders.post("/user/login").content(asJsonString(login))
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(MockMvcResultMatchers.jsonPath("$.token").exists())
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andDo(document("user-login", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));

	}

	@Test
	public void getProfile() throws Exception {
    
		String token = "87ff3ecd-b902-46c3-b6e9-46b4e2fa09f8";
		mockMvc.perform(MockMvcRequestBuilders.get("/user").header("token", token).characterEncoding("utf-8")
				.accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.email").exists())
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andDo(document("getProfile-by-Token",
						preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));

	}

	@Test
	public void logout() throws Exception {

		Token token = new Token("87ff3ecd-b902-46c3-b6e9-46b4e2fa09f8");
		mockMvc.perform(MockMvcRequestBuilders.post("/user/logout").content(asJsonString(token)).contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andDo(document("user-logout", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			System.out.print("eee");
			throw new RuntimeException(e);
		}
	}

}