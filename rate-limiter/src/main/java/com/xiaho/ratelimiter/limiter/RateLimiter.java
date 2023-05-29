package com.xiaho.ratelimiter.limiter;

/**
 * description
 *
 * @author wanghaoxin
 * date     2023/5/29 14:58
 * @version 1.0
 */
public interface RateLimiter {
    boolean acquire();
}
