package com.mw.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//변수 X,  상수 O 
	//인스턴스 메서드 X, 추상메서드 O 
	//상속을 통해서 추상 메서드를 오버라이딩 사용(강제성) 
	
	/*추상메서드이며, 반드시 오버라이딩해서 사용해야함
	실행할때 request, response 정보를 매개변수로 전달해야하지만 호출 가능 
	호출이 완료되면 ActionForward(주소, 방식이 담긴 객체)라는 정보를 리턴*/
	
	public ActionForward execute(HttpServletRequest request,
					HttpServletResponse response)throws Exception;
	
}
