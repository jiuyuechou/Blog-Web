package com.muxui.blog.common.schedule;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.muxui.blog.service.auth.dao.AuthTokenDao;
import com.muxui.blog.service.auth.domain.AuthToken;
import com.muxui.blog.service.log.dao.AuthUserLogDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * @author ou
 */
@Component
@Slf4j
@EnableScheduling //开启定时任务
public class SchedulerTask {

    @Autowired
    private AuthTokenDao authTokenDao;

    @Autowired
    AuthUserLogDao authUserLogDao;

    @Scheduled(cron = "0 0/1 * * * ?")
    private void scanToken() {
        log.debug(" {} 扫描过期Token", LocalDateTime.now());
        authTokenDao.delete(new LambdaQueryWrapper<AuthToken>().le(AuthToken::getExpireTime, LocalDateTime.now()));
    }


    @Scheduled(cron = "0 0 0 ? * 1")
    private void deletelog(){
        authUserLogDao.deletelog();
    }
}
