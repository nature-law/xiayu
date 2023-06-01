package com.xiaho.ratelimiter.limiter.leakybucket;

import com.xiaho.ratelimiter.limiter.RateLimiter;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description: 漏桶算法
 *
 * @author wanghaoxin
 * @version 1.0
 */
public class LeakyBucketLimiter implements RateLimiter {

    private int maxPermits;

    private int water;

    private int qps;


    public LeakyBucketLimiter(int maxPermits, int qps) {
        this.maxPermits = maxPermits;
        this.qps = qps;

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.scheduleAtFixedRate(() -> {
            water -= qps;
            if (water < 0) {
                water = 0;
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);

    }

    @Override
    public synchronized boolean acquire() {
        if (water + 1 > maxPermits) {
            return false;
        } else {
            water++;
        }
        return true;
    }
}
