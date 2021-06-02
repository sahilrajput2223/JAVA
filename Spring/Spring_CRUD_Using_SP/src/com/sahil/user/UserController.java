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
	private UserServices services;
	
	@RequestMapping("/")
	public ModelAndView home() {
	    List<User> allUser = services.allUserData();
	    ModelAndView mav = new ModelAndView("index");
	    mav.addObject("allUser", allUser);
	    return mav;
	}
	
	@RequestMapping("/new")
	public String newUserForm(Map<String, Object> model) {
		User user = new User();
		model.put("newUser", user);
		return "new_user";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("newUser") User user) {
		services.save(user.getUsername(), user.getEmail(), user.getAddress());
		return "redirect:/";
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("newUser") User user) {
		services.updateUser(user);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editUserForm(@RequestParam long id) {
		ModelAndView andView = new ModelAndView("edit_user");
		User user = services.getUserById(id);
		andView.addObject("newUser", user);
		return andView;
	}
	
	@RequestMapping("/delete")
	public String deleteUser(@RequestParam long id) {
		services.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping("/search")
	public ModelAndView searchDataResult(@RequestParam String searchKey) {
		List<User> searchResult = services.search(searchKey);
		ModelAndView andView = new ModelAndView("search_result");
		andView.addObject("searchResult",searchResult);
		return andView;
	}
}
