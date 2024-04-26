package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
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
		//로그인 멤버 정보를 받아와서
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 입력을 받아서 VO로 만든다!!
		MemberVO loginvo = new MemberVO();
		loginvo.setMember_id(id);
		loginvo.setPassword(password);
		
		// service에서 클라이언트 아이디 비번이 맞는지 확인!
		MemberService loginservice = new MemberService();
		int check = loginservice.checkIdPassword(loginvo);
		if(check == 1) {
			//클라이언트의 멤버 정보 session 생성
			HttpSession session = request.getSession(true);
			//System.out.println(loginvo.toString());
			session.setAttribute("LOGIN_MEMBER_DATA", loginvo);
			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/boards");
//			dispatcher.forward(request, response);
			response.sendRedirect("http://localhost:8080/board/boards");
		}else {
			System.out.println("로그인 안됨!!");
		}
	}

}
