package com.rabbiter.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbiter.tourism.domain.SysComments;
import com.rabbiter.tourism.mapper.SysCommentsMapper;
import com.rabbiter.tourism.service.SysCommentsService;
import org.springframework.stereotype.Service;

@Service
public class SysCommentsServiceImpl extends ServiceImpl<SysCommentsMapper, SysComments> implements SysCommentsService {
}
