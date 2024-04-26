package comment.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import comment.dao.CommentDAO;
import comment.vo.CommentVO;
import mybatis.MyBatisConnectionFactory;

public class CommentService {
	
	SqlSessionFactory factory = 
			MyBatisConnectionFactory.getSqlSessionFactory();
	

	public List<CommentVO> selectByPostid(CommentVO vo) {
		List<CommentVO> result = null;
		SqlSession session = factory.openSession();
		try {
			CommentDAO dao = new CommentDAO(session);
			result = dao.selectByPostid(vo);
			//System.out.println(result.get(0).toString());
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		
		
		return result;
	}

	public int commentwrite(CommentVO commentvo) {
		int result = 0; 
		SqlSession session = factory.openSession();
		try {
			CommentDAO dao = new CommentDAO(session);
			result = dao.commentinsert(commentvo);
			session.commit();
		}catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		
		return result;
	}


	public int updateContent(CommentVO vo) {
		int result = 0;
		SqlSession session = factory.openSession();
		try {
			CommentDAO dao = new CommentDAO(session);
			result = dao.commentupdate(vo);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	
	public int deleteContent(CommentVO vo) {
		int result = 0;
		SqlSession session = factory.openSession();
		try {
			CommentDAO dao = new CommentDAO(session);
			result = dao.commentdelete(vo);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}

}
