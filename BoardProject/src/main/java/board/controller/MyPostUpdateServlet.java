package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.vo.BoardVO;

/**
 * Servlet implementation class MyPostUpdateServlet
 */
@WebServlet("/mypostupdate")
public class MyPostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPostUpdateServlet() {
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
		// 내 게시글을 수정할거다!!
		request.setCharacterEncoding("UTF-8");
		String post_id = request.getParameter("mypostid");
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");

		BoardVO vo = new BoardVO();
		vo.setPost_id(Integer.parseInt(post_id));
		vo.setTitle(post_title);
		vo.setContent(post_content);
		System.out.println(post_content);
		BoardService service = new BoardService();

		int check = service.updatePost(vo);
		if(check == 1) {// 삽입 되었으면
			System.out.println("나의 게시글이 데이터베이스에 수정되었습니다!!!");
			System.out.println(post_id);

			// 리다이렉션 수행
	        response.sendRedirect("/board/detail?postId="+post_id);
		}else {
			System.out.println("정보수정이 안됨!!");
		}
	}

}
