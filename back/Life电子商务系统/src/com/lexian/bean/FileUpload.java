package com.chinasofti.lexian.bean;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
public class FileUpload {
	/** 
     * 文件上传. 
     * @param request 
     * @param response 
     * @return 
     * @throws ServletException 
     * @throws IOException 
     */  
    public String upload(HttpServletRequest request, HttpServletResponse response,ServletConfig config) throws ServletException, IOException {  
          
        request.setCharacterEncoding("utf-8");  
        //新建一个SmartUpload对象  
        SmartUpload mySmartUpload=new SmartUpload();  
        String fileId = "";  
        try{  
            //上传初始化  
            mySmartUpload.initialize(config, request, response);  
            //设定每个上传文件的最大长度  
            mySmartUpload.setMaxFileSize(1*512*1024);  
            //设定总上传数据的长度  
            mySmartUpload.setTotalMaxFileSize(1*1024*1024);  
            //设定允许上传的文件的类型,只允许上传java,doc,txt文件  
            mySmartUpload.setAllowedFilesList("png,jpg");  
            //设定禁止上传的文件的类型,禁止上传带有exe,bat文件  
            mySmartUpload.setDeniedFilesList("exe,bat");  
            //上传文件  
            mySmartUpload.upload();  
              
            //处理每个上传文件  
            for(int i=0;i<mySmartUpload.getFiles().getCount();i++)  
            {  
                File file=mySmartUpload.getFiles().getFile(i); 
                //判断用户是否选择了文件  
                if(!file.isMissing()){  
                    //另存到以Web应用程序的根目录为文件根目录的目录下  
                    //(声明一下：在Myeclipse中，该目录位于工程下的.metadata/.me_tcat/webapps/该工程目录/upload/)  
                    //生成唯一的文件索引(日期+两个随机数)  
                    String fileName =file.getFileName();  
                    String data[] = fileName.split("\\.");  
                    System.out.println(data.length);  
                    String fileType = data[1];   //文件类型  
                    System.out.println(fileType);  
                    Date now = new Date();  
                    DateFormat YMD = new SimpleDateFormat("yyyyMMdd");//年-月-日  
                    String ymd = YMD.format(now);//当前年-月-日  
                    Random random = new Random();  
                    int r1 = random.nextInt(99999);  
                    int r2 = random.nextInt(99999);  
                    fileId = ymd+r1+""+r2;  
                    System.out.println(fileId);  
//                    file.saveAs("/upload/"+fileId+"."+fileType,mySmartUpload.SAVE_VIRTUAL);
                    file.saveAs("d://upload/");
                    
                }  
            }  
        }catch(Exception e){//异常处理  
            //打印自定义异常信息  
        }  
        return fileId;  
    }  
      
      
}  

