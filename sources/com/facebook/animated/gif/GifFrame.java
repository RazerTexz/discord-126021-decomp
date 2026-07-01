package com.facebook.animated.gif;

import android.graphics.Bitmap;
import b.f.d.d.c;
import b.f.j.a.a.d;

/* JADX INFO: loaded from: classes.dex */
public class GifFrame implements d {

    @c
    private long mNativeContext;

    @c
    public GifFrame(long j) {
        this.mNativeContext = j;
    }

    @c
    private native void nativeDispose();

    @c
    private native void nativeFinalize();

    @c
    private native int nativeGetDisposalMode();

    @c
    private native int nativeGetDurationMs();

    @c
    private native int nativeGetHeight();

    @c
    private native int nativeGetTransparentPixelColor();

    @c
    private native int nativeGetWidth();

    @c
    private native int nativeGetXOffset();

    @c
    private native int nativeGetYOffset();

    @c
    private native boolean nativeHasTransparency();

    @c
    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    @Override // b.f.j.a.a.d
    public void a(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }

    @Override // b.f.j.a.a.d
    public int b() {
        return nativeGetXOffset();
    }

    @Override // b.f.j.a.a.d
    public int c() {
        return nativeGetYOffset();
    }

    public int d() {
        return nativeGetDisposalMode();
    }

    @Override // b.f.j.a.a.d
    public void dispose() {
        nativeDispose();
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // b.f.j.a.a.d
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // b.f.j.a.a.d
    public int getWidth() {
        return nativeGetWidth();
    }
}
