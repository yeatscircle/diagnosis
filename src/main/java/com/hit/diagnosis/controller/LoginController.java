package com.hit.diagnosis.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hit.diagnosis.common.JwtUtils;
import com.hit.diagnosis.common.Result;
import com.hit.diagnosis.domain.User;
import com.hit.diagnosis.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
    final private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        if (userService.save(user))
            return Result.success();
        return Result.error("注册失败");
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        //对密码进行md5加密
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //查询数据库
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User u = userService.getOne(wrapper);

        log.info("user:{}", u);
        //显示查询结果
        if (u == null)
            return Result.error("用户不存在");

        //对比密码
        if (!u.getPassword().equals(password))
            return Result.error("密码错误");

        //登录成功
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", u.getId());
        claims.put("username", u.getUsername());
        String jwt = JwtUtils.generateJwt(claims);
        return Result.success(jwt);
    }
}
