package com.rabbiter.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbiter.tourism.domain.SysFavor;
import com.rabbiter.tourism.mapper.SysFavorMapper;
import com.rabbiter.tourism.service.SysFavorService;
import org.springframework.stereotype.Service;

@Service
public class SysFavorServiceImpl extends ServiceImpl<SysFavorMapper, SysFavor> implements SysFavorService {
}
