package com.xiaho.ratelimiter.controller;

import com.xiaho.ratelimiter.exception.RateLimiterException;
import com.xiaho.ratelimiter.limiter.counter.CounterLimiter;
import com.xiaho.ratelimiter.limiter.slidinglog.SlidingLogLimiter;
import com.xiaho.ratelimiter.limiter.slidingwindow.SlidingTimeWindowLimiter;
import com.xiaho.ratelimiter.limiter.tokenbucket.TokenBucketLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author wanghaoxin
 * date     2023/5/29 16:02
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/rate-limiter")
public class RateLimiterController {

    private CounterLimiter counterLimiter = new CounterLimiter(2);

    private SlidingTimeWindowLimiter slidingTimeWindowLimiter = new SlidingTimeWindowLimiter(10);

    private SlidingLogLimiter slidingLogLimiter = new SlidingLogLimiter();

    private TokenBucketLimiter tokenBucketLimiter = new TokenBucketLimiter(1, 10);

    @GetMapping(value = "/counter")
    public String counter() {
        if (counterLimiter.acquire()) {
            return "counter";
        } else {
            return "limiter";
        }
    }

    @GetMapping(value = "/slidingTimeWindow")
    public String slidingTimeWindow() {
        if (slidingTimeWindowLimiter.acquire()) {
            return "slidingTimeWindow";
        } else {
            throw new RateLimiterException("limiter");
        }
    }

    @GetMapping(value = "/slidingLogLimiter")
    public String slidingLogLimiter() {
        if (slidingLogLimiter.acquire()) {
            return "slidingLogLimiter";
        } else {
            throw new RateLimiterException("limiter");
        }
    }

    @GetMapping(value = "/tokenBucketLimiter")
    public String tokenBucketLimiter() {
        if (tokenBucketLimiter.acquire(1)) {
            return "tokenBucketLimiter";
        } else {
            throw new RateLimiterException("limiter");
        }
    }
}
