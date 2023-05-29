package com.xiaho.ratelimiter.counter;

import com.xiaho.ratelimiter.limiter.RateLimiter;

import java.time.Instant;

/**
 * description: 计数器限流器(固定窗口算法)
 *
 * @author wanghaoxin
 * date     2023/5/29 15:14
 * @version 1.0
 */
public class CounterLimiter implements RateLimiter {

    private int qps;

    private int count = 0;

    private static final int TIME_WINDOW = 1000;

    private long lastTime = 0;

    public CounterLimiter(int qps) {
        this.qps = qps;
    }

    @Override
    public synchronized boolean acquire() {
        final long now = Instant.now().toEpochMilli();
        if (now - lastTime > TIME_WINDOW) {
            this.count = 0;
        }

        this.count++;
        if (this.count > qps) {
            return false;
        }
        this.lastTime = Instant.now().toEpochMilli();
        return true;
    }
}
