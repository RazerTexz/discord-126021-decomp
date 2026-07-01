package org.webrtc;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class EncodedImage implements RefCounted {
    public final ByteBuffer buffer;
    public final long captureTimeMs;
    public final long captureTimeNs;
    public final int encodedHeight;
    public final int encodedWidth;
    public final EncodedImage$FrameType frameType;

    @Nullable
    public final Integer qp;
    private final RefCountDelegate refCountDelegate;
    public final int rotation;

    public /* synthetic */ EncodedImage(ByteBuffer byteBuffer, Runnable runnable, int i, int i2, long j, EncodedImage$FrameType encodedImage$FrameType, int i3, Integer num, EncodedImage$1 encodedImage$1) {
        this(byteBuffer, runnable, i, i2, j, encodedImage$FrameType, i3, num);
    }

    public static EncodedImage$Builder builder() {
        return new EncodedImage$Builder(null);
    }

    @CalledByNative
    private ByteBuffer getBuffer() {
        return this.buffer;
    }

    @CalledByNative
    private long getCaptureTimeNs() {
        return this.captureTimeNs;
    }

    @CalledByNative
    private int getEncodedHeight() {
        return this.encodedHeight;
    }

    @CalledByNative
    private int getEncodedWidth() {
        return this.encodedWidth;
    }

    @CalledByNative
    private int getFrameType() {
        return this.frameType.getNative();
    }

    @Nullable
    @CalledByNative
    private Integer getQp() {
        return this.qp;
    }

    @CalledByNative
    private int getRotation() {
        return this.rotation;
    }

    @Override // org.webrtc.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // org.webrtc.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }

    @CalledByNative
    private EncodedImage(ByteBuffer byteBuffer, @Nullable Runnable runnable, int i, int i2, long j, EncodedImage$FrameType encodedImage$FrameType, int i3, @Nullable Integer num) {
        this.buffer = byteBuffer;
        this.encodedWidth = i;
        this.encodedHeight = i2;
        this.captureTimeMs = TimeUnit.NANOSECONDS.toMillis(j);
        this.captureTimeNs = j;
        this.frameType = encodedImage$FrameType;
        this.rotation = i3;
        this.qp = num;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }
}
