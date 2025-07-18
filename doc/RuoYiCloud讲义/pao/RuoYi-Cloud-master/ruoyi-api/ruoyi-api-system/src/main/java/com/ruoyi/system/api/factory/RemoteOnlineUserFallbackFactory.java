package com.ruoyi.system.api.factory;

import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.system.api.RemoteOnlineUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;

public class RemoteOnlineUserFallbackFactory implements FallbackFactory<RemoteOnlineUserService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteOnlineUserFallbackFactory.class);

    @Override
    public RemoteOnlineUserService create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteOnlineUserService() {
            @Override
            public TableDataInfo getOnlineUserList(String token) {
                TableDataInfo info = new TableDataInfo();
                info.setMsg("获取在线用户列表失败：" + throwable.getMessage());
                return info;
            }
        };
    }
}
