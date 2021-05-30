package com.sahil.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView andView = new ModelAndView("index");
		List<User> allUser = service.allUser();
		andView.addObject("allUser", allUser);
		return andView;
	}
	
	@RequestMapping("/newUser")
	public String newUserForm(Map<String, Object> model) {
	    User user = new User();
		model.put("user", user);
	    return "new_user";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
	    service.save(user);
	    return "redirect:/";
	}
	
	@RequestMapping("/editUser")
	public ModelAndView editUserForm(@RequestParam long id) {
		ModelAndView andView = new ModelAndView("edit_user");
		User user = service.getUserById(id);
		andView.addObject("user",user);
		return andView;
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam long id) {
		service.deleteUser(id);
		return "redirect:/";
	}
	
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<User> searchResult = service.search(keyword);
		ModelAndView andView = new ModelAndView("search_result");
		andView.addObject("resultUserData",searchResult);
		return andView;
	}
}
