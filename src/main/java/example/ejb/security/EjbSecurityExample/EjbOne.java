package example.ejb.security.EjbSecurityExample;

import java.io.IOException;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.servlet.ServletOutputStream;

@Singleton
@RunAs("VP")
public class EjbOne {

	@EJB
	EjbTwo ejbTwo;

	@Resource
	SessionContext sessionContext;
	
	public void printRole(ServletOutputStream out) throws IllegalStateException, IOException{
		out.println("EjbOne (Before EjbTwo) expected role: Manager, isCallerInRole(\"Manager\"): " + sessionContext.isCallerInRole("Manager"));
		out.println("EjbOne (Before EjbTwo) expected role: Manager, isCallerInRole(\"VP\"): " + sessionContext.isCallerInRole("VP"));
		out.println("EjbOne (Before EjbTwo) expected role: Manager,) isCallerInRole(\"Administrator\"): " + sessionContext.isCallerInRole("Administrator"));
		ejbTwo.printRole(out);
		out.println("EjbOne (After EjbTwo) expected role: Manager, isCallerInRole(\"Manager\"): " + sessionContext.isCallerInRole("Manager"));
		out.println("EjbOne (After EjbTwo) expected role: Manager, isCallerInRole(\"VP\"): " + sessionContext.isCallerInRole("VP"));
		out.println("EjbOne (After EjbTwo) expected role: Manager, isCallerInRole(\"Administrator\"): " + sessionContext.isCallerInRole("Administrator"));
	}

}
