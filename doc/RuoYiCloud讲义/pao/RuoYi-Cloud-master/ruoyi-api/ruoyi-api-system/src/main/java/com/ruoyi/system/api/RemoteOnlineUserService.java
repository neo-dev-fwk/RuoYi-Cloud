package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.system.api.factory.RemoteOnlineUserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(contextId = "remoteOnlineUserService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteOnlineUserFallbackFactory.class)
public interface RemoteOnlineUserService {

    @GetMapping("/online/list")
    public TableDataInfo getOnlineUserList(@RequestHeader(SecurityConstants.TOKEN) String token);


}
