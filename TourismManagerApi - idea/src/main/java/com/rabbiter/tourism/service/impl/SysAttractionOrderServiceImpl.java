package com.rabbiter.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbiter.tourism.domain.SysAttractionOrder;
import com.rabbiter.tourism.mapper.SysAttractionOrderMapper;
import com.rabbiter.tourism.service.SysAttractionOrderService;
import org.springframework.stereotype.Service;

@Service
public class SysAttractionOrderServiceImpl extends ServiceImpl<SysAttractionOrderMapper, SysAttractionOrder> implements SysAttractionOrderService {
}
