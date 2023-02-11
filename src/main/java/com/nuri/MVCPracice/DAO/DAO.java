package com.nuri.MVCPracice.DAO;

import org.springframework.dao.DataAccessException;

import com.nuri.MVCPracice.VO.MemberVO;

public interface DAO {
	public MemberVO login(MemberVO memberVO) throws DataAccessException;
}
