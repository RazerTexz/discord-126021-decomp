package h0.c;

import org.webrtc.EglBase$Context;
import org.webrtc.EglRenderer;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ EglRenderer j;
    public final /* synthetic */ EglBase$Context k;
    public final /* synthetic */ int[] l;

    public /* synthetic */ j(EglRenderer eglRenderer, EglBase$Context eglBase$Context, int[] iArr) {
        this.j = eglRenderer;
        this.k = eglBase$Context;
        this.l = iArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.d(this.k, this.l);
    }
}
