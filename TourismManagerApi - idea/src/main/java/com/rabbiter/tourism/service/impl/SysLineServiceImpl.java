package com.rabbiter.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbiter.tourism.domain.SysLine;
import com.rabbiter.tourism.mapper.SysLineMapper;
import com.rabbiter.tourism.service.SysLineService;
import org.springframework.stereotype.Service;

@Service
public class SysLineServiceImpl extends ServiceImpl<SysLineMapper, SysLine> implements SysLineService {
}
