package org.sandeep.hello.web;

import java.util.List;

import org.sandeep.hello.model.User;
import org.sandeep.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstController {
	private UserService userService;

	@Autowired
	public FirstController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String viewAllUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "index";
	}

}
