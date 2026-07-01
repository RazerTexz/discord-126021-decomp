package com.facebook.animated.gif;

import android.graphics.Bitmap;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.DoNotStrip;
import b.f.j.a.a.AnimatedDrawableFrameInfo;
import b.f.j.a.a.AnimatedImage;
import b.f.j.a.a.AnimatedImageFrame;
import b.f.j.a.b.AnimatedImageDecoder;
import b.f.j.d.ImageDecodeOptions;
import b.f.m.n.NativeLoader;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@DoNotStrip
public class GifImage implements AnimatedImage, AnimatedImageDecoder {
    public static volatile boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap.Config f2881b = null;

    @DoNotStrip
    private long mNativeContext;

    @DoNotStrip
    public GifImage() {
    }

    public static synchronized void k() {
        if (!a) {
            a = true;
            NativeLoader.c("gifimage");
        }
    }

    @DoNotStrip
    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer, int i, boolean z2);

    @DoNotStrip
    private static native GifImage nativeCreateFromFileDescriptor(int i, int i2, boolean z2);

    @DoNotStrip
    private static native GifImage nativeCreateFromNativeMemory(long j, int i, int i2, boolean z2);

    @DoNotStrip
    private native void nativeDispose();

    @DoNotStrip
    private native void nativeFinalize();

    @DoNotStrip
    private native int nativeGetDuration();

    @DoNotStrip
    private native GifFrame nativeGetFrame(int i);

    @DoNotStrip
    private native int nativeGetFrameCount();

    @DoNotStrip
    private native int[] nativeGetFrameDurations();

    @DoNotStrip
    private native int nativeGetHeight();

    @DoNotStrip
    private native int nativeGetLoopCount();

    @DoNotStrip
    private native int nativeGetSizeInBytes();

    @DoNotStrip
    private native int nativeGetWidth();

    @DoNotStrip
    private native boolean nativeIsAnimated();

    @Override // b.f.j.a.a.AnimatedImage
    public int a() {
        return nativeGetFrameCount();
    }

    @Override // b.f.j.a.a.AnimatedImage
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

    @Override // b.f.j.a.b.AnimatedImageDecoder
    public AnimatedImage c(ByteBuffer byteBuffer, ImageDecodeOptions imageDecodeOptions) {
        k();
        byteBuffer.rewind();
        GifImage gifImageNativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer, imageDecodeOptions.c, false);
        gifImageNativeCreateFromDirectByteBuffer.f2881b = imageDecodeOptions.e;
        return gifImageNativeCreateFromDirectByteBuffer;
    }

    @Override // b.f.j.a.a.AnimatedImage
    public Bitmap.Config d() {
        return this.f2881b;
    }

    @Override // b.f.j.a.a.AnimatedImage
    public AnimatedImageFrame e(int i) {
        return nativeGetFrame(i);
    }

    @Override // b.f.j.a.a.AnimatedImage
    public boolean f() {
        return false;
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // b.f.j.a.a.AnimatedImage
    public AnimatedDrawableFrameInfo g(int i) {
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
                return new AnimatedDrawableFrameInfo(i, iB, iC, width, height, 1, i2);
            }
            i2 = 1;
            return new AnimatedDrawableFrameInfo(i, iB, iC, width, height, 1, i2);
        } finally {
            gifFrameNativeGetFrame.dispose();
        }
    }

    @Override // b.f.j.a.a.AnimatedImage
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // b.f.j.a.a.AnimatedImage
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // b.f.j.a.b.AnimatedImageDecoder
    public AnimatedImage h(long j, int i, ImageDecodeOptions imageDecodeOptions) {
        k();
        AnimatableValueParser.i(Boolean.valueOf(j != 0));
        GifImage gifImageNativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j, i, imageDecodeOptions.c, false);
        gifImageNativeCreateFromNativeMemory.f2881b = imageDecodeOptions.e;
        return gifImageNativeCreateFromNativeMemory;
    }

    @Override // b.f.j.a.a.AnimatedImage
    public int[] i() {
        return nativeGetFrameDurations();
    }

    @Override // b.f.j.a.a.AnimatedImage
    public int j() {
        return nativeGetSizeInBytes();
    }

    @DoNotStrip
    public GifImage(long j) {
        this.mNativeContext = j;
    }
}
