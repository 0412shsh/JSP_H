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
	
	<%!static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	static final String DBID = "root";
	static final String DBPW = "1234";%>
	
	
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
	// 1. 드라이버 로드
	Class.forName(DRIVER);
	System.out.println(" 드라이버 로드 성공! ");
	
	// 2. 디비 연결
	Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
	System.out.println(" 디비연결 성공 ");
	
	// 3. SQL & pstmt
	String sql = "select pw from cool_member where id=?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	// ??? 
	pstmt.setString(1, mb.getId()); //MemberBean 안에 들어 있음 
	
	//4. SQL 실행
	ResultSet rs = pstmt.executeQuery();
	
	
	//5. 데이터 처리
	if(rs.next()){
		//아이디 있음, 회원
		if(mb.getPw().equals(rs.getString("pw"))){
			//아이디 있음, 비밀번호 일치 => 로그인 성공
					
			//로그인정보(ID) 저장, 공유
			//session 영역에 저장, 공유
			session.setAttribute("loginID", mb.getId());
			//session.setAttribute("loginResult", "OK");
			response.sendRedirect("main.jsp");
		} else {
			// 아이디 있음, 비밀번호 다름, 비밀번호 오류
			//alert('비밀번호 오류');
			%>
			<script type="text/javascript">
			alert('아이디 혹은 비밀번호가 잘못되었습니다.');
			history.back();
			</script>
			<%
		}
		
		
	} else {
		//아이디 없음, 비회원
		%>
		<script type="text/javscript">
		//alert('회원정보가 없습니다.');
		alert('아이디 혹은 비밀번호가 잘못되었습니다.);
		history.back();
		</script>
		<%
	}
	
	
	
	%>
	
</body>
</html>