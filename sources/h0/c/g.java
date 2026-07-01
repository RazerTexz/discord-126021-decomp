package h0.c;

import java.util.concurrent.CountDownLatch;
import org.webrtc.EglRenderer;
import org.webrtc.EglRenderer$FrameListener;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ EglRenderer j;
    public final /* synthetic */ CountDownLatch k;
    public final /* synthetic */ EglRenderer$FrameListener l;

    public /* synthetic */ g(EglRenderer eglRenderer, CountDownLatch countDownLatch, EglRenderer$FrameListener eglRenderer$FrameListener) {
        this.j = eglRenderer;
        this.k = countDownLatch;
        this.l = eglRenderer$FrameListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.h(this.k, this.l);
    }
}
