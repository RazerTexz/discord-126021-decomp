package com.facebook.animated.gif;

import android.graphics.Bitmap$Config;
import b.f.d.d.c;
import b.f.j.a.a.d;
import b.f.j.d.b;
import b.f.m.n.a;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@c
public class GifImage implements b.f.j.a.a.c, b.f.j.a.b.c {
    public static volatile boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap$Config f2881b = null;

    @c
    private long mNativeContext;

    @c
    public GifImage() {
    }

    public static synchronized void k() {
        if (!a) {
            a = true;
            a.c("gifimage");
        }
    }

    @c
    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer, int i, boolean z2);

    @c
    private static native GifImage nativeCreateFromFileDescriptor(int i, int i2, boolean z2);

    @c
    private static native GifImage nativeCreateFromNativeMemory(long j, int i, int i2, boolean z2);

    @c
    private native void nativeDispose();

    @c
    private native void nativeFinalize();

    @c
    private native int nativeGetDuration();

    @c
    private native GifFrame nativeGetFrame(int i);

    @c
    private native int nativeGetFrameCount();

    @c
    private native int[] nativeGetFrameDurations();

    @c
    private native int nativeGetHeight();

    @c
    private native int nativeGetLoopCount();

    @c
    private native int nativeGetSizeInBytes();

    @c
    private native int nativeGetWidth();

    @c
    private native boolean nativeIsAnimated();

    @Override // b.f.j.a.a.c
    public int a() {
        return nativeGetFrameCount();
    }

    @Override // b.f.j.a.a.c
    public int b() {
        int iNativeGetLoopCount = nativeGetLoopCount();
        if (iNativeGetLoopCount == -1) {
            return 1;
        }
        if (iNativeGetLoopCount != 0) {
            return iNativeGetLoopCount + 1;
        }
        return 0;
    }

    @Override // b.f.j.a.b.c
    public b.f.j.a.a.c c(ByteBuffer byteBuffer, b bVar) {
        k();
        byteBuffer.rewind();
        GifImage gifImageNativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer, bVar.c, false);
        gifImageNativeCreateFromDirectByteBuffer.f2881b = bVar.e;
        return gifImageNativeCreateFromDirectByteBuffer;
    }

    @Override // b.f.j.a.a.c
    public Bitmap$Config d() {
        return this.f2881b;
    }

    @Override // b.f.j.a.a.c
    public d e(int i) {
        return nativeGetFrame(i);
    }

    @Override // b.f.j.a.a.c
    public boolean f() {
        return false;
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // b.f.j.a.a.c
    public b.f.j.a.a.b g(int i) {
        int i2;
        GifFrame gifFrameNativeGetFrame = nativeGetFrame(i);
        try {
            int iB = gifFrameNativeGetFrame.b();
            int iC = gifFrameNativeGetFrame.c();
            int width = gifFrameNativeGetFrame.getWidth();
            int height = gifFrameNativeGetFrame.getHeight();
            int iD = gifFrameNativeGetFrame.d();
            if (iD != 0 && iD != 1) {
                i2 = 3;
                if (iD == 2) {
                    i2 = 2;
                } else if (iD == 3) {
                }
                return new b.f.j.a.a.b(i, iB, iC, width, height, 1, i2);
            }
            i2 = 1;
            return new b.f.j.a.a.b(i, iB, iC, width, height, 1, i2);
        } finally {
            gifFrameNativeGetFrame.dispose();
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
        k();
        b.c.a.a0.d.i(Boolean.valueOf(j != 0));
        GifImage gifImageNativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j, i, bVar.c, false);
        gifImageNativeCreateFromNativeMemory.f2881b = bVar.e;
        return gifImageNativeCreateFromNativeMemory;
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
    public GifImage(long j) {
        this.mNativeContext = j;
    }
}
