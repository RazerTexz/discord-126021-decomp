package org.webrtc;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadUtils$ThreadChecker {

    @Nullable
    private Thread thread = Thread.currentThread();

    public void checkIsOnValidThread() {
        if (this.thread == null) {
            this.thread = Thread.currentThread();
        }
        if (Thread.currentThread() != this.thread) {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public void detachThread() {
        this.thread = null;
    }
}
