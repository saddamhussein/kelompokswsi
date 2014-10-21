package id.co.skyforce.basicjsf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name = req.getParameter("name");
		name = "nama: "+name;
		String age = req.getParameter("age");
		age = "usia: "+age;
		req.setAttribute("name", name);
		req.setAttribute("age", age);
		
		req.getRequestDispatcher("output.jsp").forward(req, resp);
//		resp.getWriter().println("<html>");
//		resp.getWriter().println("<body>");
//		resp.getWriter().println("Hello "+name+" "+age+". this is my first selvet");
//		resp.getWriter().println("</body>");
//		resp.getWriter().println("</html>");

	}

}
