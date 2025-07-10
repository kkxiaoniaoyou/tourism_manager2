package com.rabbiter.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbiter.tourism.domain.SysHotelOrder;
import com.rabbiter.tourism.mapper.SysHotelOrderMapper;
import com.rabbiter.tourism.service.SysHotelOrderService;
import org.springframework.stereotype.Service;

@Service
public class SysHotelOrderServiceImpl extends ServiceImpl<SysHotelOrderMapper, SysHotelOrder> implements SysHotelOrderService {
}
