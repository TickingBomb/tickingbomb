package com.chinasofti.lexian.manager.privilege.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.lexian.manager.privilege.dao.PrivilegeDao;
import com.chinasofti.lexian.manager.privilege.service.PrivilegeService;
import com.chinasofti.lexian.manager.privilege.vo.Administrator;
import com.chinasofti.lexian.manager.privilege.vo.LoginVo;
import com.mchange.v2.resourcepool.ResourcePool.Manager;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	private PrivilegeDao privilegeDao;

	@Autowired
	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}

	// 查出该用户的所有能访问的url地址
    @SuppressWarnings("unused")
	private  List<String> getUrl(int userId) {
		return privilegeDao.getUrl(userId);
	}
   

	@Override
	public String login(LoginVo loginVo,HttpServletRequest httpServletRequest) {
		// 检查用户名和密码是否匹配
		LoginVo loginInfo = privilegeDao.login(loginVo);
		if (loginInfo == null) {
			return "USER_NOT_FOUND";
		}
		if (loginInfo.getStatus() == 2) { // 用户被禁止使用
			return "USER_FOBIDDEN";
		}
		// 获取该用户所属的所有角色
		List<String> roleIds = privilegeDao.findAllRole(String.valueOf(loginInfo.getUserId()));
		// 获取该用户所有能访问的url地址列表
//		List<String> urList = getUrl(loginInfo.getUserId());
		
		Administrator administratorInfo = new Administrator();
//		administratorInfo.setUrl(urList);
//		administratorInfo.setMenus(getMenus(loginInfo.getUserId()));
		administratorInfo.setUserid(loginInfo.getUserId());
		administratorInfo.setUserName(loginInfo.getUserName());
		administratorInfo.setRoleId(roleIds);

		HttpSession session = httpServletRequest.getSession(true);
		session.setAttribute("user", administratorInfo);
		loginInfo.setLogTime(new Date());
		// 不要在对象中存储密码信息
		loginInfo.setPassWord(null);
		return "SUCCESS";
	}
	//获取登陆时状态
	public int getStatus(LoginVo loginVo){
		LoginVo loginInfo = privilegeDao.login(loginVo);
		int status=loginInfo.getStatus();
		return status;
	}


	/*
	@Override
	public ResultHelper getSession(HttpServletRequest httpServletRequest) {
		Administrator administratorInfo = (Administrator)httpServletRequest.getSession().getAttribute("user");
		if(administratorInfo == null){
			return new ResultHelper(Constant.failed_code, PrivilegeConstant.invalid_user);
		}
		administratorInfo.setLoginTime(new Timestamp(System.currentTimeMillis()));
		return new ResultHelper(Constant.success_code, PrivilegeConstant.success, administratorInfo);
	}

	@Override
	public ResultHelper resetPassword(HttpSession session,ResetPassword resetPassword) {
		Administrator administrator = (Administrator)session.getAttribute("user");
		if (administrator==null) {
			return new ResultHelper(Constant.failed_code, PrivilegeConstant.invalid_user);
		}
		LoginVo loginVo=new LoginVo();
		loginVo.setUserName(administrator.getUserName());
		loginVo.setPassWord(resetPassword.getOldPassword());
		LoginVo userinfo=privilegeDao.login(loginVo);
	    if (null == userinfo) {
		return new ResultHelper(Constant.failed_code, PrivilegeConstant.invalid_password);
	    }
	    resetPassword.setId(administrator.getUserid());
	    privilegeDao.resetPassword(resetPassword);
	    session.removeAttribute("user");
	    
		return new ResultHelper(Constant.success_code, PrivilegeConstant.success);
	}*/

}
