package com.mega.gamecenter;	

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameCenterController {
	/** EgovSampleService */
	@Autowired
	private GameCenterService service;
	
	//메인 화면 리다이렉트
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String redirectHome(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		if(session != null) {
			GameCenterVO vo = (GameCenterVO)session.getAttribute("signedUser");
			if(vo != null) {
				GameCenterVO result = service.getOne(vo);
				session.setAttribute("signedUser", result);
			}
		}
		model.addAttribute("loginFailed", "false");
		return "home";
	}
	
	//로그인 로그아웃 회원삭제
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(GameCenterVO vo, ModelMap model, HttpServletRequest request) throws Exception {
		GameCenterVO result = service.login(vo);
		if (result != null) {
			HttpSession session = request.getSession(true);
			result.setPassword("");
			session.setAttribute("signedUser", result);
		} else {
			model.addAttribute("loginFailed", "failed");
		}
		return "redirect:home.do";
	}
	
	@RequestMapping(value = "logout.do", method = RequestMethod.POST)
	public String logout(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("signedUser", null);
		return "redirect:home.do";
	}
	
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		GameCenterVO signed = (GameCenterVO)session.getAttribute("signedUser");
		service.deleteAccount(signed);
		session.setAttribute("signedUser", null);
		return "redirect:home.do";
	}
	
	//회원가입 화면 리다이렉트
	@RequestMapping(value = "signup.do", method=RequestMethod.GET)
	public String redirectSignup(ModelMap model) {
		return "signup";
	}
	
	//회원가입 
	@RequestMapping(value = "signup.do", method=RequestMethod.POST)
	public String postSignup(@ModelAttribute GameCenterVO vo, ModelMap model){
		service.signup(vo);
		return "redirect:home.do";
	}
	
	//회원정보 수정 화면 리다이렉트
	@RequestMapping(value = "modify.do")
	public String redirectModify(ModelMap model) {
		return "modify";
	}
	
	//회원정보 수정
	@RequestMapping(value = "modify.do", method=RequestMethod.POST)
	public String modify(GameCenterVO vo, ModelMap model) {
		System.out.println(vo);
		service.modify(vo);
		return "redirect:home.do";
	}
	
	//아이디 중복 체크
	@RequestMapping(value = "idcheck.do")
	public String idCheck(GameCenterVO vo, ModelMap model) {
		int result = service.idCheck(vo);
		model.addAttribute("result", result);
		return "ajax/idcheck";
	}
	
	//요트 다이스 리다이렉터 
	@RequestMapping(value = "yacht.do")
	public String yacht(ModelMap model) {
		return "game/yacht";
	}
	
	//요트 다이스 점수 기록
	@RequestMapping(value = "yacht.do", method=RequestMethod.POST)
	public void yachtScore(GameCenterVO vo, ModelMap model) {
		service.yachtScore(vo);
	}
	
	//사이먼 리다이렉터 
	@RequestMapping(value = "simon.do")
	public String simon(ModelMap model) {
		return "game/simon";
	}
	
	//사이먼 점수 기록
	@RequestMapping(value = "simon.do", method=RequestMethod.POST)
	public void simonScore(GameCenterVO vo, ModelMap model) {
		service.simonScore(vo);
	}
	
	//카드 뒤집기 리다이렉터
	@RequestMapping(value = "cardflip.do")
	public String cardflip(ModelMap model) {
		return "game/cardflip";
	}
	
	//카드 뒤집기 점수 기록
	@RequestMapping(value = "cardflip.do", method=RequestMethod.POST)
	public void cardflip(GameCenterVO vo, ModelMap model) {
		service.cardflipScore(vo);
	}
	
	//야구게임 리다이렉터
	@RequestMapping(value = "hit7run.do")
	public String hit7run(ModelMap model) {
		return "game/hit7run";
	}
	
	//야구게임 점수 기록
	@RequestMapping(value = "hit7run.do", method=RequestMethod.POST)
	public void hit7run(GameCenterVO vo, ModelMap model) {
		service.hit7runScore(vo);
	}
	
	//2048 리다이렉터
	@RequestMapping(value = "game2048.do")
	public String game2048(ModelMap model) {
		return "game/game2048";
	}
	
	//2048 점수 기록
	@RequestMapping(value = "game2048.do", method=RequestMethod.POST)
	public void game2048(GameCenterVO vo, ModelMap model) {
		System.out.println(vo);
		service.game2048Score(vo);
	}
}
