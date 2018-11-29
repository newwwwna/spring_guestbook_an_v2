package com.javalec.guestbook.service;

import java.util.List;

import com.javalec.guestbook.vo.GuestBookVO;

public interface IGuestBookService {

	public void insert(GuestBookVO vo);
	public void delete(GuestBookVO vo);
	public List<GuestBookVO> getGuestBookList();
	public void update(GuestBookVO vo);
	public List<GuestBookVO> search(String keyword);
	public List<GuestBookVO> nameSearch(String keyword);
	public GuestBookVO getGuestBook(GuestBookVO vo);
}
