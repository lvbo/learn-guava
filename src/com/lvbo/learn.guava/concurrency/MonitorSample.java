package com.lvbo.guavatest.concurrency;

import com.google.common.util.concurrent.Monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvbo on 16/2/11.
 */
public class MonitorSample {
    private List<String> list = new ArrayList<String>();
    private static final int MAX_SIZE = 10;
    private Monitor monitor = new Monitor();
    private Monitor.Guard listBelowCapacity = new
            Monitor.Guard(monitor) {
                @Override
                public boolean isSatisfied() {
                    return list.size() < MAX_SIZE;
                }
            };

    public void addToList(String item) throws InterruptedException {
        if (monitor.tryEnterIf(listBelowCapacity)) {
            try {
                list.add(item);
            } finally {
                monitor.leave();
            }
        }
    }
}
