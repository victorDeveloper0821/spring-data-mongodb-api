package idv.victor.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.victor.entity.Users;
import idv.victor.service.MemberService;

@RequestMapping(value="/api/user")
@Controller
public class UserController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/create",method= RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String createUser(HttpServletRequest req,Model model,@RequestBody Users user) {
		return memberService.doSave(user);
		
	}
	
	@RequestMapping(value="/update/{id}",method= RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateUser(HttpServletRequest req,Model model,@RequestBody Users user,@PathVariable String id) {
		return memberService.doUpdate(id, user);
		
	}

	@RequestMapping(value="/findOne/{id}",method= RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String findUser(HttpServletRequest req,Model model,@PathVariable String id) {
		return memberService.findOne(id);
		
	}
	
	@RequestMapping(value="/list",method= RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String listUsers(HttpServletRequest req,Model model) {
		return memberService.findAll();
		
	}

	@RequestMapping(value="/delete/{id}",method= RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String deleteUsers(HttpServletRequest req,Model model,@PathVariable String id) {
		return memberService.deleteUser(id);
		
	}


}
