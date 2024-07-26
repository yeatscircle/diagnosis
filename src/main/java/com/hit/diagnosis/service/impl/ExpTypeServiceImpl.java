package com.hit.diagnosis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hit.diagnosis.domain.ExpType;
import com.hit.diagnosis.service.ExpTypeService;
import com.hit.diagnosis.mapper.ExpTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author SN
* @description 针对表【exp_type(收费类别表)】的数据库操作Service实现
* @createDate 2024-07-24 10:42:24
*/
@Service
public class ExpTypeServiceImpl extends ServiceImpl<ExpTypeMapper, ExpType>
    implements ExpTypeService{

}




