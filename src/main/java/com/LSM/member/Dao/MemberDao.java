package com.LSM.member.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LSM.member.Dto.MemberDto;

@Repository
public class MemberDao {
	
	@Autowired //DI -> 컨테이너 생성된 bean(객체) 자동주입
	JdbcTemplate jdbcTemplate;
	
	//insert문 - 회원추가 구현
	public void insertMember(String memberid, String memberpw, String membername, int memberage) { //DB에 회원 추가
		String sql = "INSERT INTO membertbl VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, memberid,memberpw,membername,memberage);
	}
	//delete문 - 회원 삭제
	public int delelteMember(String memberid) {
		String sql = "DELETE FROM membertbl WHERE memberid=?";
		int result = jdbcTemplate.update(sql, memberid);
		//삭제 성공하면 1, 실패하면 0
		return result;
	}
	//update문 - 회원 수정
	public void updateMember(String memberid, String memberpw, String membername, int memberage) {
		String sql = "UPDATE membertbl SET memberpw=?,membername=?,memberage=? WHERE memberid";
		jdbcTemplate.update(sql, memberid,memberpw,membername,memberage);	
		//정보 수정한 레코드 수를 반환(기본키로 검색) 1 or 0
	}
	//select문 - 회원 검색
	public MemberDto searchMember(String memberid) {
		String sql = "SELECT * FROM membertbl WHERE memberid=?";
		MemberDto mDto = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberDto>(MemberDto.class),memberid);	
		return mDto;
	}
	//select문 - 전체회원 가져오기
		public List<MemberDto> searchMembers() {
			String sql = "SELECT * FROM membertbl";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MemberDto>(MemberDto.class));	
			
		}
}