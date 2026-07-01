package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class VideoEncoder$EncodeInfo {
    public final EncodedImage$FrameType[] frameTypes;

    @CalledByNative("EncodeInfo")
    public VideoEncoder$EncodeInfo(EncodedImage$FrameType[] encodedImage$FrameTypeArr) {
        this.frameTypes = encodedImage$FrameTypeArr;
    }
}
