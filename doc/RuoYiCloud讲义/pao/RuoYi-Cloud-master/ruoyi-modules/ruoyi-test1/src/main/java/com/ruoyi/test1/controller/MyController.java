package com.ruoyi.test1.controller;

import com.ruoyi.common.core.context.SecurityContextHolder;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.system.api.RemoteOnlineUserService;
import com.ruoyi.system.api.RemoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private RemoteUserService remoteUserService;

    @GetMapping("/getUserList")
    public void test() {
        TableDataInfo userList = remoteUserService.getUserList(SecurityContextHolder.getUserId(),
                SecurityContextHolder.getUserName(),
                SecurityContextHolder.getUserKey(),
                SecurityContextHolder.getToken());

        List<LinkedHashMap<String, Object>> rows = (List<LinkedHashMap<String, Object>>) userList.getRows();
        for (LinkedHashMap<String, Object> row : rows) {
            System.out.println("row = " + row);
        }

    }


    @Autowired
    private RemoteOnlineUserService remoteOnlineUserService;

    @GetMapping("/getOnlineUserList")
    public void test1() {
        TableDataInfo onlineUserList = remoteOnlineUserService.getOnlineUserList(SecurityContextHolder.getToken());
        List<LinkedHashMap<String, Object>> rows = (List<LinkedHashMap<String, Object>>) onlineUserList.getRows();
        for (LinkedHashMap<String, Object> row : rows) {
            System.out.println("row = " + row);
        }

    }

}
