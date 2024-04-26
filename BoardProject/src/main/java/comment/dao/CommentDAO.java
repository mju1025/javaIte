package comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import comment.vo.CommentVO;

public class CommentDAO {
	private SqlSession session;
	
	public CommentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentDAO(SqlSession session) {
		this.session = session;
	}

	public List<CommentVO> selectByPostid(CommentVO vo) throws Exception {
		List<CommentVO> result = session.selectList("comments.commentsByPostId", vo);
		
		return result;
	}

	public int commentinsert(CommentVO commentvo) throws Exception {
		int result = session.insert("comments.commentinsert", commentvo);
		return result;
	}

	public int commentupdate(CommentVO vo) throws Exception {
		int result = session.update("comments.commentupdate",vo);
		return result;
	}

	public int commentdelete(CommentVO vo) {
		int result = session.delete("comments.commentdelete",vo);
		return result;
	}
}
