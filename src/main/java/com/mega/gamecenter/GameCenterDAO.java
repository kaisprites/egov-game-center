package com.mega.gamecenter;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("GameCenterMapper")
public class GameCenterDAO extends EgovAbstractDAO {

	@Autowired
	SqlSessionTemplate session;

	public void insert(GameCenterVO vo) {
		System.out.println(vo);
		session.insert("signup", vo);
	}

	public GameCenterVO getOne(GameCenterVO vo) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOne", vo);
	}
	
	public List<GameCenterVO> getList(GameCenterVO vo) {
		return session.selectList("selectList", vo);
	}
	
	public void modify(GameCenterVO vo) {
		// TODO Auto-generated method stub
		session.update("update", vo);
	}

	public void delete(GameCenterVO vo) {
		session.delete("delete", vo);
	}

	public void updateYacht(GameCenterVO vo) {
		session.update("yacht", vo);
	}

	public void updateSimon(GameCenterVO vo) {
		session.update("simon", vo);
	}

	public void updateCardflip(GameCenterVO vo) {
		session.update("cardflip", vo);	
	}

	public void updateHit7run(GameCenterVO vo) {
		session.update("hit7run", vo);	
	}

	public void updateGame2048(GameCenterVO vo) {
		session.update("game2048", vo);	
	}


}
