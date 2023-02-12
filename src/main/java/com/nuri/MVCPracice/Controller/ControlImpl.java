package com.nuri.MVCPracice.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nuri.MVCPracice.DAO.DAO;
import com.nuri.MVCPracice.VO.BoardVO;
import com.nuri.MVCPracice.VO.MemberVO;
@Controller("Control")
public class ControlImpl implements Control {
	
	@Autowired
	private DAO dao;
	
	@Autowired
	private MemberVO memberVO;
	
	@Autowired
	private BoardVO boardVO;
	
	
	//메인 페이지로 이동
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "main";
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = dao.login(member);
		if(memberVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/main.do");
		}else {
			rAttr.addAttribute("result","loginFailed");
			mav.setViewName("redirect:/main.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/logout.do", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/list.do", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView listAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<BoardVO> list = dao.listAll();
		mav.addObject("list", list);
		mav.setViewName("list");
		return mav;
	}

	@Override
	public ModelAndView listOne(int no, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView remove(int no, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView update(BoardVO boardVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
