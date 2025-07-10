package com.rabbiter.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbiter.tourism.domain.SysRotations;
import com.rabbiter.tourism.mapper.SysRotationsMapper;
import com.rabbiter.tourism.service.SysRotationsService;
import org.springframework.stereotype.Service;

@Service
public class SysRotationsServiceImpl extends ServiceImpl<SysRotationsMapper, SysRotations> implements SysRotationsService {
}
