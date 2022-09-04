package com.good.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test4")
public class TestServlet4 extends HttpServlet{

	// http://localhost:8088/JSP6/test4
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//Phone 객체 생성  
		Phone samsung = new Phone();
		samsung.setModel("지플립4");
		samsung.setColor("pink");
		samsung.setPrice(120);  
		
		//사람 정보 생성 
		Person kim = new Person();
		kim.setName("김학생");
		kim.setAge(20);
		kim.setPhone(samsung); // Phone이라는 하나의 객체라 객체생성 필요 
		
		//사람의 정보를 Beans.jsp  생성해서 정보전달 후 출력, 녹음시작 
		request.setAttribute("kim", kim);
		
		//페이지 이동(forward) 
		RequestDispatcher dis = request.getRequestDispatcher("servlet/Beans.jsp");
		
		dis.forward(request, response);
		
		
		}
		
		
		
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
	

}