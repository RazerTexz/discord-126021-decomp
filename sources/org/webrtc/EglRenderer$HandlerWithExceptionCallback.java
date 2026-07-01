package org.webrtc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public class EglRenderer$HandlerWithExceptionCallback extends Handler {
    private final Runnable exceptionCallback;

    public EglRenderer$HandlerWithExceptionCallback(Looper looper, Runnable runnable) {
        super(looper);
        this.exceptionCallback = runnable;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) throws Exception {
        try {
            super.dispatchMessage(message);
        } catch (Exception e) {
            Logging.e("EglRenderer", "Exception on EglRenderer thread", e);
            this.exceptionCallback.run();
            throw e;
        }
    }
}
