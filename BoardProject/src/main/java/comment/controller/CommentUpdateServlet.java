package comment.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.CommentService;
import comment.vo.CommentVO;

/**
 * Servlet implementation class CommentUpdateServlet
 */
@WebServlet("/commentupdate")
public class CommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentUpdateServlet() {
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
		// 댓글을 수정한다!!
		// 수정하려면 comment_id, content를 가져오자 
        // 클라이언트로부터 전송된 데이터 읽기
		request.setCharacterEncoding("UTF-8");
        String comment_id = request.getParameter("comment_id");
        String post_id = request.getParameter("post_id");
        String content = request.getParameter("content");

        
        CommentVO vo = new CommentVO();
        vo.setComment_id(Integer.parseInt(comment_id));
        vo.setContent(content);
        // comment_id로  content 내용을 수정해야한다!!
        
        CommentService service = new CommentService();
        int result = service.updateContent(vo);
        
        if(result == 1) {// 데이터베이스에서 수정을 실행했다면?? ajax로!!
        	System.out.println("댓글내용이 수정되었습니다!!");
        }else {
        	System.out.println("댓글내용이 수정이 안되었습니다!!");
        }

    	
	}

}
