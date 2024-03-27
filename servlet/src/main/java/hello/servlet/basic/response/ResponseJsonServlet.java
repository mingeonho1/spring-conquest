package hello.servlet.basic.response;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Content-Type: application/json
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");

		HelloData helloData = new HelloData();
		helloData.setUsername("min");
		helloData.setAge(20);

		String result = objectMapper.writeValueAsString(helloData);
		resp.getWriter().write(result);
	}
}
