package com.facebook.animated.webp;

import android.graphics.Bitmap$Config;
import b.f.d.d.c;
import b.f.j.a.a.d;
import b.f.j.d.b;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@c
public class WebPImage implements b.f.j.a.a.c, b.f.j.a.b.c {
    public Bitmap$Config a = null;

    @c
    private long mNativeContext;

    @c
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

    @Override // b.f.j.a.a.c
    public int a() {
        return nativeGetFrameCount();
    }

    @Override // b.f.j.a.a.c
    public int b() {
        return nativeGetLoopCount();
    }

    @Override // b.f.j.a.b.c
    public b.f.j.a.a.c c(ByteBuffer byteBuffer, b bVar) {
        b.f.j.m.b.a();
        byteBuffer.rewind();
        WebPImage webPImageNativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer);
        if (bVar != null) {
            webPImageNativeCreateFromDirectByteBuffer.a = bVar.e;
        }
        return webPImageNativeCreateFromDirectByteBuffer;
    }

    @Override // b.f.j.a.a.c
    public Bitmap$Config d() {
        return this.a;
    }

    @Override // b.f.j.a.a.c
    public d e(int i) {
        return nativeGetFrame(i);
    }

    @Override // b.f.j.a.a.c
    public boolean f() {
        return true;
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // b.f.j.a.a.c
    public b.f.j.a.a.b g(int i) {
        WebPFrame webPFrameNativeGetFrame = nativeGetFrame(i);
        try {
            return new b.f.j.a.a.b(i, webPFrameNativeGetFrame.b(), webPFrameNativeGetFrame.c(), webPFrameNativeGetFrame.getWidth(), webPFrameNativeGetFrame.getHeight(), webPFrameNativeGetFrame.d() ? 1 : 2, webPFrameNativeGetFrame.e() ? 2 : 1);
        } finally {
            webPFrameNativeGetFrame.dispose();
        }
    }

    @Override // b.f.j.a.a.c
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // b.f.j.a.a.c
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // b.f.j.a.b.c
    public b.f.j.a.a.c h(long j, int i, b bVar) {
        b.f.j.m.b.a();
        b.c.a.a0.d.i(Boolean.valueOf(j != 0));
        WebPImage webPImageNativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j, i);
        if (bVar != null) {
            webPImageNativeCreateFromNativeMemory.a = bVar.e;
        }
        return webPImageNativeCreateFromNativeMemory;
    }

    @Override // b.f.j.a.a.c
    public int[] i() {
        return nativeGetFrameDurations();
    }

    @Override // b.f.j.a.a.c
    public int j() {
        return nativeGetSizeInBytes();
    }

    @c
    public WebPImage(long j) {
        this.mNativeContext = j;
    }
}
