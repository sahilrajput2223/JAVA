package com.sahil.Spring_Boot_CRUD_SP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sahil.Spring_Boot_CRUD_SP.User;
import com.sahil.Spring_Boot_CRUD_SP.UserRepo;
import com.sahil.Spring_Boot_CRUD_SP.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<User> allUser = service.allUser();
		model.addAttribute("allUser",allUser);
		return "index";
	}
	
	@RequestMapping("/newUser")
	public String createNewUser(Model model) {
		User user = new User();
		model.addAttribute("newUser", user);
		return "new_user";
		
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("newUser") User user) {
		service.addUser(user);
		return "redirect:/";
	}
	
	@RequestMapping(value = "edit/{id}")
	public ModelAndView editUser(@PathVariable("id") Long id) {
		ModelAndView andView = new ModelAndView("edit_user");
		User user = service.getUserById(id);
		andView.addObject("editUser",user);
		return andView;
	}
	
	
	@RequestMapping(value = "updateUser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("editUser") User user) {
		service.updateUser(user);
		return "redirect:/";
	}
	
	@RequestMapping("delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		service.deleteUser(id);
		return "redirect:/";
	}
}
