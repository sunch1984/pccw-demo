package com.example.pccw;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.pccw.controllers.HealthCheckController;

@WebMvcTest(HealthCheckController.class)
@AutoConfigureRestDocs
public class HealthCheckControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testRegister() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/heartbeat").accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.jsonPath("$.version").exists())
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andDo(document("heartbeat", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));
	}

}
