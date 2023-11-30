package studentServletWithJsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentServletWithJsp.dao.StudentDao;
import studentServletWithJsp.dto.Student;
@WebServlet("/edit")
public class EditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		String course = req.getParameter("course");
		
		double dfees=Double.parseDouble(getServletContext().getInitParameter("developmentfees")); 
		double tfees=Double.parseDouble(getServletContext().getInitParameter("testingfees")); 
		
		Student student = new Student();
		student.setAddress(address);
		student.setName(name);
		student.setId(id);
		student.setCourse(course);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(phone);
		student.setFees(course.equals("development") ? dfees : tfees);
		
		StudentDao studentDao = new StudentDao();
		studentDao.updateStudent(student);
		
		Cookie[] cookies = req.getCookies();
		String nameWhoChangedTheDetails = null;
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals("name")) {
				nameWhoChangedTheDetails = cookie.getValue();
			}
		}
		req.setAttribute("name", nameWhoChangedTheDetails);
		
		req.setAttribute("list", studentDao.getAllStudents());
		RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
	}
}
