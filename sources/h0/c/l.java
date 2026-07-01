package h0.c;

import org.webrtc.EglRenderer;
import org.webrtc.EglRenderer$FrameListener;
import org.webrtc.RendererCommon$GlDrawer;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ EglRenderer j;
    public final /* synthetic */ RendererCommon$GlDrawer k;
    public final /* synthetic */ EglRenderer$FrameListener l;
    public final /* synthetic */ float m;
    public final /* synthetic */ boolean n;

    public /* synthetic */ l(EglRenderer eglRenderer, RendererCommon$GlDrawer rendererCommon$GlDrawer, EglRenderer$FrameListener eglRenderer$FrameListener, float f, boolean z2) {
        this.j = eglRenderer;
        this.k = rendererCommon$GlDrawer;
        this.l = eglRenderer$FrameListener;
        this.m = f;
        this.n = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.a(this.k, this.l, this.m, this.n);
    }
}
