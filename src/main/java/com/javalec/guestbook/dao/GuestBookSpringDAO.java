package com.javalec.guestbook.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.javalec.guestbook.vo.GuestBookVO;

@Repository
public class GuestBookSpringDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(GuestBookVO vo) {
		String sql_insert = "INSERT INTO GUESTBOOK VALUES(guestbook_seq.nextval,?,?,?,SYSDATE)";
		Object args[] = { vo.getName(), vo.getContent(), vo.getPassword() };

		return jdbcTemplate.update(sql_insert, args);
	}

	public int delete(GuestBookVO vo) {
		String sql_delete = "DELETE FROM GUESTBOOK WHERE NO=? AND PASSWORD=?";
		return jdbcTemplate.update(sql_delete, vo.getNo(), vo.getPassword());

	}

	public GuestBookVO getGuestBook(GuestBookVO vo) {

		String sql_selectone = "SELECT NO, NAME, CONTENT, PASSWORD, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') regdate from guestbook WHERE NO=?";
		Object args[] = { vo.getNo() };
		return  jdbcTemplate.queryForObject(sql_selectone, args, new GuestBookMapper());
	}

	public List<GuestBookVO> getList() {
		String sql_list = "select no, name, content, password, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') regdate from guestbook order by reg_date desc";
		return jdbcTemplate.query(sql_list, new GuestBookMapper());
	}

	public int update(GuestBookVO vo) {
		String sql_update = "UPDATE GUESTBOOK SET NAME=?, CONTENT=?, PASSWORD=?, REG_DATE=SYSDATE WHERE NO=?";
		return jdbcTemplate.update(sql_update, vo.getName(), vo.getContent(), vo.getPassword(), vo.getNo());
	}

	public List<GuestBookVO> search(String keyword) {
		String sql_search = "select no, name, content, password, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') regdate from guestbook where content like ?";
		Object args[] = { "%"+keyword+"%" };
		return jdbcTemplate.query(sql_search, args, new GuestBookMapper());
		
	}

	public List<GuestBookVO> nameSearch(String keyword) {
		String sql_nameSearch = "select no, name, content, password, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') regdate from guestbook where name like ?";
		Object args[] = { "%"+keyword+"%" };
		return jdbcTemplate.query(sql_nameSearch, args, new GuestBookMapper());
	

	}
}