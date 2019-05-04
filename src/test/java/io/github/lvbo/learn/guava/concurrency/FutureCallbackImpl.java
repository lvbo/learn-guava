package io.github.lvbo.learn.guava.concurrency;

import com.google.common.util.concurrent.FutureCallback;

public class FutureCallbackImpl implements FutureCallback<String> {
    private StringBuilder builder = new StringBuilder();

    public void onSuccess(String result) {
        builder.append(result).append(" successfully");
    }

    public void onFailure(Throwable t) {
        builder.append(t.toString());
    }

    public String getCallbackResult() {
        return builder.toString();
    }
}
