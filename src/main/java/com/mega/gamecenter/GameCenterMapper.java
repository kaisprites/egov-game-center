package com.mega.gamecenter;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper ("GameCenterMapper")
public interface GameCenterMapper {
	void signup(GameCenterVO vo);
	GameCenterVO selectOne(GameCenterVO vo);
	List<?> selectList(GameCenterVO vo);
	void delete(GameCenterVO vo);
} 
