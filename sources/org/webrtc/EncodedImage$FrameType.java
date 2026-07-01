package org.webrtc;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public enum EncodedImage$FrameType {
    EmptyFrame(0),
    VideoFrameKey(3),
    VideoFrameDelta(4);

    private final int nativeIndex;

    EncodedImage$FrameType(int i) {
        this.nativeIndex = i;
    }

    @CalledByNative("FrameType")
    public static EncodedImage$FrameType fromNativeIndex(int i) {
        EncodedImage$FrameType[] encodedImage$FrameTypeArrValues = values();
        for (int i2 = 0; i2 < 3; i2++) {
            EncodedImage$FrameType encodedImage$FrameType = encodedImage$FrameTypeArrValues[i2];
            if (encodedImage$FrameType.getNative() == i) {
                return encodedImage$FrameType;
            }
        }
        throw new IllegalArgumentException(a.q("Unknown native frame type: ", i));
    }

    public int getNative() {
        return this.nativeIndex;
    }
}
