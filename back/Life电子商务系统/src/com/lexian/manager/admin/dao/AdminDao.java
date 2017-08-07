package com.chinasofti.lexian.manager.admin.dao;

import java.util.List;

import com.chinasofti.lexian.manager.admin.vo.Manager;
import com.chinasofti.lexian.manager.admin.vo.Role_Manager;

public interface AdminDao {

	public List<Manager> selectPagemanagerAll(Manager manager);

	int updateManagerStatus(Manager manager);

	int updateManagerPassword(Manager manager);

	int deleteManager(Integer id);

	int deleteRole_Manager(Integer manager_id);

	int insertRole(Manager manager);

	int insertRole_Manager(Role_Manager role_manager);

	int updateInfo(Manager manager);

	List<Manager> selectPageselectByLike(Manager record);
}
