package org.webrtc;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadUtils$3 implements Runnable {
    public final /* synthetic */ CountDownLatch val$barrier;
    public final /* synthetic */ Callable val$callable;
    public final /* synthetic */ ThreadUtils$1CaughtException val$caughtException;
    public final /* synthetic */ ThreadUtils$1Result val$result;

    public ThreadUtils$3(ThreadUtils$1Result threadUtils$1Result, Callable callable, ThreadUtils$1CaughtException threadUtils$1CaughtException, CountDownLatch countDownLatch) {
        this.val$result = threadUtils$1Result;
        this.val$callable = callable;
        this.val$caughtException = threadUtils$1CaughtException;
        this.val$barrier = countDownLatch;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [V, java.lang.Object] */
    @Override // java.lang.Runnable
    public void run() {
        try {
            this.val$result.value = this.val$callable.call();
        } catch (Exception e) {
            this.val$caughtException.e = e;
        }
        this.val$barrier.countDown();
    }
}
