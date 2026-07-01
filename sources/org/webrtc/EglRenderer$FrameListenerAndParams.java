package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class EglRenderer$FrameListenerAndParams {
    public final boolean applyFpsReduction;
    public final RendererCommon$GlDrawer drawer;
    public final EglRenderer$FrameListener listener;
    public final float scale;

    public EglRenderer$FrameListenerAndParams(EglRenderer$FrameListener eglRenderer$FrameListener, float f, RendererCommon$GlDrawer rendererCommon$GlDrawer, boolean z2) {
        this.listener = eglRenderer$FrameListener;
        this.scale = f;
        this.drawer = rendererCommon$GlDrawer;
        this.applyFpsReduction = z2;
    }
}
