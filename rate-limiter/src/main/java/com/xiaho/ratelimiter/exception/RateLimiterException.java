package com.xiaho.ratelimiter.exception;

/**
 * description:
 *
 * @author wanghaoxin
 * date     2023/5/29 15:39
 * @version 1.0
 */
public class RateLimiterException extends RuntimeException {
    public RateLimiterException(String message) {
        super(message);
    }
}
