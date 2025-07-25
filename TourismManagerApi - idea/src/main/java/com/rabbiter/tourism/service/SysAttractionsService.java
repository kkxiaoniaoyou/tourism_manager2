package com.rabbiter.tourism.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rabbiter.tourism.domain.SysAttractions;

import java.util.List;

public interface SysAttractionsService extends IService<SysAttractions> {

    /**
     * 获取推荐景点
     *
     * @param userId 用户id
     * @return 景点列表
     */
    List<SysAttractions> searchAttractions(String userId);

}
