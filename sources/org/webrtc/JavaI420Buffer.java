package org.webrtc;

import androidx.annotation.Nullable;
import b.d.b.a.a;
import h0.c.m;
import h0.c.o;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class JavaI420Buffer implements VideoFrame$I420Buffer {
    private final ByteBuffer dataU;
    private final ByteBuffer dataV;
    private final ByteBuffer dataY;
    private final int height;
    private final RefCountDelegate refCountDelegate;
    private final int strideU;
    private final int strideV;
    private final int strideY;
    private final int width;

    private JavaI420Buffer(int i, int i2, ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i4, ByteBuffer byteBuffer3, int i5, @Nullable Runnable runnable) {
        this.width = i;
        this.height = i2;
        this.dataY = byteBuffer;
        this.dataU = byteBuffer2;
        this.dataV = byteBuffer3;
        this.strideY = i3;
        this.strideU = i4;
        this.strideV = i5;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    public static JavaI420Buffer allocate(int i, int i2) {
        int i3 = (i2 + 1) / 2;
        int i4 = (i + 1) / 2;
        int i5 = i * i2;
        int i6 = i5 + 0;
        int i7 = i4 * i3;
        int i8 = i6 + i7;
        ByteBuffer byteBufferNativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer((i4 * 2 * i3) + i5);
        byteBufferNativeAllocateByteBuffer.position(0);
        byteBufferNativeAllocateByteBuffer.limit(i6);
        ByteBuffer byteBufferSlice = byteBufferNativeAllocateByteBuffer.slice();
        byteBufferNativeAllocateByteBuffer.position(i6);
        byteBufferNativeAllocateByteBuffer.limit(i8);
        ByteBuffer byteBufferSlice2 = byteBufferNativeAllocateByteBuffer.slice();
        byteBufferNativeAllocateByteBuffer.position(i8);
        byteBufferNativeAllocateByteBuffer.limit(i8 + i7);
        return new JavaI420Buffer(i, i2, byteBufferSlice, i, byteBufferSlice2, i4, byteBufferNativeAllocateByteBuffer.slice(), i4, new o(byteBufferNativeAllocateByteBuffer));
    }

    private static void checkCapacity(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int i4 = ((i2 - 1) * i3) + i;
        if (byteBuffer.capacity() >= i4) {
            return;
        }
        StringBuilder sbV = a.V("Buffer must be at least ", i4, " bytes, but was ");
        sbV.append(byteBuffer.capacity());
        throw new IllegalArgumentException(sbV.toString());
    }

    public static VideoFrame$Buffer cropAndScaleI420(VideoFrame$I420Buffer videoFrame$I420Buffer, int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 != i5 || i4 != i6) {
            JavaI420Buffer javaI420BufferAllocate = allocate(i5, i6);
            nativeCropAndScaleI420(videoFrame$I420Buffer.getDataY(), videoFrame$I420Buffer.getStrideY(), videoFrame$I420Buffer.getDataU(), videoFrame$I420Buffer.getStrideU(), videoFrame$I420Buffer.getDataV(), videoFrame$I420Buffer.getStrideV(), i, i2, i3, i4, javaI420BufferAllocate.getDataY(), javaI420BufferAllocate.getStrideY(), javaI420BufferAllocate.getDataU(), javaI420BufferAllocate.getStrideU(), javaI420BufferAllocate.getDataV(), javaI420BufferAllocate.getStrideV(), i5, i6);
            return javaI420BufferAllocate;
        }
        ByteBuffer dataY = videoFrame$I420Buffer.getDataY();
        ByteBuffer dataU = videoFrame$I420Buffer.getDataU();
        ByteBuffer dataV = videoFrame$I420Buffer.getDataV();
        dataY.position((videoFrame$I420Buffer.getStrideY() * i2) + i);
        int i7 = i / 2;
        int i8 = i2 / 2;
        dataU.position((videoFrame$I420Buffer.getStrideU() * i8) + i7);
        dataV.position((videoFrame$I420Buffer.getStrideV() * i8) + i7);
        videoFrame$I420Buffer.retain();
        return wrap(i5, i6, dataY.slice(), videoFrame$I420Buffer.getStrideY(), dataU.slice(), videoFrame$I420Buffer.getStrideU(), dataV.slice(), videoFrame$I420Buffer.getStrideV(), new m(videoFrame$I420Buffer));
    }

    private static native void nativeCropAndScaleI420(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer4, int i8, ByteBuffer byteBuffer5, int i9, ByteBuffer byteBuffer6, int i10, int i11, int i12);

    public static JavaI420Buffer wrap(int i, int i2, ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i4, ByteBuffer byteBuffer3, int i5, @Nullable Runnable runnable) {
        if (byteBuffer == null || byteBuffer2 == null || byteBuffer3 == null) {
            throw new IllegalArgumentException("Data buffers cannot be null.");
        }
        if (!byteBuffer.isDirect() || !byteBuffer2.isDirect() || !byteBuffer3.isDirect()) {
            throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
        }
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        ByteBuffer byteBufferSlice2 = byteBuffer2.slice();
        ByteBuffer byteBufferSlice3 = byteBuffer3.slice();
        int i6 = (i + 1) / 2;
        int i7 = (i2 + 1) / 2;
        checkCapacity(byteBufferSlice, i, i2, i3);
        checkCapacity(byteBufferSlice2, i6, i7, i4);
        checkCapacity(byteBufferSlice3, i6, i7, i5);
        return new JavaI420Buffer(i, i2, byteBufferSlice, i3, byteBufferSlice2, i4, byteBufferSlice3, i5, runnable);
    }

    @Override // org.webrtc.VideoFrame$Buffer
    public VideoFrame$Buffer cropAndScale(int i, int i2, int i3, int i4, int i5, int i6) {
        return cropAndScaleI420(this, i, i2, i3, i4, i5, i6);
    }

    @Override // org.webrtc.VideoFrame$I420Buffer
    public ByteBuffer getDataU() {
        return this.dataU.slice();
    }

    @Override // org.webrtc.VideoFrame$I420Buffer
    public ByteBuffer getDataV() {
        return this.dataV.slice();
    }

    @Override // org.webrtc.VideoFrame$I420Buffer
    public ByteBuffer getDataY() {
        return this.dataY.slice();
    }

    @Override // org.webrtc.VideoFrame$Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // org.webrtc.VideoFrame$I420Buffer
    public int getStrideU() {
        return this.strideU;
    }

    @Override // org.webrtc.VideoFrame$I420Buffer
    public int getStrideV() {
        return this.strideV;
    }

    @Override // org.webrtc.VideoFrame$I420Buffer
    public int getStrideY() {
        return this.strideY;
    }

    @Override // org.webrtc.VideoFrame$Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // org.webrtc.VideoFrame$Buffer, org.webrtc.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // org.webrtc.VideoFrame$Buffer, org.webrtc.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }

    @Override // org.webrtc.VideoFrame$Buffer
    public VideoFrame$I420Buffer toI420() {
        retain();
        return this;
    }
}
