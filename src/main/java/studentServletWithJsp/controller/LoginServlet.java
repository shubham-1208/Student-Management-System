package studentServletWithJsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentServletWithJsp.dao.StudentDao;
import studentServletWithJsp.dto.Student;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		StudentDao studentDao = new StudentDao();
		List<Student> li = studentDao.getAllStudents();
		String studentPassword = null;
		String studentWhoLoggedIn = null;
		
		boolean value =false;
		for(Student stu: li) {
			if(email.equals(stu.getEmail())) {
				value = true;
				studentPassword = stu.getPassword();
				studentWhoLoggedIn = stu.getName();
				break;
			}
		}
		if(value) {
			if(password.equals(studentPassword)) {
				Cookie cookie = new Cookie("name", studentWhoLoggedIn);
				resp.addCookie(cookie);
				
				List<Student> list = studentDao.getAllStudents();
				req.setAttribute("list", list);;
				RequestDispatcher dispatcher =  req.getRequestDispatcher("display.jsp");
				dispatcher.forward(req, resp);
				
			}else {
				req.setAttribute("message","Sorry Password is not correct");
				RequestDispatcher dispatcher =  req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
		}
		else {
			req.setAttribute("message","Sorry Email is not correct");
			RequestDispatcher dispatcher =  req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}

}
