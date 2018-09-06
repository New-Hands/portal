package com.lstfight.portal.controller;

import com.lstfight.portal.model.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Iterator;


/**
 * <p>文件处理接口</p>
 *
 *
 * @author 李尚庭
 * @date 2018/8/14 0014 17:20
 */
@Controller
public class FileController {

    /**
     * <p>文件上传处理 需要ApacheCommons支持</p>
     * <p>方法一：使用NIO方式</p>
     * <p>方法二：multipartFile的transferTo方法 </p>
     *
     * @param multipartFile 上传文件
     */
    
    public void uploadAccess(MultipartFile multipartFile) throws IOException {
        //multipartFile

        InputStream in = multipartFile.getInputStream();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(""));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public ResultBean springUpload(HttpServletRequest request) {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (request.getSession().getServletContext() == request.getServletContext()) {
            System.out.println("xiangtong context");
        }
        if (multipartResolver.isMultipart(request)) {
            MultipartRequest multipartRequest = (MultipartRequest) request;

            Iterator<String> iterator = multipartRequest.getFileNames();
            while (iterator.hasNext()) {

               MultipartFile multipartFile = multipartRequest.getFile(iterator.next());
            }

        }
        return ResultBean.defaultSuccessResult();
    }


}
