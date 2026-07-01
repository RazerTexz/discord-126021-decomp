package h0.c;

import android.os.Looper;
import org.webrtc.EglRenderer;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ EglRenderer j;
    public final /* synthetic */ Looper k;

    public /* synthetic */ k(EglRenderer eglRenderer, Looper looper) {
        this.j = eglRenderer;
        this.k = looper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.f(this.k);
    }
}
