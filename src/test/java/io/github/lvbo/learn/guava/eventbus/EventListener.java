package io.github.lvbo.learn.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Created by lvbo on 16/2/12.
 */
public class EventListener {
    private int msg;

    @Subscribe
    public void listener(TestEvent testEvent) {
        msg = testEvent.getMessage();
    }
    public String getLastMessage() {
        return msg + "";
    }
}
