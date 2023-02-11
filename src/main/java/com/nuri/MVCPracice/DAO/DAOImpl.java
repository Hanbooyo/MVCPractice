package com.nuri.MVCPracice.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.nuri.MVCPracice.VO.MemberVO;

@Repository("DAO")
public class DAOImpl implements DAO{
	
	@Autowired
	private SqlSession sqlSession;


	@Override
	public MemberVO login(MemberVO memberVO) throws DataAccessException {
		MemberVO vo = sqlSession.selectOne("mapper.member.login", memberVO);
		return vo;
	}

}
