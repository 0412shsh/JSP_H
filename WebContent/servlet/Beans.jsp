<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <h1>Beans.jsp</h1>
      
      <h2> 전달된 사람의 정보 출력하기 </h2>
      
      <%-- request.setAttribute("kim", kim); --%>
      
      ${requestScope.kim }   -> test4실행시 패키지 명과 정보가 나옴 
      <br>
      이름 : ${requestScope.kim.name }<br>
      나이 : ${kim.age }<br>
      휴대폰 : ${kim.phone }<br>
      <hr>
      모델명 :${kim.phone.model }<br>
      색상 : ${kim.phone.color }<br>
      가격 : ${requestScope.kim.phone.price }<br>
      
      <hr>
      JSTL 사용하여 객체정보 저장 -> 변수 변경<br>
      <c:set var="p" value="${kim.phone }"/>
      ${p.model }<br>
      

</body>
</html>