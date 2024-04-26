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
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
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
		String deleteid = request.getParameter("deleteid");
		// 입력을 받아서 VO로 만든다!!
		MemberVO deletevo = new MemberVO();
		deletevo.setMember_id(deleteid);

		
		// service에서 클라이언트 정보를 지우자!
		MemberService deleteservice = new MemberService();
		int check = deleteservice.deleteMember(deletevo);
		if(check == 1) {// 업데이트 되었으면
		    // 사용자가 탈퇴한 경우 세션을 종료하고 제거
		    HttpSession session = request.getSession(false); // 새로운 세션이 생성되지 않도록 false로 지정
		    if (session != null) {
		        session.invalidate(); // 현재 세션을 무효화
		    }
		    System.out.println("회원탈퇴되었습니다. 로그인 페이지로 이동합니다!");
		    // 로그인 페이지로 리다이렉트
		    response.sendRedirect("login.jsp");

		}else {
			System.out.println("회원 탈퇴가 안됨!!");
		}
	}

}
