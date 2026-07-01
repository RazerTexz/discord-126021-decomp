package h0.c;

import org.webrtc.EglRenderer;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ EglRenderer j;
    public final /* synthetic */ float k;
    public final /* synthetic */ float l;
    public final /* synthetic */ float m;
    public final /* synthetic */ float n;

    public /* synthetic */ f(EglRenderer eglRenderer, float f, float f2, float f3, float f4) {
        this.j = eglRenderer;
        this.k = f;
        this.l = f2;
        this.m = f3;
        this.n = f4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.b(this.k, this.l, this.m, this.n);
    }
}
