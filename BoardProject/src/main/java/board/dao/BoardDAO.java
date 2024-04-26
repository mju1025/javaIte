package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;

public class BoardDAO {
	
	private SqlSession session;
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
	}

	public BoardDAO(SqlSession session) {
		this.session = session;
	}

	public List<BoardVO> getAllPosts() throws Exception{
		List<BoardVO> result = null;
		result = session.selectList("posts.getAllPosts");

		return result;
	}
	
	public BoardVO getDetailPost(BoardVO vo) throws Exception{
		BoardVO result = null;
		result = session.selectOne("posts.getDetailPost", vo);
		
		return result;
	}

	public int insertPost(BoardVO vo) throws Exception{
		int result = 0; 
		result = session.insert("posts.insertPost", vo);
		return result;
	}

	public int updatePost(BoardVO vo) {
		int result = 0; 
		result = session.update("posts.updatePost", vo);
		return result;
	}

	public List<BoardVO> searchPost(String searchtitle) {
		List<BoardVO> result = null;
		result = session.selectList("posts.searchPost", searchtitle);
		return result;
	}

}
