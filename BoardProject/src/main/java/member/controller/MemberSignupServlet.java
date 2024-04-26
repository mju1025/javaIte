package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class MemberSignupServlet
 */
@WebServlet("/signup")
public class MemberSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보 아이디 받아오기
		request.setCharacterEncoding("UTF-8"); 
		String signupid = request.getParameter("signupid");
		String signuppassword = request.getParameter("signuppassword");
		String signupname = request.getParameter("signupname");

		// 입력을 받아서 VO로 만든다!!
		MemberVO signupvo = new MemberVO();
		signupvo.setMember_id(signupid);
		signupvo.setPassword(signuppassword);
		signupvo.setName(signupname);
		
		MemberService signupservice = new MemberService();
		int isSignup =  signupservice.insertMember(signupvo);	
		//회원가입 됬을시 로그인 페이지로 이동! 
		if(isSignup == 1) {
	        // RequestDispatcher를 사용하여 JSP 파일로 forward
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
	        dispatcher.forward(request, response);
		}else {
			System.out.println("회원가입 안됨!!");
		}
	}

}
