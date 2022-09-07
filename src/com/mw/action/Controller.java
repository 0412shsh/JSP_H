package com.mw.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Action;

public class Controller extends HttpServlet {

	
	//http://localhost:8088/MoviesWill/test.bo
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			System.out.println("GET,POST방식 모두 호출  - doProcess()");

			System.out.println("\n 1. 가상주소 계산 -시작 ");
//1. 가상주소 계산 -----------------------------------------------
			String requestURI = request.getRequestURI();
			System.out.println("C : requestURI : "+requestURI); //URI확인 
			
			String ctxPath = request.getContextPath(); //프로젝트(컨텍스트)경로를 가져온다 
			System.out.println("C : ctxPath : " + ctxPath); //포로젝트이름 확인

			String command = requestURI.substring(ctxPath.length()); //프로젝트의 길이만큼 잘라서 가져오겠다
			System.out.println("C : command :" +command); //제일 끝 주소만 가져옴 
			        
			//C 의 의미 Contoller에서 가져오는 정보이다.
			
			//1. 가상주소 계산 -----------------------------------------------
			System.out.println("\n 1. 가상주소 계산 - 끝 ");
			
			
			
			
			System.out.println("\n  2. 가상주소 매핑 - 시작");
			// 2. 가상주소 매핑------------------------------------------------
			Action action = null;
			ActionForward  forward = null;
			
			if(command.equals("/insert.bo")){
				//회원가입 페이지 보여주기 (DB정보 필요없음) 
				System.out.println("C : /intert.bo 호출");
				System.out.println("C : /DB정보가 필요 없음 - view페이지로 이동호출");
				
				forward = new ActionForward();
				forward.setPath("./sign/insertForm.jsp");
				forward.setRedirect(false);
			}
			
			
			
			
			
			
			
	} //get,post 방식 함께 호출하기 
	////////////////////////////////////doProcess/////////////////////////////////////

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			System.out.println("GET방식 호출 - doGet()");
			doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			System.out.println("POST방식 호출 - doPost()");
			doProcess(request, response);
	} 

}