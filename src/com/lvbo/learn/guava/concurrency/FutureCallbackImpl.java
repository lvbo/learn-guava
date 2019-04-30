package com.lvbo.guavatest.concurrency;

import com.google.common.util.concurrent.FutureCallback;

/**
 * Created by lvbo on 16/2/12.
 */
public class FutureCallbackImpl implements FutureCallback<String> {
    private StringBuilder builder = new StringBuilder();

    @Override
    public void onSuccess(String result) {
        builder.append(result).append(" successfully");
    }

    @Override
    public void onFailure(Throwable t) {
        builder.append(t.toString());
    }

    public String getCallbackResult() {
        return builder.toString();
    }
}
