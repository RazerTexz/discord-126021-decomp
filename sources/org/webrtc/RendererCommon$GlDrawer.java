package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface RendererCommon$GlDrawer {
    void drawOes(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7);

    void drawRgb(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7);

    void drawYuv(int[] iArr, float[] fArr, int i, int i2, int i3, int i4, int i5, int i6);

    void release();
}
