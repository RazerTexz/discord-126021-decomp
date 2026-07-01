package org.webrtc;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadUtils$2 implements ThreadUtils$BlockingOperation {
    public final /* synthetic */ CountDownLatch val$latch;

    public ThreadUtils$2(CountDownLatch countDownLatch) {
        this.val$latch = countDownLatch;
    }

    @Override // org.webrtc.ThreadUtils$BlockingOperation
    public void run() throws InterruptedException {
        this.val$latch.await();
    }
}
