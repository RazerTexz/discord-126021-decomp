package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class MediaCodecUtils$1 {
    public static final /* synthetic */ int[] $SwitchMap$org$webrtc$VideoCodecMimeType;

    static {
        VideoCodecMimeType.values();
        int[] iArr = new int[3];
        $SwitchMap$org$webrtc$VideoCodecMimeType = iArr;
        try {
            iArr[VideoCodecMimeType.VP8.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$org$webrtc$VideoCodecMimeType[VideoCodecMimeType.VP9.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$org$webrtc$VideoCodecMimeType[VideoCodecMimeType.H264.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
