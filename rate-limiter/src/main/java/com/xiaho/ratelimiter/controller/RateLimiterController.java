package com.xiaho.ratelimiter.controller;

import com.xiaho.ratelimiter.counter.CounterLimiter;
import com.xiaho.ratelimiter.exception.RateLimiterException;
import com.xiaho.ratelimiter.slidingwindow.SlidingTimeWindowLimiter;
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
}
