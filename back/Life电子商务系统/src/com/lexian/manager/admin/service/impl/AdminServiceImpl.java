package com.chinasofti.lexian.manager.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.lexian.manager.admin.dao.AdminDao;
import com.chinasofti.lexian.manager.admin.service.AdminService;
import com.chinasofti.lexian.manager.admin.vo.Manager;
import com.chinasofti.lexian.manager.admin.vo.Role_Manager;

@Service
public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;
	
	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public List<Manager> managerAll(Manager manager1) {
		List<Manager> manager = this.adminDao.selectPagemanagerAll(manager1);
		return manager;
	}

	// 更改manager状态
	public int updateManagerStatus(Manager manager) {
		return this.adminDao.updateManagerStatus(manager);
	}

	// 更改manager密码
	public int updateManagerPassword(Manager manager) {

		return this.adminDao.updateManagerPassword(manager);
	}

	// 删除
	public int delete(Manager manager) {
		return this.adminDao.deleteManager(manager.getId());
	}

	public int deleteRole_manager(Role_Manager role_manager) {
		return this.adminDao.deleteRole_Manager(role_manager.getManager_id());
	}

	public int insertRole(Manager manager) {
		int a = this.adminDao.insertRole(manager);
		return a;
	}

	public int insertRole_manager(Role_Manager role_manager) {
		int a = this.adminDao.insertRole_Manager(role_manager);
		return a;
	}

	// 修改用户信息
	public int updateInfo(Manager manager) {
		return this.adminDao.updateInfo(manager);
	}

	public List<Manager> select(Manager manager) {
		List<Manager> userList = this.adminDao.selectPageselectByLike(manager);
		return userList;
	}


}
