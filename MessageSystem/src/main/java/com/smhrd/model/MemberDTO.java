package com.smhrd.model;

public class MemberDTO {

	// DTO ==> 서로다른 클래스 간 데이터를 공유
	
	// 1. 필드
	// --> DTO를 설계할 때는 테이블 단위로 설계!!
	// tip! 필드명을 지어줄 때 테이블 컬럼명을 그대로 지어주는 것이 좋다!
	private String email;
	private String pw;
	private String tel;
	private String address;
	
	
	
	// 2. 메소드
	// --> 기본 생성자, 모든 필드 값 받아서 초기화 시킬 수 있는 생성자
	// --> getter, setter 메소드
	
	// 기본생성자
	public MemberDTO(String email, String pw, String tel, String address) {
		super();
		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
	}
	
	
	// 생성자 메소드
	public MemberDTO() {
	}

	// getter setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
