package com.chinasofti.lexian.manager.role.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.lexian.manager.role.service.RoleService;
import com.chinasofti.lexian.manager.role.vo.Role;

@Controller
@RequestMapping("/login/")
public class RoleController {
	private RoleService roleService;

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	// 查询所有角色的信息
	@RequestMapping("roleList.do")
	public String refernce(Role role, Model model) throws Exception {

		List<Role> rolelist = roleService.searchPageAllRole(role);
		model.addAttribute("rolelist", rolelist);
		model.addAttribute("pageBean", role);

		return "roleList";
	}
	
	@RequestMapping("roleInfo.do")
	
	public String selectRoleInfo(Role role, Model model) throws Exception {
		List<Role> rolelist = roleService.searchselectRoleInfo(role);
		ModelAndView mav=new ModelAndView();
		mav.addObject("rolelist", rolelist);
		mav.setViewName("rolelist");
		mav.addObject("pageBean", role);
		model.addAttribute("rolelist", rolelist);
		model.addAttribute("pageBean", role);

		return "roleList";
	}
	
//	public ModelAndView selectPageLikeAllUser(User user){
//		System.out.println("LIKE-----"+user.getSelectType()+"--------"+user.getSelectInfo());
//		List<User> userList=this.userService.selectPageLikeAllUser(user);
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("userList", userList);
//		mav.setViewName("userList");
//		mav.addObject("pageBean", user);
//		return mav;
//	}

	@RequestMapping("updateRole.do")
	public String updateRole(Integer id, String name, String description, Model model) throws Exception {

		String str = new String(description.getBytes("ISO-8859-1"), "utf-8");
		Role role = new Role();
		role.setName(name);
		role.setDescription(str);

		model.addAttribute("name", name);
		model.addAttribute("des", str);
		model.addAttribute("id", id);

		return "updateList";

	}

	@RequestMapping("updateRoleList.do")
	public String updateRoleList(Role role, Model model) throws Exception {
		long time = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-DD HH-mm-ss");
		String daTime = sdf.format(time);
		try {
			Date date = sdf.parse(daTime);
			role.setUpdatetime(date);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int num = roleService.updateByPrimaryKeySelective(role);
		System.out.println(role.getId());
		System.out.println(role.getName());
		System.out.println(role.getDescription());
		System.out.println(num);
		if (num >= 0) {

			return "redirect:roleList.do";
		}

		return "error";
	}

	// 跳转到添加界面

	@RequestMapping("insertInfo.do")
	public String insert() throws Exception {
		return "insert";

	}

	// 添加角色
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute("model") Role role, Model model) throws Exception {
		long time = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-DD HH-mm-ss");
		String daTime = sdf.format(time);
		try {
			Date date = sdf.parse(daTime);
			role.setCreatetime(date);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int ret = roleService.insert(role);
		
		if (ret == 1)
			return "redirect:roleList.do";
		return "error";
	}

}
