package comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.service.CommentService;
import comment.vo.CommentVO;
import member.vo.MemberVO;

/**
 * Servlet implementation class CommentWriteServlet
 */
@WebServlet("/commentwrite")
public class CommentWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentWriteServlet() {
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
		// 댓글을 작성해서 보내보자!!
		request.setCharacterEncoding("UTF-8");
		String commentwrite = request.getParameter("commentwrite");
		String postid = request.getParameter("postid");
		
		HttpSession session = request.getSession(false);
		MemberVO loginvo = (MemberVO)session.getAttribute("LOGIN_MEMBER_DATA");
		String authorid = loginvo.getMember_id();
		
		CommentVO commentvo = new CommentVO();
		commentvo.setContent(commentwrite);
		commentvo.setPost_id(Integer.parseInt(postid));
		commentvo.setAuthor_id(authorid);
		
		System.out.println(commentvo.toString());
		
		CommentService service = new CommentService();
		// 삽입되면 1
		int result = service.commentwrite(commentvo);
		if(result == 1) {
			response.sendRedirect("http://localhost:8080/board/detail?postId=" + postid);
			
		}else {
			System.out.println("댓글삽입이 안되었습니다!!!");
			response.sendRedirect("http://localhost:8080/board/detail?postId=" + postid);
		}
		
	}

}
