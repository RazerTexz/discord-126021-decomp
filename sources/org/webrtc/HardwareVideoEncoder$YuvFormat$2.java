package org.webrtc;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final enum HardwareVideoEncoder$YuvFormat$2 extends HardwareVideoEncoder$YuvFormat {
    public HardwareVideoEncoder$YuvFormat$2(String str, int i) {
        super(str, i, null);
    }

    @Override // org.webrtc.HardwareVideoEncoder$YuvFormat
    public void fillBuffer(ByteBuffer byteBuffer, VideoFrame$Buffer videoFrame$Buffer) {
        VideoFrame$I420Buffer i420 = videoFrame$Buffer.toI420();
        YuvHelper.I420ToNV12(i420.getDataY(), i420.getStrideY(), i420.getDataU(), i420.getStrideU(), i420.getDataV(), i420.getStrideV(), byteBuffer, i420.getWidth(), i420.getHeight());
        i420.release();
    }
}
