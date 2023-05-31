package com.xiaho.ratelimiter.limiter.tokenbucket;

import com.xiaho.ratelimiter.limiter.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

/**
 * description: 令牌桶 1、基于当前请求时间计算， 2、基于线程添加
 *
 * @author wanghaoxin
 * @version 1.0
 */
@Slf4j
public class TokenBucketLimiter implements RateLimiter {

    /**
     * 存储的令牌数
     */
    private double storedPermits;

    /**
     * 产生令牌的时间间隔
     */
    private double stableIntervalMicros;

    /**
     * 令牌桶容量
     */
    private int maxPermits;

    /**
     * 可以获取令牌的时间， 用于当请求令牌数超过当前令牌的总数的时候
     */
    private long nextFreeTicketMicros;

    /**
     * 上次获取时间
     */
    private long lastAcquireTime;

    /**
     * 每秒产生的令牌数
     */
    private int permitsPreSecond;

    public TokenBucketLimiter(int permitsPreSecond, int maxPermits) {
        this.permitsPreSecond = permitsPreSecond;
        this.maxPermits = maxPermits;
        this.storedPermits = maxPermits;
        this.lastAcquireTime = fetchNowMicros();
        this.stableIntervalMicros = 1 * 1000 * 1000D / permitsPreSecond;
    }

    @Override
    public boolean acquire() {
        return acquire(1);
    }

    public synchronized boolean acquire(double acquirePermits) {
        final long currentMicros = fetchNowMicros();
        double newProductPermits = (currentMicros - lastAcquireTime) / stableIntervalMicros;

        if (newProductPermits + storedPermits >= maxPermits) {
            storedPermits = maxPermits;
        } else {
            storedPermits += newProductPermits;
        }

        System.out.println(String.format("storedPermits %s, newProductPermits %s ", storedPermits, newProductPermits));

        if (acquirePermits > storedPermits) {
            return false;
        } else {
            lastAcquireTime = currentMicros;
            storedPermits -= acquirePermits;
            return true;
        }
    }

    private long fetchNowMicros() {
        // 获取当前时间
        Instant now = Instant.now();
        // 计算微秒数
        return now.toEpochMilli() * 1000 + now.getNano() / 1000;
    }
}
