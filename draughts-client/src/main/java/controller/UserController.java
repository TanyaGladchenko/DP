package controller;


import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.User;
import service.IUserService;

@Controller
public class UserController {
	private static final Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private Validator validator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private IUserService userService;

	@RequestMapping(method=RequestMethod.GET, params="user")
	public String createUser(Model model) {
		model.addAttribute(new User());
		return "jsp/registration";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addUserReg(@Valid User user, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "jsp/registration";
		}
		userService.saveOrUpdate(user);
		return "redirect:/jsp/" + user.getLogin();
	}
	
	@RequestMapping(value="/{login}", method=RequestMethod.GET)
	public String showUserProfile(@PathVariable String login, Model model){
		model.addAttribute(userService.loadByLogin(login));
		return "jsp/profile";
	}
}
