package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.MemberVO;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
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
		//로그인 객체가 있으면 write.jsp로 이동
		HttpSession session = request.getSession(false);
		if(session != null) {
			MemberVO loginvo = (MemberVO)session.getAttribute("LOGIN_MEMBER_DATA");
			if(loginvo != null) {
				// 세션에서 데이터를 성공적으로 가져왔을 때 수행할 작업
				//System.out.println(loginvo.toString());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/write.jsp"); // jsp 파일의 경로 지정
				dispatcher.forward(request, response); // 저장한 데이터를 포함하여 jsp 파일로 포워딩
			} else {
		        // 세션에서 해당 데이터가 없을 때 수행할 작업
				System.out.println("세션에 vo에 대한 데이터가 없음");
		    }
		} else {
		    // 세션이 없을 때 수행할 작업
			System.out.println("세션이 없음");
		}		
		
	}

}
