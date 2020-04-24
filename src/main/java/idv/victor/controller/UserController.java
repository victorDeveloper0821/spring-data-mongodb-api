package idv.victor.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.victor.dao.UserRepository;
import idv.victor.entity.Users;

@RequestMapping(value="/api/user")
@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/create",method= RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public Users createUser(HttpServletRequest req,Model model,@RequestBody Users user) {
		user.setId(ObjectId.get().toHexString());
		userRepository.save(user);
		return user;
		
	}
	
	@RequestMapping(value="/update/{id}",method= RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public Users updateUser(HttpServletRequest req,Model model,@RequestBody Users user,@PathVariable String id) {
		Users userToEdit = userRepository.findById(id).orElse(null);
		if(Objects.nonNull(user)) {
			userToEdit.setUserid(user.getUserid());
			userToEdit.setPassword(user.getPassword());
			userToEdit.setEmail(user.getEmail());
		}
		userRepository.save(userToEdit);
		return userToEdit;
		
	}

	@RequestMapping(value="/findOne/{id}",method= RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public Users findUser(HttpServletRequest req,Model model,@PathVariable String id) {
		return userRepository.findById(id).orElse(null);
		
	}
	
	@RequestMapping(value="/list",method= RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public List<Users> listUsers(HttpServletRequest req,Model model) {
		return userRepository.findAll();
		
	}


}
