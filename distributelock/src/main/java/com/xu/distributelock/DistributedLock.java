package com.xu.distributelock;

public interface DistributedLock {
    long TIMEOUT_MILLIS = 30000;    
    int RETRY_TIMES = Integer.MAX_VALUE;    
    long SLEEP_MILLIS = 500;
    Long SUCCESS = 1L;
    boolean lock(String key);
    boolean lock(String key, int retryTimes);
    boolean lock(String key, int retryTimes, long sleepMillis);
    boolean lock(String key, long expire);
    boolean lock(String key, long expire, int retryTimes);
    boolean lock(String key, long expire, int retryTimes, long sleepMillis);
    boolean releaseLock(String key);
}