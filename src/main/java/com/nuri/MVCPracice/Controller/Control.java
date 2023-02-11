package com.nuri.MVCPracice.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nuri.MVCPracice.VO.MemberVO;

public interface Control {
	
	public ModelAndView login(@ModelAttribute("memberVO") MemberVO memberVO,
			RedirectAttributes rAttr, //redirect를 이용할 인스턴스 객체 선언
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
}
