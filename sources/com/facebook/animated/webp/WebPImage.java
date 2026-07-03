package com.facebook.animated.webp;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p161j.p162a.p163a.C1835b;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1836c;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1837d;
import p007b.p109f.p161j.p162a.p164b.InterfaceC1842c;
import p007b.p109f.p161j.p169d.C1881b;
import p007b.p109f.p161j.p178m.C1956b;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC1680c
public class WebPImage implements InterfaceC1836c, InterfaceC1842c {

    /* JADX INFO: renamed from: a */
    public Bitmap.Config f19420a = null;

    @InterfaceC1680c
    private long mNativeContext;

    @InterfaceC1680c
    public WebPImage() {
    }

    private static native WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private static native WebPImage nativeCreateFromNativeMemory(long j, int i);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native WebPFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: a */
    public int mo1177a() {
        return nativeGetFrameCount();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: b */
    public int mo1178b() {
        return nativeGetLoopCount();
    }

    @Override // p007b.p109f.p161j.p162a.p164b.InterfaceC1842c
    /* JADX INFO: renamed from: c */
    public InterfaceC1836c mo1192c(ByteBuffer byteBuffer, C1881b c1881b) {
        C1956b.m1411a();
        byteBuffer.rewind();
        WebPImage webPImageNativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer);
        if (c1881b != null) {
            webPImageNativeCreateFromDirectByteBuffer.f19420a = c1881b.f3710e;
        }
        return webPImageNativeCreateFromDirectByteBuffer;
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: d */
    public Bitmap.Config mo1179d() {
        return this.f19420a;
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: e */
    public InterfaceC1837d mo1180e(int i) {
        return nativeGetFrame(i);
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: f */
    public boolean mo1181f() {
        return true;
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: g */
    public C1835b mo1182g(int i) {
        WebPFrame webPFrameNativeGetFrame = nativeGetFrame(i);
        try {
            return new C1835b(i, webPFrameNativeGetFrame.mo1186b(), webPFrameNativeGetFrame.mo1187c(), webPFrameNativeGetFrame.getWidth(), webPFrameNativeGetFrame.getHeight(), webPFrameNativeGetFrame.m8630d() ? 1 : 2, webPFrameNativeGetFrame.m8631e() ? 2 : 1);
        } finally {
            webPFrameNativeGetFrame.dispose();
        }
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // p007b.p109f.p161j.p162a.p164b.InterfaceC1842c
    /* JADX INFO: renamed from: h */
    public InterfaceC1836c mo1193h(long j, int i, C1881b c1881b) {
        C1956b.m1411a();
        C1460d.m527i(Boolean.valueOf(j != 0));
        WebPImage webPImageNativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j, i);
        if (c1881b != null) {
            webPImageNativeCreateFromNativeMemory.f19420a = c1881b.f3710e;
        }
        return webPImageNativeCreateFromNativeMemory;
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: i */
    public int[] mo1183i() {
        return nativeGetFrameDurations();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: j */
    public int mo1184j() {
        return nativeGetSizeInBytes();
    }

    @InterfaceC1680c
    public WebPImage(long j) {
        this.mNativeContext = j;
    }
}
