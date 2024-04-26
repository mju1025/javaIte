package comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.CommentService;
import comment.vo.CommentVO;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/commentdelete")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
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
		// 댓글을 삭제한다!!
		// 수정하려면 comment_id를 가져오자 
		request.setCharacterEncoding("UTF-8");
        String comment_id = request.getParameter("comment_id");
        String post_id = request.getParameter("post_id");

        System.out.println("ajax로 내용이 온건가???"+comment_id);
        
        CommentVO vo = new CommentVO();
        vo.setComment_id(Integer.parseInt(comment_id));
        // comment_id로  댓글을 삭제 해야한다!!
        
        CommentService service = new CommentService();
        int result = service.deleteContent(vo);
        
        if(result == 1) {
        	System.out.println("댓글내용이 삭제되었습니다!!");
	        response.sendRedirect("http://localhost:8080/board/detail?postId="+post_id);

        }else {
        	System.out.println("댓글내용이 삭제되지 않았습니다!!");
        }
	}

}
