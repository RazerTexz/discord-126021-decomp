package com.facebook.animated.gif;

import android.graphics.Bitmap;
import b.f.d.d.DoNotStrip;
import b.f.j.a.a.AnimatedImageFrame;

/* JADX INFO: loaded from: classes.dex */
public class GifFrame implements AnimatedImageFrame {

    @DoNotStrip
    private long mNativeContext;

    @DoNotStrip
    public GifFrame(long j) {
        this.mNativeContext = j;
    }

    @DoNotStrip
    private native void nativeDispose();

    @DoNotStrip
    private native void nativeFinalize();

    @DoNotStrip
    private native int nativeGetDisposalMode();

    @DoNotStrip
    private native int nativeGetDurationMs();

    @DoNotStrip
    private native int nativeGetHeight();

    @DoNotStrip
    private native int nativeGetTransparentPixelColor();

    @DoNotStrip
    private native int nativeGetWidth();

    @DoNotStrip
    private native int nativeGetXOffset();

    @DoNotStrip
    private native int nativeGetYOffset();

    @DoNotStrip
    private native boolean nativeHasTransparency();

    @DoNotStrip
    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    @Override // b.f.j.a.a.AnimatedImageFrame
    public void a(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }

    @Override // b.f.j.a.a.AnimatedImageFrame
    public int b() {
        return nativeGetXOffset();
    }

    @Override // b.f.j.a.a.AnimatedImageFrame
    public int c() {
        return nativeGetYOffset();
    }

    public int d() {
        return nativeGetDisposalMode();
    }

    @Override // b.f.j.a.a.AnimatedImageFrame
    public void dispose() {
        nativeDispose();
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // b.f.j.a.a.AnimatedImageFrame
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // b.f.j.a.a.AnimatedImageFrame
    public int getWidth() {
        return nativeGetWidth();
    }
}
