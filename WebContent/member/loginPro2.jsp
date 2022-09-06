<%@page import="com.good.member.MemberDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> member/loginPro.jsp </h1>
	
	<% 
	//한글처리
	request.setCharacterEncoding("UTF-8");
	//전달된 정보 저장(id,pw)
// 	String id = request.getParameter("id");
// 	String pw = request.getParameter("pw");
	
	%>
	
	<jsp:useBean id="mb" class="com.good.member.MemberBean"/>
	<jsp:setProperty property="*" name="mb"/>
	
	<%
	System.out.println(mb);
	
	// 로그인 체크하는 로직
	//MemberDAO 객체
	MemberDAO dao = new MemberDAO();
	
	// 로그인 체크 기능 - loginMember() 
	int result = dao.loginMember(mb);
	
	if(result == 0){
		//비밀번호 오류
		%>
		<script type="text/javascript">
		alert('비밀번호 오류');
		history.back();
		</script>
		<%
	}else if(result == -1){	
		//아이디 없음, 비회원
		%>		
		<script type="text/javascript">
		alert('아이디 없음!');
		history.back();
		</script>
		<%
	}else {
		//result == 1
		//로그인 성공
		session.setAttribute("loginID", mb.getId());
		//response.sendRedirect("main.jsp");
		%>
		<script type="text/javascript">
		alert("로그인 성공!");
		location.href='main.jsp';
		</script>
		
		<%		
	}
	
	
	%>
	
</body>
</html>