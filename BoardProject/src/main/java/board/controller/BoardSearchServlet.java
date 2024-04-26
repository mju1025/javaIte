package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.vo.BoardVO;

/**
 * Servlet implementation class BoardSearchServlet
 */
@WebServlet("/search")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchServlet() {
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
		// 게시물 제목 검색기능을 구현하자!!
		request.setCharacterEncoding("UTF-8");
		String searchtitle = request.getParameter("searchValue");

		BoardService boardservice = new BoardService();
		List<BoardVO> searchPostvo = boardservice.searchPosts(searchtitle);
		System.out.println(searchPostvo.get(0).getTitle()); 
		request.setAttribute("allPosts", searchPostvo);
		//vo를 board.jsp로 넘겨주자!
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board.jsp"); // jsp 파일의 경로 지정
		dispatcher.forward(request, response);
	}

}
