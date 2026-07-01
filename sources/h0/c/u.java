package h0.c;

import org.webrtc.SurfaceTextureHelper;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u implements Runnable {
    public final /* synthetic */ SurfaceTextureHelper j;

    public /* synthetic */ u(SurfaceTextureHelper surfaceTextureHelper) {
        this.j = surfaceTextureHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.b();
    }
}
