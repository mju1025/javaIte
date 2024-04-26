package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.BoardVO;
import member.vo.MemberVO;
/**
 * Servlet implementation class boardServlet
 */
@WebServlet("/boards")
public class boardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 게시글의 정보를 받아와서 board.jsp로 넘겨주자!
		// service에서 모든 게시글에 대한 정보를 받아온다!
		BoardService boardservice = new BoardService();
		List<BoardVO> allPosts = boardservice.getAllPosts();
		request.setAttribute("allPosts", allPosts); // "allPosts"라는 이름으로 데이터를 설정하여 request에 저장

		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			MemberVO loginvo = (MemberVO)session.getAttribute("LOGIN_MEMBER_DATA");
			if(loginvo != null) {
				// 세션에서 데이터를 성공적으로 가져왔을 때 수행할 작업
				//System.out.println(loginvo.toString());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/board.jsp"); // jsp 파일의 경로 지정
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

}
