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
	<h1> member/iupdateForm.jsp </h1>
	
	<h2> 회원정보 수정 페이지 </h2>
	<%
	//로그인 체크 
	String id = (String)session.getAttribute("loginID");
	if(id == null){
		response.sendRedirect("loginForm.jsp");
	}
	
	//기존의 회원정보 화면 출력
	//MemberDAO 객체 생성 --> 메서드 사용할 수 있게 호출
	MemberDAO dao = new MemberDAO();
	
	//회원정보 조회 메서드 --> session에서 가져온 id를 getmember에 넣어 select한 값을 mb에 넣는다. 
	MemberBean mb = dao.getMember(id);
	
	//성별의 정보가 없을때, 기본값으로 설정
	if(mb.getGender() == null) {
		mb.setGender("남");
	}
	
	%>	  
	  
	  <fieldset>
     <form action="insertPro3.jsp" method="post">
        아이디 : <input type="text" name="id"> <br>
        비밀번호 : <input type="password" name="pw"> <br>
        이름 : <input type="text" name="name"> <br>
        나이 : <input type="text" name="age"> <br>
        성별 : <input type="radio" name="gender" value="남">남 
        	   <input type="radio" name="gender" value="여">여 
        <br>
        이메일 : <input type="text" name="email"> <br>
        
        <hr>
        <input type="submit" value="회원가입하기">     
     </form>  
  </fieldset>
	
	
</body>
</html>