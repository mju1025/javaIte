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
 * Servlet implementation class WriteUploadServlet
 */
@WebServlet("/writeupload")
public class WriteUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteUploadServlet() {
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
		// 작성한 글을 데이터베이스에 삽입해보자!!
		request.setCharacterEncoding("UTF-8");
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		String post_id = request.getParameter("writeuploadid");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(post_title);
		vo.setContent(post_content);
		vo.setAuthor_id(post_id);
		
		BoardService service = new BoardService();

		int check = service.insertPost(vo);
		if(check == 1) {// 삽입 되었으면
			System.out.println("글이 데이터베이스에 삽입되었습니다!!!");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/boards");
//			dispatcher.forward(request, response);
			response.sendRedirect("http://localhost:8080/board/boards");
		}else {
			System.out.println("정보수정이 안됨!!");
		}
	}

}
