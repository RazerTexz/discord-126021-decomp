package org.webrtc;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface VideoFrame$I420Buffer extends VideoFrame$Buffer {
    @CalledByNative("I420Buffer")
    ByteBuffer getDataU();

    @CalledByNative("I420Buffer")
    ByteBuffer getDataV();

    @CalledByNative("I420Buffer")
    ByteBuffer getDataY();

    @CalledByNative("I420Buffer")
    int getStrideU();

    @CalledByNative("I420Buffer")
    int getStrideV();

    @CalledByNative("I420Buffer")
    int getStrideY();
}
