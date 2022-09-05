<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> insertForm.jsp </h1>
	
	<h2> 회원가입 페이지 </h2>
	
<!-- 	아이디, 비밀번호, 나이, 성별, 이메일, 회원가입일 -->

<fieldset>
<form action="insertPro.jsp" method="post">
아이디 : <input type="text" name="id"><br> 
비밀번호 : <input type="password" name="pw"><br> 
나이 : <input type="text" name="age"><br> 
성별 : <input type="radio" name="gender" value="여">여 
	   <input type="radio" name="gender" value="남">남<br> 
이메일 : <input type="text" name="email"><br>

<!-- DB컬럼명과 피라미터의 이름은 동일하게 -> 구현하기 쉬움, 자동 동기화 가능 -->
<hr> 
<input type="submit" value="회원가입">
</form>


</fieldset>
	
	
</body>
</html>