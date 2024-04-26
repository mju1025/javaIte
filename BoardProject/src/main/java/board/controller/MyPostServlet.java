package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.vo.BoardVO;
import member.vo.MemberVO;

/**
 * Servlet implementation class MyPostServlet
 */
@WebServlet("/mypost")
public class MyPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPostServlet() {
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
		// 내 게시글을 수정할거다!! postid에 대한 정보를 받아서 mywriteupdate.jsp 로보내자!
		String post_id = request.getParameter("postid");
		BoardVO vo = new BoardVO();
		vo.setPost_id(Integer.parseInt(post_id));
		
		
		// post_id 정보를 request에 속성으로 설정
		request.setAttribute("post_id", post_id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mywriteupdate.jsp"); // jsp 파일의 경로 지정
		dispatcher.forward(request, response); // 저장한 데이터를 포함하여 jsp 파일로 포워딩
	
	}

}
