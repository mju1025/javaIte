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
import comment.service.CommentService;
import comment.vo.CommentVO;


/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postId = (String)request.getParameter("postId");
		
	    BoardVO vo = new BoardVO();
	    vo.setPost_id(Integer.parseInt(postId));
	    
	    BoardService service = new BoardService();
	    BoardVO detailvo = service.detailPost(vo);

		HttpSession session = request.getSession(false);
		
		
		// 포스트 아이디에 맞는 댓글 리스트를 가져오자!!
		CommentVO commentvo = new CommentVO();
		commentvo.setPost_id(Integer.parseInt(postId));
		
		CommentService commmentservice = new CommentService();
		
		List<CommentVO> commentlist = commmentservice.selectByPostid(commentvo);
		
		// 가져왔으면 comment.jsp에전달하자!!
		
		
		if(session != null) {
			//System.out.println("간건가??");
			request.setAttribute("commentlist", commentlist);
		    request.setAttribute("detailPost", detailvo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/boarddetail.jsp"); // jsp 파일의 경로 지정
			dispatcher.forward(request, response); // 저장한 데이터를 포함하여 jsp 파일로 포워딩

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
