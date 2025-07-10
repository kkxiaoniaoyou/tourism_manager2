package com.rabbiter.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbiter.tourism.domain.SysForum;
import com.rabbiter.tourism.mapper.SysForumMapper;
import com.rabbiter.tourism.service.SysForumService;
import org.springframework.stereotype.Service;

@Service
public class SysForumServiceImpl extends ServiceImpl<SysForumMapper, SysForum> implements SysForumService {
}
