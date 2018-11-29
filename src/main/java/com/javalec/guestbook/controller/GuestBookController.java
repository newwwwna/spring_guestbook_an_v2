package com.javalec.guestbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.guestbook.dao.GuestBookSpringDAO;
import com.javalec.guestbook.service.IGuestBookService;
import com.javalec.guestbook.vo.GuestBookVO;

@Controller
public class GuestBookController {

	@Autowired
	private IGuestBookService guestbookService;

	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		session = request.getSession();

		session.setAttribute("id", id);
		session.setAttribute("pw", pw);

		return "getguestbooklist.do";
	}

	@RequestMapping("/getguestbooklist.do")
	public String getList(Model model, HttpServletRequest req, HttpSession session) {
		System.out.println("리스트 조회 컨트롤러입니다.");
		session = req.getSession();
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("pw");

		if (session.isNew() || id == null) {
			return "loginform.jsp";

		} else {

			String keyword = req.getParameter("search");
			List<GuestBookVO> list = null;

			String select = req.getParameter("select");

			if (keyword != null) {
				if (select.equals("name")) {
					list = guestbookService.nameSearch(keyword);
				} else {
					list = guestbookService.search(keyword);
				}
			} else {
				list = guestbookService.getGuestBookList();
			}
			model.addAttribute("list", list);
			return "index.jsp";
		}
	}

	@RequestMapping("/add.do")
	public String add(GuestBookVO vo) {

		guestbookService.insert(vo);
		// dao.insert(vo);
		return "getguestbooklist.do";

	}

	@RequestMapping("/addform.do")
	public String addForm() {

		return "addform.jsp";
	}

	@RequestMapping("/deleteform.do")
	public String deleteForm() {
		
		return "deleteform.jsp";
	}

	@RequestMapping("/delete.do")
	public String delete(GuestBookVO vo) {
		guestbookService.delete(vo);
		return "getguestbooklist.do";
	}

	@RequestMapping("/selectone.do")
	public String selectone(Model model, HttpServletRequest request, GuestBookVO vo) {

		vo = guestbookService.getGuestBook(vo);
		model.addAttribute("vo", vo);

		return "selectone.jsp";

	}

	@RequestMapping("/updatecon.do")
	public String updatecon(HttpServletRequest request) {
		System.out.println(request.getParameter("pwcon"));
		
		System.out.println(request.getParameter("password"));
		if (request.getParameter("pwcon").equals(request.getParameter("password"))) {
		
			return "updateform.jsp";

		} else {
			return "getguestbooklist.do";

		}
	}

	@RequestMapping("/updateform.do")
	public String updateForm() {
		return "updateform.jsp";
	}

	@RequestMapping("/update.do")
	public String update(GuestBookVO vo) {
		guestbookService.update(vo);
		return "getguestbooklist.do";
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "loginform.jsp";
	}

}
