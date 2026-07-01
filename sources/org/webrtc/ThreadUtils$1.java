package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadUtils$1 implements ThreadUtils$BlockingOperation {
    public final /* synthetic */ Thread val$thread;

    public ThreadUtils$1(Thread thread) {
        this.val$thread = thread;
    }

    @Override // org.webrtc.ThreadUtils$BlockingOperation
    public void run() throws InterruptedException {
        this.val$thread.join();
    }
}
