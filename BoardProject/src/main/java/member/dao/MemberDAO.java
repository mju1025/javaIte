package member.dao;

import org.apache.ibatis.session.SqlSession;

import member.vo.MemberVO;

public class MemberDAO {
	private SqlSession session;
	
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDAO(SqlSession session) {
		this.session = session;
	}
	
	public int insertMember(MemberVO vo) throws Exception{
		int result = session.insert("members.insertMember", vo);
		return result;
	}

	public int findMember(MemberVO vo) throws Exception{
		int result = session.selectOne("members.findMember", vo);
		return result;
	}

	public int updateMember(MemberVO vo) throws Exception{
		//System.out.println(vo.toString());
		int result = session.update("members.updateMember", vo);
		return result;
	}

	public int deleteMember(MemberVO vo) throws Exception{
		System.out.println(vo.toString());
		int result = session.delete("members.deleteMember", vo);
		return result;
	}
}
