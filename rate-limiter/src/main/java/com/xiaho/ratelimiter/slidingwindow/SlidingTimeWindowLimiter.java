package com.xiaho.ratelimiter.slidingwindow;

import com.xiaho.ratelimiter.limiter.RateLimiter;
import lombok.Data;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description: 滑动时间窗口
 *
 * @author wanghaoxin
 * date     2023/5/29 16:55
 * @version 1.0
 */
public class SlidingTimeWindowLimiter implements RateLimiter {

    private int qp10s;

    /**
     * 时间窗口 毫秒
     */
    private static final int TIME_WINDOW_SIZE = 1000;
    public static final int NUM_ELEMENTS = 10000 / TIME_WINDOW_SIZE;

    private int count = 0;

    private ArrayDeque<TimeGridInfo> timeGrids = new ArrayDeque<>(NUM_ELEMENTS);

    public SlidingTimeWindowLimiter(int qps) {
        this.qp10s = qps;
        for (TimeGridInfo timeGrid : timeGrids) {
            timeGrid.setTimeCount(0);
        }

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.scheduleAtFixedRate(() -> {

            if (timeGrids.size() <= NUM_ELEMENTS) {
                TimeGridInfo rightTimeGrid = new TimeGridInfo();
                long now = Instant.now().toEpochMilli();
                rightTimeGrid.setLastTime(now);
                rightTimeGrid.setTimeCount(0);
                timeGrids.offer(rightTimeGrid);
            }

            if (timeGrids.size() > NUM_ELEMENTS) {
                TimeGridInfo timeGridInfo = timeGrids.poll();
                if (timeGridInfo != null) {
                    final int timeCount = timeGridInfo.getTimeCount();
                    System.out.println(timeCount);
                    count -= timeGridInfo.getTimeCount();
                }
            }
        }, 0, TIME_WINDOW_SIZE, TimeUnit.MILLISECONDS);
    }

    @Override
    public synchronized boolean acquire() {
        TimeGridInfo rightGrid = timeGrids.peek();
        if (rightGrid != null) {
            final long now = Instant.now().toEpochMilli();
            if ((now - rightGrid.lastTime) < TIME_WINDOW_SIZE) {
                rightGrid.setTimeCount(rightGrid.getTimeCount() + 1);
                rightGrid.setLastTime(now);
            }
        }

        this.count++;
        System.out.println(count);
        boolean isAcquire = count <= qp10s;
        System.out.println(isAcquire);
        return isAcquire;
    }

    @Data
    private static class TimeGridInfo {
        private int timeCount;

        private long lastTime;
    }
}
