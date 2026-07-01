package org.webrtc;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class EncodedImage$Builder {
    private ByteBuffer buffer;
    private long captureTimeNs;
    private int encodedHeight;
    private int encodedWidth;
    private EncodedImage$FrameType frameType;

    @Nullable
    private Integer qp;

    @Nullable
    private Runnable releaseCallback;
    private int rotation;

    public /* synthetic */ EncodedImage$Builder(EncodedImage$1 encodedImage$1) {
        this();
    }

    public EncodedImage createEncodedImage() {
        return new EncodedImage(this.buffer, this.releaseCallback, this.encodedWidth, this.encodedHeight, this.captureTimeNs, this.frameType, this.rotation, this.qp, null);
    }

    public EncodedImage$Builder setBuffer(ByteBuffer byteBuffer, @Nullable Runnable runnable) {
        this.buffer = byteBuffer;
        this.releaseCallback = runnable;
        return this;
    }

    @Deprecated
    public EncodedImage$Builder setCaptureTimeMs(long j) {
        this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(j);
        return this;
    }

    public EncodedImage$Builder setCaptureTimeNs(long j) {
        this.captureTimeNs = j;
        return this;
    }

    public EncodedImage$Builder setEncodedHeight(int i) {
        this.encodedHeight = i;
        return this;
    }

    public EncodedImage$Builder setEncodedWidth(int i) {
        this.encodedWidth = i;
        return this;
    }

    public EncodedImage$Builder setFrameType(EncodedImage$FrameType encodedImage$FrameType) {
        this.frameType = encodedImage$FrameType;
        return this;
    }

    public EncodedImage$Builder setQp(@Nullable Integer num) {
        this.qp = num;
        return this;
    }

    public EncodedImage$Builder setRotation(int i) {
        this.rotation = i;
        return this;
    }

    private EncodedImage$Builder() {
    }
}
