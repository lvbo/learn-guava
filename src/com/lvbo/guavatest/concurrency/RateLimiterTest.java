package com.lvbo.guavatest.concurrency;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * Created by lvbo on 16/2/12.
 */
public class RateLimiterTest {

    @Test
    public void test() {
        RateLimiter rl = RateLimiter.create(4.0);
        if (rl.tryAcquire()) {
            //do something
        } else {
            //do something else
        }
    }
}
