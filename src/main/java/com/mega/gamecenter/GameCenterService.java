package com.mega.gamecenter;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service
public class GameCenterService extends EgovAbstractServiceImpl {
	
	@Resource(name = "GameCenterMapper")
	GameCenterDAO dao;
	
	//하나 가져오기
	public GameCenterVO getOne(GameCenterVO vo) {
		return dao.getOne(vo);
	}

	//회원가입
	public void signup(GameCenterVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}
	
	//아이디 중복검사
	public int idCheck(GameCenterVO vo) {
		// TODO Auto-generated method stub
		GameCenterVO result = dao.getOne(vo);
		if(result != null) return 1;
		else return 0;
	}
	
	//로그인
	public GameCenterVO login(GameCenterVO vo) {
		// TODO Auto-generated method stub
		GameCenterVO result = dao.getOne(vo);
		if (result == null) return null;
		else if(result.getPassword().equals(vo.getPassword())) return result;
		else return null;
	}

	//회원정보 수정
	public void modify(GameCenterVO vo) {
		// TODO Auto-generated method stub
		dao.modify(vo);
	}
	
	//계삭
	public void deleteAccount(GameCenterVO vo) {
		// TODO Auto-generated method stub
		dao.delete(vo);
	}

	//요트 다이스 점수기록
	public void yachtScore(GameCenterVO vo) {
		// TODO Auto-generated method stub
		GameCenterVO result = dao.getOne(vo);
		if(result.getYacht() == null) {
			dao.updateYacht(vo);
		} else if(result.getYacht() < vo.getYacht()) {
			dao.updateYacht(vo);
		}
	}

	//사이먼 점수기록
	public void simonScore(GameCenterVO vo) {
		// TODO Auto-generated method stub
		GameCenterVO result = dao.getOne(vo);
		if(result.getSimon() == null) {
			dao.updateSimon(vo);
		} else if(result.getSimon() < vo.getSimon()) {
			dao.updateSimon(vo);
		}
	}

	//카드 뒤집기 점수기록
	public void cardflipScore(GameCenterVO vo) {
		// TODO Auto-generated method stub
		GameCenterVO result = dao.getOne(vo);
		if(result.getCardflip() == null) {
			dao.updateCardflip(vo);
		} else if(result.getCardflip() > vo.getCardflip()) {
			dao.updateCardflip(vo);
		}
	}

	//야구게임 점수기록
	public void hit7runScore(GameCenterVO vo) {
		// TODO Auto-generated method stub
		GameCenterVO result = dao.getOne(vo);
		if(result.getHit7run() == null) {
			dao.updateHit7run(vo);
		} else if(result.getHit7run() > vo.getHit7run()) {
			dao.updateHit7run(vo);
		}
	}
	
	//2048 점수기록
	public void game2048Score(GameCenterVO vo) {
		// TODO Auto-generated method stub
		GameCenterVO result = dao.getOne(vo);
		if(result.getGame2048() == null) {
			dao.updateGame2048(vo);
		} else if(result.getGame2048() < vo.getGame2048()) {
			dao.updateGame2048(vo);
		}
	}
}
