package com.cxzcanying.winterproject.controller;


import com.cxzcanying.winterproject.pojo.AliOSSUtils;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;
    @Autowired
    private UserService userService;

    @PostMapping("/api/users/{userId}/avatar")
    public Result<String> uploadAvatar(MultipartFile image , @PathVariable String userId) throws IOException {
        log.info("ID为{}的用户上传,文件名:{}",userId,image.getOriginalFilename());
        //调用阿里云OSS工具类，将上传上来的文件存入阿里云
        String avatarUrl = aliOSSUtils.upload(image);
        //将图片上传完成后的url返回，用于浏览器回显展示
        userService.updateAvatarUrl(userId,avatarUrl);
        return Result.success(avatarUrl);
    }

}