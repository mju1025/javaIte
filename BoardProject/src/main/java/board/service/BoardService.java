package board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.dao.BoardDAO;
import board.vo.BoardVO;
import mybatis.MyBatisConnectionFactory;

public class BoardService {

	SqlSessionFactory factory = 
			MyBatisConnectionFactory.getSqlSessionFactory();
	
	public List<BoardVO> getAllPosts() {
		List<BoardVO> result = null;
		SqlSession session = factory.openSession();
		try {
			BoardDAO dao = new BoardDAO(session);
			result = dao.getAllPosts();
			//System.out.println(result.get(0).toString());
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		
		
		return result;
	}

	public BoardVO detailPost(BoardVO vo) {
		BoardVO result = null;
		SqlSession session = factory.openSession();
		try {
			BoardDAO dao = new BoardDAO(session);
			result = dao.getDetailPost(vo);
			//System.out.println(result.get(0).toString());
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		
		return result;
	}

	public int insertPost(BoardVO vo) {
		int result = 0;
		SqlSession session = factory.openSession();
		try {
			BoardDAO dao = new BoardDAO(session);
			result = dao.insertPost(vo);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		
		return result;
	}

	public int updatePost(BoardVO vo) {
		int result = 0;
		SqlSession session = factory.openSession();
		try {
			BoardDAO dao = new BoardDAO(session);
			result = dao.updatePost(vo);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		
		return result;
	}

	public List<BoardVO> searchPosts(String searchtitle) {
		List<BoardVO> result = null;
		SqlSession session = factory.openSession();
		try {
			BoardDAO dao = new BoardDAO(session);
			result = dao.searchPost(searchtitle);
			session.commit();
		} finally {
			session.close();
		}		
		
		return result;
	}

}
