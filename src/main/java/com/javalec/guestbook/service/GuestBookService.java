package com.javalec.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.javalec.guestbook.dao.GuestBookSpringDAO;
import com.javalec.guestbook.vo.GuestBookVO;

@Service("guestbookService")
public class GuestBookService implements IGuestBookService {

	@Autowired
	private GuestBookSpringDAO dao ;
	
	@Override
	public void insert(GuestBookVO vo) {
		
		dao.insert(vo);
	}

	@Override
	public void delete(GuestBookVO vo) {
		dao.delete(vo);

	}

	@Override
	public List<GuestBookVO> getGuestBookList() {
		
		return dao.getList();
	}

	@Override
	public void update(GuestBookVO vo) {
		
		dao.update(vo);
		
	}

	@Override
	public List<GuestBookVO> search(String keyword) {

		return dao.search(keyword);
	}

	@Override
	public List<GuestBookVO> nameSearch(String keyword) {

		return dao.nameSearch(keyword);
	}

	@Override
	public GuestBookVO getGuestBook(GuestBookVO vo) {
		return dao.getGuestBook(vo);
	}
	
	

}
