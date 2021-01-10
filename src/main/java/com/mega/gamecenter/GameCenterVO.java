package com.mega.gamecenter;

public class GameCenterVO {
	// ID
	String id;
	
	// PW
	String password;
	
	// 표시할 이름
	String name;
	
	// 한줄 코멘트
	String comment;
	
	// 사이먼 게임 점수
	Integer simon;
	
	// 2048 게임 점수
	Integer game2048;
	
	// 야구게임 점수
	Integer hit7run;
	
	// 요트 점수
	Integer yacht;
	
	// 카드 뒤집기 점수
	Integer cardflip;
	
	// 정렬기준
	String sortType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getSimon() {
		return simon;
	}

	public void setSimon(Integer simon) {
		this.simon = simon;
	}

	public Integer getGame2048() {
		return game2048;
	}

	public void setGame2048(Integer game2048) {
		this.game2048 = game2048;
	}

	public Integer getHit7run() {
		return hit7run;
	}

	public void setHit7run(Integer hit7run) {
		this.hit7run = hit7run;
	}

	public Integer getYacht() {
		return yacht;
	}

	public void setYacht(Integer yacht) {
		this.yacht = yacht;
	}

	public Integer getCardflip() {
		return cardflip;
	}

	public void setCardflip(Integer cardflip) {
		this.cardflip = cardflip;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	@Override
	public String toString() {
		return "GameCenterVO [id=" + id + ", password=" + password + ", name=" + name + ", comment=" + comment
				+ ", simon=" + simon + ", game2048=" + game2048 + ", hit7run=" + hit7run + ", yacht=" + yacht
				+ ", cardflip=" + cardflip + ", sortType=" + sortType + "]";
	}
}
