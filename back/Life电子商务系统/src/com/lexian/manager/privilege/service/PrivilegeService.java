package com.chinasofti.lexian.manager.privilege.service;

import javax.servlet.http.HttpServletRequest;

import com.chinasofti.lexian.manager.privilege.vo.LoginVo;

public interface PrivilegeService {
	
	public String login(LoginVo loginVo,HttpServletRequest httpServletRequest);
	
	public int getStatus(LoginVo loginVo);
/*	
	public ResultHelper getSession(HttpServletRequest httpServletRequest);
    
	public ResultHelper resetPassword(HttpSession session,ResetPassword resetPassword);*/
}
