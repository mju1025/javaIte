package member.service;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import member.dao.MemberDAO;
import member.vo.MemberVO;
import mybatis.MyBatisConnectionFactory;

public class MemberService {

	SqlSessionFactory factory = 
			MyBatisConnectionFactory.getSqlSessionFactory();
	
	public int insertMember(MemberVO signupvo) {
		int result = 0;
		SqlSession session = factory.openSession();
		try {
			MemberDAO dao = new MemberDAO(session);
			result = dao.insertMember(signupvo);
			session.commit();
		}catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		
		return result;
	}
	
	
	public int checkIdPassword(MemberVO vo) {
		int result = 0;
		SqlSession session = factory.openSession();
		try {
			MemberDAO dao = new MemberDAO(session);
			result = dao.findMember(vo);
			session.commit();
		}catch (Exception e) {
		}finally {
			session.close();
		}
				
		
		return result;
	}


	public int updatePassword(MemberVO updatevo) {
		int result = 0;
		SqlSession session = factory.openSession();
		try {
			MemberDAO dao = new MemberDAO(session);
			result = dao.updateMember(updatevo);
			session.commit();
		}catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		
		return result;
	}


	public int deleteMember(MemberVO deletevo) {
		int result = 0;
		SqlSession session = factory.openSession();
		try {
			MemberDAO dao = new MemberDAO(session);
			result = dao.deleteMember(deletevo);
			session.commit();
		}catch (Exception e) {
			session.rollback();
			System.out.println(e);
		}finally {
			session.close();
		}
		
		return result;
	}

}
