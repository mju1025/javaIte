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
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/update")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
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
		//업데이트 멤버 정보를 받아와서
		String updateid = request.getParameter("updateid");
		String updatepassword = request.getParameter("updatepassword");
		// 입력을 받아서 VO로 만든다!!
		MemberVO updatevo = new MemberVO();
		updatevo.setMember_id(updateid);
		updatevo.setPassword(updatepassword);
		
		// service에서 클라이언트 아이디 비번업데이트하자!
		MemberService updateservice = new MemberService();
		int check = updateservice.updatePassword(updatevo);
		if(check == 1) {// 업데이트 되었으면
			//클라이언트의 멤버 정보 session 생성
			HttpSession session = request.getSession(true);
			// 세션에 새로운 멤버 정보를 저장
			session.setAttribute("UPDATE_DATA", updatevo);
			System.out.println("수정되었습니다!!!");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/boards");
//			dispatcher.forward(request, response);
			response.sendRedirect("http://localhost:8080/board/boards");

		}else {
			System.out.println("정보수정이 안됨!!");
		}
	}

}
