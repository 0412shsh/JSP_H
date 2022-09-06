package com.good.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
//MemberDAO (Data Transfer Object) 정보전송객체 member정보 (DB-테이블) 
//DAO 정보처리객체
//DB에 관한 모든 정보를 처리하는 객체, db연결해야할때 마다 사용해야함 
	
	//공통으로 사용되는 객체 선언 
	Connection con = null; //디비연결정보를 저장, 처리
	PreparedStatement pstmt = null; //SQL 쿼리 실행, 처리
	ResultSet rs = null; //select 구문 결과 저장
	String sql =""; //sql 쿼리 저장
	
	//디비 연결메서드
	private Connection getCon() throws Exception{
		//디비 연결 정보
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		String DBID = "root";
		String DBPW = "1234";
		
		// 1. 드라이버 로드
		Class.forName("DRIVER");
		System.out.println("드라이버 로드 성공");
		
		// 2. 디비 연결
		con = DriverManager.getConnection(DBURL, DBID, DBPW);
		System.out.print("디비 연결 성공");
		System.out.print("con : "+con);
		
		return con;
	}
	
	// 디비 자원해제 
	public void closeDB(){
		
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	//회원가입 - insertMember(MB) 
	public void insertMember(MemberBean mb){
		
		try {
			/*//1. 드라이버 로드
			Class.forName("DRIVER");
			System.out.println("드라이버 로드 성공");
			//2. 디비 연결
			con = DriverManager.getConnection(DBURL, DBID, DBPW);
			System.out.println(" 디비연결 성공 ");
			System.out.println(" con : " + con)*/
			
			//1.2. 디비연결
			con = getCon();
			
			//3. sql 작성 & pstmt 객체 생성 
			String sql ="insert into cool_member(id,pw,name,age,gender,email,regdate)"
					+ "values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			
			// ???
						pstmt.setString(1, mb.getId());
						pstmt.setString(2, mb.getPw());
						pstmt.setString(3, mb.getName());
						pstmt.setInt(4, mb.getAge());
						pstmt.setString(5, mb.getGender());
						pstmt.setString(6, mb.getEmail());
						pstmt.setTimestamp(7, mb.getRegdate());
						
						
			// 4. sql 실행
			pstmt.executeUpdate();
			System.out.println(" DAO : 회원가입 성공 ");
			
		} catch (ClassNotFoundException e) {
			System.out.println(" 드라이버 로드 실패! ");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(" 디비연결 실패!! ");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 디비처리동작 끝
			try {
				// 자원 해제
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
				
	}
	
	//회원가입 - inserMember(MB)
	
	
	
	//로그인여부체크 시작 - loginMember(MB)
	public int loginMember(MemberBean mb){
		// 1- 로그인, 0-비밀번호 오류, -1 -아이디 오류 
		int result = -1;
			
		
		try {
			//1.2 디비연결
			con = getCon();
			// 3. SQL 작성(select) & pstmt 객체
			String sql = "select pw from cool_member where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//???
			pstmt.setString(1, mb.getId());
			
			// 4. SQL 실행
			ResultSet rs = pstmt.executeQuery();
			
			// 5. 데이터 처리
			if(rs.next()){
				//아이디 있음
				if(mb.getPw().equals(rs.getString("pw"))){
					//로그인 성공 
					result = 1;
					
				}else {
					//비밀번호 오류
					result = 0;
					
				}
				
			}else {
				//아이디 없음
				result = -1;
			}
			
			System.out.println(" DAO : 로그인 체크 완료 ("+result+")");
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		return result;
	}

	// 로그인여부체크 끝 - loginMember(MB)
	
	
	//회원정보 조회 - getMember(id)
	public MemberBean getMember(String id){
		//회원 정보를 저장할 객체 
		MemberBean mb = new MemberBean();
		
		try {
			//1.2  드라이버로드  디비 연결 
			con = getCon();
			//3. sql & pstmt 
			// 특정유저의 모든 정보를 조회
			sql = "select * from cool_member where id=?";
			pstmt = con.prepareStatement(sql);
			
			//???
			pstmt.setString(1, id);
			
			
			//5. 데이터 처리 
			if(rs.next()) {
				//데이터 있을 때 조회된 회원정보를 저장
				
				mb.setId(rs.getString("id"));
				mb.setPw(rs.getString("pw"));
				mb.setName(rs.getString("name"));
				mb.setAge(rs.getInt("age"));
				mb.setGender(rs.getString("gender"));
				mb.setEmail(rs.getString("email"));
				mb.setRegdate(rs.getTimestamp("regdate"));
				
				System.out.println(" DAO : 회원정보 저장 완료 ");
				
			}
			System.out.println(" DAO : 조회된 회원정보 ");
			System.out.println(" DAO : "+ mb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		return mb;
		
	}
			
	//정보 수정메서드 (이름,나이,성별,이메일) - updateMember(MB)
	public int updateMember(MemberBean mb){
		//수정결과 : 1 수정성공, 0 수정실패(비밀번호), -1수정실패(비회원) 
		int result = -1;
		
		try {
			//1.2. 디비연결
			con=getCon();
			
			//3. sql & pstmt
			// 1) 수정하려는 정보가 회원, 본인여부 체크
			
			sql = "select pw from cool_member where id=?";
			pstmt = con.prepareStatement(sql);
			
			
			// ???? 
			pstmt.setString(1, mb.getId());
			
			// 4. sql 실행
			rs = pstmt.executeQuery();
			
			//5. 데이터 처리
				//2) 본인일때만, 정보수정
			if(rs.next()){
				//회원
				if(mb.getPw().equals(rs.getString("pw"))){
					//회원, 비밀번호 동일 => 본인 
					
					//3. sql (update) & pstmt
					//특정 사용자의 정보(이름,나이,성별,이메일)을 수정
					sql = "update cool_member set name=?, age=?,,gender=?,email=? where id=?";
					pstmt = con.prepareStatement(sql);
					
					// ??? 
					pstmt.setString(1, mb.getName());
					pstmt.setInt(2,mb.getAge());
					pstmt.setString(3, mb.getGender());
					pstmt.setString(4, mb.getEmail());
					pstmt.setString(5, mb.getId());
					
					// 4. sql 실행
					pstmt.executeUpdate();
					
					result = 1;
					System.out.println("DAO : 정보 수정 완료!");
					
				}else{
					// 회원, 비밀번호 오류
					result = 0;
				}
			}else{
				//비회원
				result = -1;
			}
			
			System.out.println(" DAO : 디비동작 처리 끝(수정처리)("+result+")");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		return result;
	}
	// 정보 수정메서드(이름,나이,성별,이메일) - updateMember(MB)'
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
