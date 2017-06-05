package com.test.example.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.json.*;

@WebServlet("/example")
public class App extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonObject person = Json.createObjectBuilder()
				.add("name", "Stephan")
				.add("age", 40)
				.add("hungry", JsonValue.FALSE)
				.build();
		boolean value = person.getBoolean("name");
		resp.getWriter().print("The boolean value of \"name\" is: " + value);
	}
}
