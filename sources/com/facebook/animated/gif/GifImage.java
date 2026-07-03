package com.facebook.animated.gif;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p161j.p162a.p163a.C1835b;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1836c;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1837d;
import p007b.p109f.p161j.p162a.p164b.InterfaceC1842c;
import p007b.p109f.p161j.p169d.C1881b;
import p007b.p109f.p190m.p191n.C2061a;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC1680c
public class GifImage implements InterfaceC1836c, InterfaceC1842c {

    /* JADX INFO: renamed from: a */
    public static volatile boolean f19418a;

    /* JADX INFO: renamed from: b */
    public Bitmap.Config f19419b = null;

    @InterfaceC1680c
    private long mNativeContext;

    @InterfaceC1680c
    public GifImage() {
    }

    /* JADX INFO: renamed from: k */
    public static synchronized void m8629k() {
        if (!f19418a) {
            f19418a = true;
            C2061a.m1589c("gifimage");
        }
    }

    @InterfaceC1680c
    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer, int i, boolean z2);

    @InterfaceC1680c
    private static native GifImage nativeCreateFromFileDescriptor(int i, int i2, boolean z2);

    @InterfaceC1680c
    private static native GifImage nativeCreateFromNativeMemory(long j, int i, int i2, boolean z2);

    @InterfaceC1680c
    private native void nativeDispose();

    @InterfaceC1680c
    private native void nativeFinalize();

    @InterfaceC1680c
    private native int nativeGetDuration();

    @InterfaceC1680c
    private native GifFrame nativeGetFrame(int i);

    @InterfaceC1680c
    private native int nativeGetFrameCount();

    @InterfaceC1680c
    private native int[] nativeGetFrameDurations();

    @InterfaceC1680c
    private native int nativeGetHeight();

    @InterfaceC1680c
    private native int nativeGetLoopCount();

    @InterfaceC1680c
    private native int nativeGetSizeInBytes();

    @InterfaceC1680c
    private native int nativeGetWidth();

    @InterfaceC1680c
    private native boolean nativeIsAnimated();

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: a */
    public int mo1177a() {
        return nativeGetFrameCount();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: b */
    public int mo1178b() {
        int iNativeGetLoopCount = nativeGetLoopCount();
        if (iNativeGetLoopCount == -1) {
            return 1;
        }
        if (iNativeGetLoopCount != 0) {
            return iNativeGetLoopCount + 1;
        }
        return 0;
    }

    @Override // p007b.p109f.p161j.p162a.p164b.InterfaceC1842c
    /* JADX INFO: renamed from: c */
    public InterfaceC1836c mo1192c(ByteBuffer byteBuffer, C1881b c1881b) {
        m8629k();
        byteBuffer.rewind();
        GifImage gifImageNativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer, c1881b.f3708c, false);
        gifImageNativeCreateFromDirectByteBuffer.f19419b = c1881b.f3710e;
        return gifImageNativeCreateFromDirectByteBuffer;
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: d */
    public Bitmap.Config mo1179d() {
        return this.f19419b;
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: e */
    public InterfaceC1837d mo1180e(int i) {
        return nativeGetFrame(i);
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: f */
    public boolean mo1181f() {
        return false;
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.InterfaceC1836c
    /* JADX INFO: renamed from: g */
    public C1835b mo1182g(int i) {
        int i2;
        GifFrame gifFrameNativeGetFrame = nativeGetFrame(i);
        try {
            int iMo1186b = gifFrameNativeGetFrame.mo1186b();
            int iMo1187c = gifFrameNativeGetFrame.mo1187c();
            int width = gifFrameNativeGetFrame.getWidth();
            int height = gifFrameNativeGetFrame.getHeight();
            int iM8628d = gifFrameNativeGetFrame.m8628d();
            if (iM8628d != 0 && iM8628d != 1) {
                i2 = 3;
                if (iM8628d == 2) {
                    i2 = 2;
                } else if (iM8628d == 3) {
                }
                return new C1835b(i, iMo1186b, iMo1187c, width, height, 1, i2);
            }
            i2 = 1;
            return new C1835b(i, iMo1186b, iMo1187c, width, height, 1, i2);
        } finally {
            gifFrameNativeGetFrame.dispose();
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
        m8629k();
        C1460d.m527i(Boolean.valueOf(j != 0));
        GifImage gifImageNativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j, i, c1881b.f3708c, false);
        gifImageNativeCreateFromNativeMemory.f19419b = c1881b.f3710e;
        return gifImageNativeCreateFromNativeMemory;
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
    public GifImage(long j) {
        this.mNativeContext = j;
    }
}
