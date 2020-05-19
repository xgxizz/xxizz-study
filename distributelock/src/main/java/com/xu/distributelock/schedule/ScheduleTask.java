package com.xu.distributelock.schedule;

import com.xu.distributelock.DistributedLock;
import com.xu.distributelock.redis.RedisDistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@Slf4j
public class ScheduleTask {

    @Resource
    private RedisTemplate redisTemplate;
    //添加定时任务
    @Scheduled(cron = "0 40 15 ? * *")//每天指定时间触发  cron格式参考链接：https://www.cnblogs.com/softidea/p/5833248.html
    private void configureTasks() throws UnknownHostException {

        DistributedLock distributedLock = new RedisDistributedLock(redisTemplate);
        distributedLock.lock("mylock", 30000, 3, 2000);
        InetAddress ip4 = Inet4Address.getLocalHost();
        System.out.println(ip4.getHostAddress());
        log.info("执行静态定时任务时间: " + LocalDateTime.now() + "\n任务名称：定时检测用户证书申请信息是否超时");
        distributedLock.releaseLock("mylock");

    }
}
