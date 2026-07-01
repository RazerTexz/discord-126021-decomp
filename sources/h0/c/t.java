package h0.c;

import org.webrtc.SurfaceTextureHelper;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t implements Runnable {
    public final /* synthetic */ SurfaceTextureHelper j;
    public final /* synthetic */ int k;
    public final /* synthetic */ int l;

    public /* synthetic */ t(SurfaceTextureHelper surfaceTextureHelper, int i, int i2) {
        this.j = surfaceTextureHelper;
        this.k = i;
        this.l = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.f(this.k, this.l);
    }
}
