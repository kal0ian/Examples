package example.ejb.security.EjbSecurityExample;

import java.io.IOException;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RunAs("Manager")
public class SecurityEjbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private EjbOne ejbOne;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		ServletOutputStream out = response.getOutputStream();
		
		ejbOne.printRole(out);
	
	}

}
