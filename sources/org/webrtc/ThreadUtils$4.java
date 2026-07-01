package org.webrtc;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadUtils$4 implements Callable<Void> {
    public final /* synthetic */ Runnable val$runner;

    public ThreadUtils$4(Runnable runnable) {
        this.val$runner = runnable;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() throws Exception {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        this.val$runner.run();
        return null;
    }
}
