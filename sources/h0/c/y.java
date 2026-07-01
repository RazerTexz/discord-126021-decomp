package h0.c;

import org.webrtc.SurfaceViewRenderer;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class y implements Runnable {
    public final /* synthetic */ SurfaceViewRenderer j;
    public final /* synthetic */ int k;
    public final /* synthetic */ int l;

    public /* synthetic */ y(SurfaceViewRenderer surfaceViewRenderer, int i, int i2) {
        this.j = surfaceViewRenderer;
        this.k = i;
        this.l = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.a(this.k, this.l);
    }
}
