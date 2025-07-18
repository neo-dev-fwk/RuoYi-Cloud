package com.ruoyi.system.controller;

import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/test")
public class SysTestController extends BaseController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/cache/{name}")
    public TableDataInfo cache(@PathVariable("name") String name) {
        Collection<String> keys = redisService.keys(name + "*");
        ArrayList<String> list = new ArrayList<>(keys);
        return getDataTable(list);
    }

    @GetMapping("/cache/key/{name}")
    public AjaxResult cacheValue(@PathVariable("name") String name) {
        return success(redisService.getCacheObject(name).toString());
    }


}
