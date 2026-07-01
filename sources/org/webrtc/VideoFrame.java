package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class VideoFrame implements RefCounted {
    private final VideoFrame$Buffer buffer;
    private final int rotation;
    private final long timestampNs;

    @CalledByNative
    public VideoFrame(VideoFrame$Buffer videoFrame$Buffer, int i, long j) {
        if (videoFrame$Buffer == null) {
            throw new IllegalArgumentException("buffer not allowed to be null");
        }
        if (i % 90 != 0) {
            throw new IllegalArgumentException("rotation must be a multiple of 90");
        }
        this.buffer = videoFrame$Buffer;
        this.rotation = i;
        this.timestampNs = j;
    }

    @CalledByNative
    public VideoFrame$Buffer getBuffer() {
        return this.buffer;
    }

    public int getRotatedHeight() {
        return this.rotation % 180 == 0 ? this.buffer.getHeight() : this.buffer.getWidth();
    }

    public int getRotatedWidth() {
        return this.rotation % 180 == 0 ? this.buffer.getWidth() : this.buffer.getHeight();
    }

    @CalledByNative
    public int getRotation() {
        return this.rotation;
    }

    @CalledByNative
    public long getTimestampNs() {
        return this.timestampNs;
    }

    @Override // org.webrtc.RefCounted
    @CalledByNative
    public void release() {
        this.buffer.release();
    }

    @Override // org.webrtc.RefCounted
    public void retain() {
        this.buffer.retain();
    }
}
