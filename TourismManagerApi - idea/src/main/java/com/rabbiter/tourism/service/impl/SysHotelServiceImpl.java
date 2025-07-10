package com.rabbiter.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbiter.tourism.domain.SysHotel;
import com.rabbiter.tourism.mapper.SysHotelMapper;
import com.rabbiter.tourism.service.SysHotelService;
import org.springframework.stereotype.Service;

@Service
public class SysHotelServiceImpl extends ServiceImpl<SysHotelMapper, SysHotel> implements SysHotelService {
}
