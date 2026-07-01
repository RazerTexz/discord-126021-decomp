package com.facebook.animated.webp;

import android.graphics.Bitmap;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.DoNotStrip;
import b.f.j.a.a.AnimatedDrawableFrameInfo;
import b.f.j.a.a.AnimatedImage;
import b.f.j.a.a.AnimatedImageFrame;
import b.f.j.a.b.AnimatedImageDecoder;
import b.f.j.d.ImageDecodeOptions;
import b.f.j.m.StaticWebpNativeLoader;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@DoNotStrip
public class WebPImage implements AnimatedImage, AnimatedImageDecoder {
    public Bitmap.Config a = null;

    @DoNotStrip
    private long mNativeContext;

    @DoNotStrip
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

    @Override // b.f.j.a.a.AnimatedImage
    public int a() {
        return nativeGetFrameCount();
    }

    @Override // b.f.j.a.a.AnimatedImage
    public int b() {
        return nativeGetLoopCount();
    }

    @Override // b.f.j.a.b.AnimatedImageDecoder
    public AnimatedImage c(ByteBuffer byteBuffer, ImageDecodeOptions imageDecodeOptions) {
        StaticWebpNativeLoader.a();
        byteBuffer.rewind();
        WebPImage webPImageNativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer);
        if (imageDecodeOptions != null) {
            webPImageNativeCreateFromDirectByteBuffer.a = imageDecodeOptions.e;
        }
        return webPImageNativeCreateFromDirectByteBuffer;
    }

    @Override // b.f.j.a.a.AnimatedImage
    public Bitmap.Config d() {
        return this.a;
    }

    @Override // b.f.j.a.a.AnimatedImage
    public AnimatedImageFrame e(int i) {
        return nativeGetFrame(i);
    }

    @Override // b.f.j.a.a.AnimatedImage
    public boolean f() {
        return true;
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // b.f.j.a.a.AnimatedImage
    public AnimatedDrawableFrameInfo g(int i) {
        WebPFrame webPFrameNativeGetFrame = nativeGetFrame(i);
        try {
            return new AnimatedDrawableFrameInfo(i, webPFrameNativeGetFrame.b(), webPFrameNativeGetFrame.c(), webPFrameNativeGetFrame.getWidth(), webPFrameNativeGetFrame.getHeight(), webPFrameNativeGetFrame.d() ? 1 : 2, webPFrameNativeGetFrame.e() ? 2 : 1);
        } finally {
            webPFrameNativeGetFrame.dispose();
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
        StaticWebpNativeLoader.a();
        AnimatableValueParser.i(Boolean.valueOf(j != 0));
        WebPImage webPImageNativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j, i);
        if (imageDecodeOptions != null) {
            webPImageNativeCreateFromNativeMemory.a = imageDecodeOptions.e;
        }
        return webPImageNativeCreateFromNativeMemory;
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
    public WebPImage(long j) {
        this.mNativeContext = j;
    }
}
