package com.chinasofti.lexian.manager.admin.service;

import java.util.List;

import com.chinasofti.lexian.manager.admin.vo.Manager;
import com.chinasofti.lexian.manager.admin.vo.Role_Manager;

public interface AdminService {

	public List<Manager> managerAll(Manager manager1);

	// 更改manager状态
	public int updateManagerStatus(Manager manager);

	// 更改manager密码
	public int updateManagerPassword(Manager manager);

	// 删除
	public int delete(Manager manager);

	public int deleteRole_manager(Role_Manager role_manager);

	public int insertRole(Manager manager);

	public int insertRole_manager(Role_Manager role_manager);

	// 修改用户信息
	public int updateInfo(Manager manager);

	public List<Manager> select(Manager manager);
}
