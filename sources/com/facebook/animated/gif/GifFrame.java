package com.facebook.animated.gif;

import android.graphics.Bitmap;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1837d;

/* JADX INFO: loaded from: classes.dex */
public class GifFrame implements InterfaceC1837d {

    @InterfaceC1680c
    private long mNativeContext;

    @InterfaceC1680c
    public GifFrame(long j) {
        this.mNativeContext = j;
    }

    @InterfaceC1680c
    private native void nativeDispose();

    @InterfaceC1680c
    private native void nativeFinalize();

    @InterfaceC1680c
    private native int nativeGetDisposalMode();

    @InterfaceC1680c
    private native int nativeGetDurationMs();

    @InterfaceC1680c
    private native int nativeGetHeight();

    @InterfaceC1680c
    private native int nativeGetTransparentPixelColor();

    @InterfaceC1680c
    private native int nativeGetWidth();

    @InterfaceC1680c
    private native int nativeGetXOffset();

    @InterfaceC1680c
    private native int nativeGetYOffset();

    @InterfaceC1680c
    private native boolean nativeHasTransparency();

    @InterfaceC1680c
    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1837d
    /* JADX INFO: renamed from: a */
    public void mo1185a(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1837d
    /* JADX INFO: renamed from: b */
    public int mo1186b() {
        return nativeGetXOffset();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1837d
    /* JADX INFO: renamed from: c */
    public int mo1187c() {
        return nativeGetYOffset();
    }

    /* JADX INFO: renamed from: d */
    public int m8628d() {
        return nativeGetDisposalMode();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1837d
    public void dispose() {
        nativeDispose();
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1837d
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1837d
    public int getWidth() {
        return nativeGetWidth();
    }
}
