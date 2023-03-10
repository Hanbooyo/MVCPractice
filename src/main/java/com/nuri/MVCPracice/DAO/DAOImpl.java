package com.nuri.MVCPracice.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.nuri.MVCPracice.VO.BoardVO;
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


	@Override
	public List<BoardVO> listAll() throws DataAccessException {
		List<BoardVO> result = sqlSession.selectList("mapper.board.listAll");
		return result;
	}


	@Override
	public BoardVO listOne(int no) throws DataAccessException {
		//조회수 +1
		sqlSession.update("mapper.board.views", no);
		BoardVO result = sqlSession.selectOne("mapper.board.listOne", no);
		return result;
	}


	@Override
	public void add(BoardVO boardVO) throws DataAccessException {
		System.out.println("insert 하는중");
		int newNo = sqlSession.selectOne("mapper.board.newNo");
		boardVO.setNo(newNo);
		sqlSession.insert("mapper.board.add", boardVO);
	}


	@Override
	public void delete(int no) throws DataAccessException {
		sqlSession.delete("mapper.board.remove", no);
	}


	@Override
	public void update(BoardVO boardVO) throws DataAccessException {
		sqlSession.delete("mapper.board.mod", boardVO);
	}

}
