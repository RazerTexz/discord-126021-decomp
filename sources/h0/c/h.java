package h0.c;

import java.util.concurrent.CountDownLatch;
import org.webrtc.EglRenderer;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ EglRenderer j;
    public final /* synthetic */ CountDownLatch k;

    public /* synthetic */ h(EglRenderer eglRenderer, CountDownLatch countDownLatch) {
        this.j = eglRenderer;
        this.k = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.e(this.k);
    }
}
