package com.hit.diagnosis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hit.diagnosis.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{
}
