package com.chinasofti.lexian.manager.user.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.lexian.manager.role.vo.Role;
import com.chinasofti.lexian.manager.user.service.UserService;
import com.chinasofti.lexian.manager.user.vo.User;

@Controller
@RequestMapping("/login")
public class UserController {
private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/userList.do")
	public String selectPageNextUser(User user,Model model){
		
		List<User> userList=this.userService.selectPageAllUser(user);
//		for (User use : userList) {
//			System.out.println(use.getLastlogintime());
//
//		}
		model.addAttribute("userList", userList);
		model.addAttribute("pageBean", user);
		return "userList";
	}
//	public ModelAndView selectPageAllUser(User user){
//		List<User> userList=this.userService.selectPageAllUser();
////		for (User user : userList) {
////			String time=user.getLastlogintime();
////			if(time!=null){
////				time=time.substring(0, time.lastIndexOf("."));
////				user.setLastlogintime(time);
////			}
////		}
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("userList", userList);
//		mav.setViewName("userList");
//		return mav;
//	}
	
	@RequestMapping("/changeStatus.do")
	public String changeUserStatus(User user){
		if(user.getStatus()==1)
			user.setStatus(-1);
		else
			user.setStatus(1);
		int num=this.userService.updateUserStatus(user);
		if(num>0)
			if(!"".equals(user.getSelectInfo()))
				return "forward:selectLikeUser.do";
			else
				return "forward:userList.do";
		return "error";
	}
	
	@RequestMapping("/selectLikeUser.do")
	public ModelAndView selectPageLikeAllUser(User user){
//		System.out.println("LIKE-----"+user.getSelectType()+"--------"+user.getSelectInfo());
		List<User> userList=this.userService.selectPageLikeAllUser(user);
		ModelAndView mav=new ModelAndView();
		mav.addObject("userList", userList);
		mav.setViewName("userList");
		mav.addObject("pageBean", user);
		return mav;
	}
	
	@RequestMapping("/changePassword.do")
	public String changePassword(String phone,String passwd, Model model) throws Exception {

		model.addAttribute("phone", phone);
		model.addAttribute("passwd", passwd);

		return "changePassword";

	}

	@RequestMapping("/updatePassword.do")
	public String updatePassword(User user, Model model) throws Exception {

		int num = userService.updatePassword(user);
		System.out.println(num);
		if (num >= 0) {

			return "login";
		}

		return "error";
	}

	
	
}
