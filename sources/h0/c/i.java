package h0.c;

import org.webrtc.EglRenderer;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ EglRenderer j;

    public /* synthetic */ i(EglRenderer eglRenderer) {
        this.j = eglRenderer;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        EglRenderer.c(this.j);
    }
}
