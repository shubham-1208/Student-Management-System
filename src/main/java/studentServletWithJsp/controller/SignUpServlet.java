package studentServletWithJsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentServletWithJsp.dao.StudentDao;
import studentServletWithJsp.dto.Student;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		student.setCourse(course);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(phone);
		student.setFees(course.equals("development") ? dfees : tfees);
		
		
		StudentDao studentDao = new StudentDao();
		List<Student> li = studentDao.getAllStudents();
		boolean value = true;
		for(Student stu: li) {
			if(email.equals(stu.getEmail())) {
				value = false;
				break;
			}
		}
		if(value) {
			studentDao.saveStudent(student);
			req.setAttribute("message","SignUp successful please login");
			RequestDispatcher dispatcher =  req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}else {
			req.setAttribute("message","Sorry Email already exist please give a different Email");
			RequestDispatcher dispatcher =  req.getRequestDispatcher("signup.jsp");
			dispatcher.include(req, resp);
		}
	}
}
