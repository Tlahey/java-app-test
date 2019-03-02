package com.java.test.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.java.test.app.models.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		this.mockMvc.perform(
			get("/user/?firstName=Antoine&lastName=Vendeville")
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().json("{\"firstName\":\"Antoine\",\"lastName\":\"Vendeville\",\"id\":1}"));
	}

	@Test
	public void testUser() throws Exception {

		final String firstName = "Vendeville";
		final String lastName = "Antoine";
		final Long id = 2L;

		User user = new User(id, firstName, lastName);

		Assert.assertEquals(
			"Id is not equal to " + id, 
			id, user.getId());

		Assert.assertEquals(
			"FirstName must be " + firstName, 
			firstName, user.getFirstName());

		Assert.assertEquals(
			"LastName must be " + lastName, 
			lastName, user.getLastName());			
	}
}
