package kr.co.devst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.devst.model.UserVO;
import kr.co.devst.service.UserService;



@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/devst", method = RequestMethod.GET)
	public String goIdx() {
		return "/index";
	}
	
	@RequestMapping(value = "/devst/join", method = RequestMethod.GET)
	public String goJoin(Model model) {
		return "/user/join";
	}
	
	@RequestMapping(value = "/devst/join", method = RequestMethod.POST)
	public String doJoin(Model model, UserVO param) {
		System.out.println("컨트롤러 실행");
		System.out.println(param.getId());
		System.out.println(param.getPw());
		System.out.println(param.getName());
		System.out.println(param.getNick());
		userService.doJoin(param);
		
		return "/user/login";
	}
	

}
