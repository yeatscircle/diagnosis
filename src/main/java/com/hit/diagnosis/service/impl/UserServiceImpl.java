package com.hit.diagnosis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hit.diagnosis.domain.User;
import com.hit.diagnosis.mapper.UserMapper;
import com.hit.diagnosis.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
