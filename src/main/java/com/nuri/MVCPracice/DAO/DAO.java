package com.nuri.MVCPracice.DAO;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nuri.MVCPracice.VO.BoardVO;
import com.nuri.MVCPracice.VO.MemberVO;

public interface DAO {
	public MemberVO login(MemberVO memberVO) throws DataAccessException;
	public List<BoardVO> listAll() throws DataAccessException;
	public BoardVO listOne(int no) throws DataAccessException;
	public void add(BoardVO boardVO) throws DataAccessException;
	public void delete(int no) throws DataAccessException;
}
