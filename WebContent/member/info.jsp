<%@page import="com.good.member.MemberBean"%>
<%@page import="com.good.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>  member/info.jsp  </h1>
	<% 
	//로그인 여부 체크 
	String id = (String)session.getAttribute("loginID");
	if(id==null){
		response.sendRedirect("loginForm.jsp");
	}
	%>
	
	<h2> 개인정보 조회 </h2>
	<% 
	//DB에 접근해서 해당유저(로그인한 유저)의 정보만 가져오기
	
	//MemberDAO객체
	MemberDAO dao = new MemberDAO();
	
	//정보조회 메서드 호출
	MemberBean mb = dao.getMember(id);

	%>
	
	<hr> 
	<h4> 아이디 : <%=mb.getId() %></h4>
	<h4> 비밀번호 : <%=mb.getPw() %></h4>
    <h4> 이름 : <%=mb.getName() %></h4>
    <h4> 나이 : <%=mb.getAge() %></h4>
    <h4> 성별 : <%=mb.getGender() %></h4>
    <h4> 이메일 : <%=mb.getEmail() %> </h4>
    <h4> 회원가입일 : <%=mb.getRegdate() %></h4>
    
    <h4><a href="main.jsp">메인페이지로...</a></h4>
    
</body>
</html>