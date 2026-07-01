package com.facebook.animated.webp;

import android.graphics.Bitmap;
import b.f.d.d.c;
import b.f.j.a.a.d;

/* JADX INFO: loaded from: classes.dex */
public class WebPFrame implements d {

    @c
    private long mNativeContext;

    @c
    public WebPFrame(long j) {
        this.mNativeContext = j;
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native boolean nativeIsBlendWithPreviousFrame();

    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    private native boolean nativeShouldDisposeToBackgroundColor();

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

    public boolean d() {
        return nativeIsBlendWithPreviousFrame();
    }

    @Override // b.f.j.a.a.d
    public void dispose() {
        nativeDispose();
    }

    public boolean e() {
        return nativeShouldDisposeToBackgroundColor();
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
