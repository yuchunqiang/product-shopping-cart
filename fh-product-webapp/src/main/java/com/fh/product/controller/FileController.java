package com.fh.product.controller;

import com.fh.product.aop.LogAnnotation;
import com.fh.product.util.FtpUploadFile;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
@RequestMapping("FileController")
public class FileController {
    @RequestMapping("uploadFile")
    @ResponseBody
    @LogAnnotation(methodInfo="图片上传到ftp")
    public Map uploadFile(@RequestParam(value="productPhotoInput", required=false) MultipartFile imgphoto){
        if (StringUtils.isNotBlank(imgphoto.getOriginalFilename())) {
            return 	FtpUploadFile.uploadFile("/product/image", imgphoto);
        }
        return null;
    }
}

