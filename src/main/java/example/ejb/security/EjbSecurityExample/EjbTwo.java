package example.ejb.security.EjbSecurityExample;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.servlet.ServletOutputStream;

@Singleton
public class EjbTwo {

	@Resource
	SessionContext sessionContext;
	
	public void printRole(ServletOutputStream out) throws IllegalStateException, IOException{
		out.println("EjbTwo expected role: VP, isCallerInRole(\"Manager\"): " + sessionContext.isCallerInRole("Manager"));
		out.println("EjbTwo expected role: VP, isCallerInRole(\"VP\"): " + sessionContext.isCallerInRole("VP"));
		out.println("EjbTwo expected role: VP, isCallerInRole(\"Administrator\"): " + sessionContext.isCallerInRole("Administrator"));
	}
}
