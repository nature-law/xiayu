package com.xiaho.ratelimiter.limiter;

/**
 * description: 漏桶算法
 *
 * @author wanghaoxin
 * @version 1.0
 */
public class LeakyBucketLimiter implements RateLimiter {

    private int maxPermits;

    private int water;

    public LeakyBucketLimiter(int maxPermits, int water) {
        this.maxPermits = maxPermits;
        this.water = water;
    }

    @Override
    public synchronized boolean acquire() {
        if ()

        return false;
    }
}
