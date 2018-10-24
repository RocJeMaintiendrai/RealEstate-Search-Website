package com.imooc.web.controller.admin;

import com.imooc.base.APIResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@Controller
public class AdminController {

    @GetMapping("/admin/center")
    public String adminCenterPage() {
        return "admin/center";
    }

    @GetMapping("/admin/welcome")
    public String welcomePage() {
        return "admin/welcome";
    }

    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "admin/login";
    }

    @GetMapping("/admin/add/house")
    public String addHousePage() {
        return "admin/house-add";
    }

    @PostMapping(value = "admin/upload/photo", consumes = PageAttributes.MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public APIResponse uploadPhoto(@RequestParam('file') MultipartFile file) {
        if(file.isEmpty()) {
            return APIResponse.ofStatus(APIResponse.NOT_VALID_PARAM);
        }
        String fileName = file.getOriginalFilename();
        File target = new File("/Users/guopeng/Desktop/xunwu-project/tmp" + fileName);
        try{
            file.transferTo(target);
        } catch (IOException e){
            e.printStackTrace();
            return APIResponse.ofStatus(APIResponse.ofStatus().INTERNAl)
        }

    }


}
