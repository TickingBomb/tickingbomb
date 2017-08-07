package com.chinasofti.lexian.manager.privilege.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.lexian.manager.privilege.service.PrivilegeService;
import com.chinasofti.lexian.manager.privilege.vo.LoginVo;

@Controller
@RequestMapping("/login")
public class PrivilegeController{
	private PrivilegeService privilegeService;
	
	@Autowired
	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	// 用户登录
	@RequestMapping("/login.do")
	public String login(LoginVo loginVo, HttpServletRequest httpServletRequest,Model model) {
		if (!"SUCCESS".equals(privilegeService.login(loginVo,httpServletRequest))) {
			int status=privilegeService.getStatus(loginVo);
			System.out.println(status);
			model.addAttribute("status", status);
			return "login";
		}
		return "home";
	}
	
	
	/*//用户注销
	@RequestMapping("/logout.do")
	@ResponseBody
	public ResultHelper logout(HttpSession session) {
		session.removeAttribute("user");
		return new ResultHelper(Constant.success_code, PrivilegeConstant.success);
	}
    
	// 查询用户操作日志记录
	@RequestMapping("/readUserLog.do")
	@ResponseBody
	public ResultHelper readUserLog(UserLogVo userLogVo) {
		try {
			ParamValidateUtil.validateNull(userLogVo, PrivilegeConstant.invalid_arguments);
		} catch (ParamNotValidException e) {
			return new ResultHelper(Constant.failed_code, e.getMessage());
		}
		return privilegeService.readUserLog(userLogVo);
	}
	
	@RequestMapping("/resetPassword.do")
	@ResponseBody
    public ResultHelper resetPassword(HttpSession session,@ModelAttribute ResetPassword resetPassword){
    	try {
    		ParamValidateUtil.validateEmpty(resetPassword.getOldPassword(), PrivilegeConstant.invalid_arguments);
			ParamValidateUtil.validateEmpty(resetPassword.getNewPassword(), PrivilegeConstant.invalid_arguments);
    	} catch (ParamNotValidException e) {
            return new ResultHelper(Constant.failed_code,e.getMessage());
		}
		return privilegeService.resetPassword(session, resetPassword);
    }
	


	@RequestMapping("/getLogs.do")
	@ResponseBody
	public ResultHelper getLogs(LogPo logPo){
		return privilegeService.getLogs(logPo);
	}
	
	@RequestMapping("/getSession.do")
	@ResponseBody
	public ResultHelper getSession(HttpServletRequest httpServletRequest){
		return privilegeService.getSession(httpServletRequest);
	}*/
	
}
