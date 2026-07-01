package h0.c;

import org.webrtc.EglRenderer;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ EglRenderer j;
    public final /* synthetic */ Runnable k;

    public /* synthetic */ e(EglRenderer eglRenderer, Runnable runnable) {
        this.j = eglRenderer;
        this.k = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.g(this.k);
    }
}
