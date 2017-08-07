package com.chinasofti.lexian.manager.commodityinfo.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.chinasofti.lexian.manager.category.vo.Category;
import com.chinasofti.lexian.manager.commodityinfo.service.CommodityInfoService;
import com.chinasofti.lexian.manager.commodityinfo.service.CommodityPictureService;
import com.chinasofti.lexian.manager.commodityinfo.service.CommoditySpecService;
import com.chinasofti.lexian.manager.commodityinfo.vo.CommodityInfo;
import com.chinasofti.lexian.manager.commodityinfo.vo.CommodityPicture;
import com.chinasofti.lexian.manager.commodityinfo.vo.CommoditySpec;

@Controller
@RequestMapping("/login")
public class CommodityInfoController {
	// implements ServletConfigAware, ServletContextAware

	// private ServletContext servletContext;
	//
	// private ServletConfig servletConfig;

	private CommodityInfoService commodityInfoService;

	private CommodityPictureService commodityPictureService;

	private CommoditySpecService commoditySpecService;

	// @Override
	// public void setServletContext(ServletContext servletContext) {
	// this.servletContext = servletContext;
	// }
	//
	// @Override
	// public void setServletConfig(ServletConfig servletConfig) {
	// this.servletConfig = servletConfig;
	// }

	@Autowired
	public void setCommodityInfoService(CommodityInfoService commodityInfoService) {
		this.commodityInfoService = commodityInfoService;
	}

	@Autowired
	public void setCommoditySpecService(CommoditySpecService commoditySpecService) {
		this.commoditySpecService = commoditySpecService;
	}

	@Autowired
	public void setCommodityPictureService(CommodityPictureService commodityPictureService) {
		this.commodityPictureService = commodityPictureService;
	}

	@RequestMapping("/commodityList.do")
	public String selectAllCommodityInfo(CommodityInfo commodity, Model model) {
		List<CommodityInfo> commodityList = this.commodityInfoService.selectPageAllCommodity(commodity);

		model.addAttribute("comList", commodityList);
		model.addAttribute("pageBean", commodity);

		return "commodityList";
	}

	@RequestMapping("/likeCommodityList.do")
	public String selectLikeAllCommodityInfo(CommodityInfo commodity, Model model) {
		List<CommodityInfo> commodityList = this.commodityInfoService.selectLikeAllCommodityInfo(commodity);
		model.addAttribute("comList", commodityList);
		model.addAttribute("pageBean", commodity);
		return "commodityList";
	}

	@RequestMapping("/insertCommodityInfo.do")
	public String insertCommodityInfo(Integer type, Model model) {
		List<Category> catList = this.commodityInfoService.selectFirstName(type);
		model.addAttribute("catList", catList);
		return "insertCommodityInfo";
	}

	@RequestMapping(value = "/secondInfo.do", produces = "text/plain;charset=UTF-8")
	@ResponseBody // 告诉springMVC返回的不是一个视图
	public String selectCommodityInfo(String info) {
		int parentId = Integer.parseInt(info);
		List<Category> catList = this.commodityInfoService.selectOtherNameByParentId(parentId);
		String secondName = "";
		for (Category category : catList) {
			secondName = secondName + "#" + category.getId() + ":" + category.getCategoryname();
		}
		secondName = secondName.substring(1, secondName.length());
		return secondName;
	}

	@RequestMapping("/insertCommodity.do")
	public String insertCommodity(CommodityInfo commodity, String firstInfo, String secondInfo, String thirdInfo) {
		String info = thirdInfo != null ? thirdInfo : secondInfo != null ? secondInfo : firstInfo;
		commodity.setCategoryId(Integer.parseInt(info));
		long time = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-DD HH-mm-ss");
		String daTime = sdf.format(time);
		try {
			Date date = sdf.parse(daTime);
			commodity.setCreatetime(date);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int ret = this.commodityInfoService.insertSelective(commodity);
		if (ret > 0)
			return "redirect:commodityList.do";
		return "error";
	}

	@RequestMapping("/selectCommodityInfo.do")
	public String updateCommodity(Integer id, Model model) {
		Category thCate = null;
		Category seCate = null;
		Category fiCate = null;
		List<Category> thList = null;
		List<Category> seList = null;
		CommodityInfo commodity = this.commodityInfoService.selectOneByID(id);
		// 所有第一级
		List<Category> fiList = this.commodityInfoService.selectFirstName(1);

		if (commodity.getCategoryId() != null) {
			// 对应第三级
			thCate = this.commodityInfoService.selectCategoryNameById(commodity.getCategoryId());
			// 对应第二级
			if (thCate.getParentid() != null)
				seCate = this.commodityInfoService.selectCategoryNameById(thCate.getParentid());
			if (seCate != null) {
				// 对应第一集
				if (seCate.getParentid() != null)
					fiCate = this.commodityInfoService.selectCategoryNameById(seCate.getParentid());
				thList = this.commodityInfoService.selectOtherNameByParentId(thCate.getParentid());
				// 查询所有第二级
				seList = this.commodityInfoService.selectOtherNameByParentId(seCate.getParentid());
			}
		}

		// System.out.println(thCate.getCategoryname() +
		// seCate.getCategoryname() + fiCate.getCategoryname());
		// 查询所有第三级

		List<CommoditySpec> specList = this.commoditySpecService
				.selectCommoditySpecByCommodityNo(commodity.getCommodityNo());
		for (CommoditySpec commoditySpec : specList) {
//			System.out.println("标签一共有" + commoditySpec.getSpecGroup() + ":" + commoditySpec.getSpecName());
		}
//		System.out.println("-------------我是华丽的分割线---------------");
		List<CommodityPicture> comList = this.commodityPictureService.selectByCommodityNo(commodity.getCommodityNo());
//		for (CommodityPicture commodityPicture : comList) {
//			System.out.println("图片url是什么呢" + commodityPicture.getPictureUrl());
//		}

		model.addAttribute("comList", comList);
		model.addAttribute("commodity", commodity);
		model.addAttribute("specList", specList);
		model.addAttribute("fiList", fiList);
		model.addAttribute("thCate", thCate);
		model.addAttribute("seCate", seCate);
		model.addAttribute("fiCate", fiCate);
		model.addAttribute("thList", thList);
		model.addAttribute("seList", seList);
		return "commodityInfo";
	}

	// @RequestMapping("/updateCommodityInfo.do")
	// public String updateCommodityInfo(Commodity commodity, String firstInfo,
	// String secondInfo, String thirdInfo,
	// String[] file, String[] kind, HttpServletRequest request,
	// HttpServletResponse response)
	// throws IOException {
	// response.setCharacterEncoding("utf-8");
	// MultipartHttpServletRequest
	// multiRequest=(MultipartHttpServletRequest)request;
	// String name=multiRequest.getParameter("name");
	// SmartUpload smartUpload = new SmartUpload();
	// Request smartRequest=smartUpload.getRequest();
	// String str=smartRequest.getParameter("name");
	// System.out.println("--name--"+name);
	//
	// firstInfo=smartUpload.getRequest().getParameter("firstInfo");
	// String info = thirdInfo != null ? thirdInfo : secondInfo != null ?
	// secondInfo : firstInfo;
	//// commodity.setCategoryId(Integer.parseInt(info));
	//
	// System.out.println("--firstInfo--"+firstInfo);
	// System.out.println("--name--"+commodity.getName());
	// System.out.println("--getIntroduce--"+commodity.getIntroduce());
	// System.out.println("--getStates--"+commodity.getStates());
	// System.out.println("--info--"+info);
	// System.out.println("PIC"+commodity.getPictureurl());

	// System.out.println(file[0]);
	// System.out.println(file[1]);
	// System.out.println(file[2]);

	// for (int i = 0; i < kind.length; i++) {
	// System.out.println(kind[i]);
	// }

	// ServletContext sc = request.getServletContext();
	// String path = sc.getRealPath("/") + "/commodity/";
	//
	// int count=0;
	// try {
	// smartUpload.initialize(this.servletConfig,request, response);
	// smartUpload.setMaxFileSize(1000000);
	// // 上传文件
	// smartUpload.upload();
	// // 将上传文件全部保存到指定目录，需要先在在Web应用的根目录下，创建一个upload目录
	// count = smartUpload.save("d://upload/");
	// System.out.println("共上传"+count+"个文件");
	// }
	// catch (SmartUploadException e) {
	// e.printStackTrace();
	// } catch (ServletException e) {
	// e.printStackTrace();
	// }

	// FileUpload fileUpload=new FileUpload();
	// try {
	// fileUpload.upload(request, response, this.servletConfig);
	// } catch (ServletException e) {
	// e.printStackTrace();
	// }

	// System.out.println(path);
	// return "error";
	// }

	@RequestMapping("/updateCommodityInfo.do")
	public String upload(@RequestParam MultipartFile[] myfiles, HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		List<String> assiFile = new ArrayList<String>();
		String pictureurl = multiRequest.getParameter("pictureurl");
		pictureurl = pictureurl.substring(pictureurl.lastIndexOf("\\") + 1, pictureurl.length());
//		System.out.println("主图片地址为" + pictureurl);
		String urlPath = request.getSession().getServletContext().getRealPath("commodity") + File.separator;
		for (MultipartFile file : myfiles) {
			// 此处MultipartFile[]表明是多文件,如果是单文件MultipartFile就行了
			if (file.isEmpty()) {
				System.out.println("文件未上传!");
			} else {
				// 得到上传的文件名
				String fileName = file.getOriginalFilename();
				if (fileName.indexOf(pictureurl) == -1) {
					assiFile.add(fileName);
				}
				// 得到服务器项目发布运行所在地址

//				System.out.println("path" + urlPath);
				// String path1 ="d://upload/";
				// 此处未使用UUID来生成唯一标识,用日期做为标识
				String path = urlPath + fileName;
				// String path = path1+ new
				// SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+
				// fileName;
				// 查看文件上传路径,方便查找
//				System.out.println("图片的地址是" + path);
				// 把文件上传至path的路径
				File localFile = new File(path);
				file.transferTo(localFile);
			}
		}

		String commodityNo = multiRequest.getParameter("commodityNo");
		String name = multiRequest.getParameter("name");
		String firstInfo = multiRequest.getParameter("firstInfo");
		String secondInfo = multiRequest.getParameter("secondInfo");
		String thirdInfo = multiRequest.getParameter("thirdInfo");
		String info = !"miss".equals(thirdInfo) ? thirdInfo : !"miss".equals(secondInfo) ? secondInfo : firstInfo;
		String introduce = multiRequest.getParameter("introduce");
		String states = multiRequest.getParameter("states");
		if (states == null)
			states = "-1";

		pictureurl = "/commodity/" + pictureurl;

		String detailed = multiRequest.getParameter("detailed");
		CommodityInfo commodity = new CommodityInfo();
		commodity.setCommodityNo(commodityNo);
		commodity.setName(name);
		commodity.setCategoryId(Integer.parseInt(info));
		if (!"/commodity/".equals(pictureurl)) {
			commodity.setPictureurl(pictureurl);
		}
		commodity.setIntroduce(introduce);
		commodity.setStates(Integer.parseInt(states));
		commodity.setDetailed(detailed);
		long time = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-DD HH-mm-ss");
		String daTime = sdf.format(time);
		try {
			Date date = sdf.parse(daTime);
			commodity.setUpdatetime(date);
//			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int no = this.commodityInfoService.updateByPrimaryKeySelective(commodity);
//		System.out.println("成功更新了" + no + "条");
		String[] kindInfo = multiRequest.getParameterValues("kind");
		String[] deleteKind = multiRequest.getParameterValues("deleted");
		int over = 0;
		if (deleteKind != null) {
			for (String string : deleteKind) {
//				System.out.println("------要被删掉的标签有------" + string);
				over += this.commoditySpecService.deleteByPrimaryKey(Integer.parseInt(string));
			}
		}

//		System.out.println("删除了标签" + over);

		String[] deletePicUrl = multiRequest.getParameterValues("deletePicUrl");
		List<String> deletePicUrlPath = new ArrayList<String>();
		int deleteNum = 0;
		if (deletePicUrl != null) {
			for (String string : deletePicUrl) {
				String[] arr = string.split("#");
				deletePicUrlPath.add(arr[1]);
				deleteNum = this.commodityPictureService.deleteByPrimaryKey(Integer.parseInt(arr[0]));
			}
		}
//		System.out.println("共删除了" + deleteNum + "条记录");

		for (String string : deletePicUrlPath) {
//			System.out.println("要被删掉的图片路径" + string);
			string = string.substring(string.lastIndexOf("/"), string.length());
			String urlPathName = urlPath + string;
			boolean ret = (new File(urlPathName)).delete();
//			if (ret) {
//				System.out.println("删除成功！");
//			} else {
//				System.out.println("删除失败");
//			}
		}
		int ret = 0;
		if (kindInfo != null) {
			for (String string : kindInfo) {
				String[] arr = string.split(":");
				CommoditySpec commoditySpec = new CommoditySpec();
				commoditySpec.setCommodityNo(commodityNo);
				commoditySpec.setSpecGroup(arr[0]);
				commoditySpec.setSpecName(arr[1]);
				commoditySpec.setStates(Integer.parseInt(states));
				ret += this.commoditySpecService.insertSelective(commoditySpec);
				// CommoditySpec 的insert方法
//				System.out.println(string);
			}
		}
//		System.out.println("共插入了" + ret + "条");
//		System.out.println(info + introduce + states + pictureurl);
		// filePath
		// String[] filePath=multiRequest.getParameterValues("myfiles");
		int pic = 0;
		for (String string : assiFile) {
//			System.out.println("炫酷的图片地址" + string);
			string = "/commodity/" + string;
			CommodityPicture cp = new CommodityPicture();
			cp.setCommodityNo(commodityNo);
			cp.setPictureUrl(string);
			pic = this.commodityPictureService.insertSelective(cp);
		}
//		System.out.println("共插入了" + pic + "配图");
//		System.out.println(name);
		return "redirect:commodityList.do";
	}

}
