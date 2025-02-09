package com.cxzcanying.winterproject.controller;



import com.cxzcanying.winterproject.pojo.AliOSSUtils;
import com.cxzcanying.winterproject.pojo.JwtUtil;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 21311
 */
@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/api/users/{userId}/avatar")
    public Result<String> uploadAvatar(MultipartFile image, @PathVariable String userId) {
        try {
            log.info("ID为{}的用户上传,文件名:{}", userId, image.getOriginalFilename());
            String avatarUrl = aliOSSUtils.upload(image);
            userService.updateAvatarUrl(userId, avatarUrl);
            return Result.success(avatarUrl);
        } catch (Exception e) {
            log.error("上传头像失败", e);
            return Result.fail("上传头像失败: " + e.getMessage());
        }
    }

}