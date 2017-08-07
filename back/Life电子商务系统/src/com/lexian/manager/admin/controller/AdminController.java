package com.chinasofti.lexian.manager.admin.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.lexian.manager.admin.service.AdminService;
import com.chinasofti.lexian.manager.admin.vo.Manager;
import com.chinasofti.lexian.manager.admin.vo.Role_Manager;

@Controller
@RequestMapping("/login")
public class AdminController {

	private AdminService adminService;
	
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping("manager.do")
	public String manager(@ModelAttribute("model") Manager manager, Model model) throws Exception {
		List<Manager> clzlistmanager = this.adminService.managerAll(manager);
		for (Manager manager1 : clzlistmanager) {
			manager1.setCreatetime(manager1.getCreatetime().substring(0, 19));
			manager1.setUpdatetime(manager1.getUpdatetime().substring(0, 19));
		}
		model.addAttribute("clzlistmanager", clzlistmanager);
		model.addAttribute("pageBean", manager);
		return "manager";
	}
	
	
	@RequestMapping(value="managersearch.do",method=RequestMethod.POST)
	public String managerSelect(Manager manager, String selectInfo, Model model) throws Exception{
		System.out.println(selectInfo);
		manager.setName(selectInfo);
		List<Manager> clzlistma = this.adminService.select(manager);
		for (Manager mana : clzlistma) {
			mana.setCreatetime(mana.getCreatetime().substring(0, 19));
			mana.setUpdatetime(mana.getUpdatetime().substring(0, 19));
		}
		model.addAttribute("Info", selectInfo);
		model.addAttribute("clzlistmanager", clzlistma);
		model.addAttribute("pageBean", manager);
		return "manager";
	}

	// 更改manager状态
	@RequestMapping("updateManager.do")
	public String updateManagerStatus(@ModelAttribute("model") Manager manager, String Info, Model model, int status1, int id1)
			throws Exception {
		manager.setId(id1);
//		System.out.println(manager.getId());
		if (status1 == 1) {
			manager.setStatus(2);
		} else if (status1 == 2) {
			manager.setStatus(1);
		}
		try {
			this.adminService.updateManagerStatus(manager);

		} catch (Exception e) {
			// TODO: handle exception
		}
		manager.setName(Info);
		List<Manager> clzlistma = this.adminService.select(manager);
		for (Manager mana : clzlistma) {
			mana.setCreatetime(mana.getCreatetime().substring(0, 19));
			mana.setUpdatetime(mana.getUpdatetime().substring(0, 19));
		}
		model.addAttribute("Info", Info);
		model.addAttribute("clzlistmanager", clzlistma);
		model.addAttribute("pageBean", manager);
		return "manager";
	}

	// 更改manager密码
	@RequestMapping("updateManagerPassword.do")
	public String updateManagerPassword(@ModelAttribute("model") Manager manager, Model model, int id1)
			throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		manager.setUpdatetime(time);
		manager.setId(id1);
		manager.setPassword("123456");
		try {
			this.adminService.updateManagerPassword(manager);

		} catch (Exception e) {
			// TODO: handle exception
		}
		List<Manager> clzlist = this.adminService.managerAll(manager);
		for (Manager manager1 : clzlist) {
			manager1.setCreatetime(manager1.getCreatetime().substring(0, 19));
			manager1.setUpdatetime(manager1.getUpdatetime().substring(0, 19));
		}
		model.addAttribute("clzlistmanager", clzlist);
		model.addAttribute("pageBean", manager);
		return "manager";
	}

	@RequestMapping("fanhui.do")
	public String fanhui(@ModelAttribute("model") Manager manager, Model model) {
		List<Manager> clzlistmanager = this.adminService.managerAll(manager);
		for (Manager manager1 : clzlistmanager) {
			manager1.setCreatetime(manager1.getCreatetime().substring(0, 19));
			manager1.setUpdatetime(manager1.getUpdatetime().substring(0, 19));
		}
		model.addAttribute("clzlistmanager", clzlistmanager);
		model.addAttribute("pageBean", manager);
		return "manager";
	}

	// 删除
	@RequestMapping("deleteManager.do")
	public String delete(@ModelAttribute("model") Manager manager, Model model, int id2, Role_Manager role_manager)
			throws Exception {
//		System.out.println(id2);
		role_manager.setManager_id(id2);
		this.adminService.deleteRole_manager(role_manager);
		manager.setId(id2);
		int a = this.adminService.delete(manager);
		if (a < 0) {
			return "insert";
		}
		List<Manager> clzlist = this.adminService.managerAll(manager);
		model.addAttribute("clzlistmanager", clzlist);
		model.addAttribute("pageBean", manager);
		return "manager";
	}

	@RequestMapping(value="addRole.do",method=RequestMethod.POST)
	public String addRole() {
		return "addRole";
	}

	@RequestMapping(value="insertRole.do",method=RequestMethod.POST)
	public String inserRole(Manager manager, Model model, HttpServletRequest request, Role_Manager role_manager) {
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(date);
			manager.setCreatetime(time);
			manager.setUpdatetime(time);
			manager.setStatus(1);
			int a = adminService.insertRole(manager);
			if (a > 0) {
				List<Manager> clzlistmanager = this.adminService.managerAll(manager);
				for (Manager manager1 : clzlistmanager) {
					manager1.setCreatetime(manager1.getCreatetime().substring(0, 19));
					manager1.setUpdatetime(manager1.getUpdatetime().substring(0, 19));
				}
				model.addAttribute("clzlistmanager", clzlistmanager);
				model.addAttribute("pageBean", manager);
				String[] a1 = request.getParameterValues("role");
				for (int i = 0; i < a1.length; i++) {
					role_manager.setRole_id(Integer.parseInt(a1[i]));
					role_manager.setManager_id(clzlistmanager.get(clzlistmanager.size() - 1).getId());
					this.adminService.insertRole_manager(role_manager);
					// System.out.println(Integer.parseInt(a1[i]));
					// System.out.println(clzlistmanager.get(clzlistmanager.size()
					// - 1).getId());

				}
				return "manager";
			}
		} catch (Exception e) {
			return "addRoleError";
		}
		return "addRole";
	}

	@RequestMapping("relevance.do")
	public String relevanceRole(String name, Model model, int managerid,Manager manager) {
		model.addAttribute("name", name);
		model.addAttribute("managerid", managerid);
		model.addAttribute("pageBean", manager);
		return "relevanceRole";
	}

	// 关联角色
	@RequestMapping("insertRole_Manager.do")
	public String updateRole(Manager manager, Role_Manager role_manager, Model model, HttpServletRequest request) {
		try
		{
		int id = manager.getId();
		role_manager.setManager_id(id);

		this.adminService.deleteRole_manager(role_manager);

		List<Manager> clzlistmanager = this.adminService.managerAll(manager);
		for (Manager manager1 : clzlistmanager) {
			manager1.setCreatetime(manager1.getCreatetime().substring(0, 19));
			manager1.setUpdatetime(manager1.getUpdatetime().substring(0, 19));
		}
		model.addAttribute("clzlistmanager", clzlistmanager);
		String[] a1 = request.getParameterValues("role");
		for (int i = 0; i < a1.length; i++) {
//			System.out.println(a1[i]);
			role_manager.setRole_id(Integer.parseInt(a1[i]));
			role_manager.setManager_id(id);
			this.adminService.insertRole_manager(role_manager);
//			System.out.println(Integer.parseInt(a1[i]));
//			System.out.println(id);

		}

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		List<Manager> clzlist = this.adminService.managerAll(manager);
		for (Manager manager1 : clzlist) {
			manager1.setCreatetime(manager1.getCreatetime().substring(0, 19));
			manager1.setUpdatetime(time);
			manager1.setUpdatetime(manager1.getUpdatetime().substring(0, 19));

		}
		model.addAttribute("clzlistmanager", clzlist);
		model.addAttribute("pageBean", manager);
		}catch(Exception e)
		{
			return "managerError";
		}
		return "manager";
	}

	@RequestMapping("modification.do")
	public String updateInfo(@ModelAttribute("model") Manager manager, Model model, String name, String info,HttpServletRequest request) throws UnsupportedEncodingException {
		String avi = request.getParameter("info");
		avi = new String(avi.getBytes("iso-8859-1"), "utf-8");
		model.addAttribute("name", name);
		model.addAttribute("info", avi);
		model.addAttribute("pageBean", manager);
		return "modification";
	}

	// 修改权限信息
	@RequestMapping("modification1.do")
	public String updateInfo1(@ModelAttribute("model") Manager manager, String name, Model model,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

		manager.setName(name);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		manager.setUpdatetime(time);
		String avi = request.getParameter("info");
		avi = new String(avi.getBytes("iso-8859-1"), "utf-8");
		manager.setInfo(avi);
//		System.out.println(avi);
		try {
			this.adminService.updateInfo(manager);

		} catch (Exception e) {
			// TODO: handle exception
		}

		List<Manager> clzlist = this.adminService.managerAll(manager);
		for (Manager manager1 : clzlist) {
			manager1.setCreatetime(manager1.getCreatetime().substring(0, 19));
			manager1.setUpdatetime(manager1.getUpdatetime().substring(0, 19));
		}
		model.addAttribute("clzlistmanager", clzlist);
		model.addAttribute("pageBean", manager);
		return "manager";

	}

	// 返回
	@RequestMapping("return.do")
	public String returnBack(@ModelAttribute("model") Manager manager, Model model) {
		List<Manager> clzlistmanager = this.adminService.managerAll(manager);
		for (Manager manager1 : clzlistmanager) {
			manager1.setCreatetime(manager1.getCreatetime().substring(0, 19));
			manager1.setUpdatetime(manager1.getUpdatetime().substring(0, 19));
		}
		model.addAttribute("clzlistmanager", clzlistmanager);
		model.addAttribute("pageBean", manager);
		return "manager";
		
	}

	
	@RequestMapping("wtq.do")
	public String fanHui()
	{
		return "addRole";
	}
	@RequestMapping("wtq1.do")
	public String fanHui1(Model model,Manager manager)
	{
		List<Manager> clzlist =adminService.managerAll(manager);
		for(Manager manager1:clzlist){
			manager1.setCreatetime(manager1.getCreatetime().substring(0,19));
			manager1.setUpdatetime(manager1.getUpdatetime().substring(0,19));
		}
		model.addAttribute("clzlistmanager", clzlist);
		model.addAttribute("pageBean",manager);
		return "manager";
	}
}
