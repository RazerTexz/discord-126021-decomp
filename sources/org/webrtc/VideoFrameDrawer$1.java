package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class VideoFrameDrawer$1 {
    public static final /* synthetic */ int[] $SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type;

    static {
        VideoFrame$TextureBuffer$Type.values();
        int[] iArr = new int[2];
        $SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type = iArr;
        try {
            iArr[VideoFrame$TextureBuffer$Type.OES.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type[VideoFrame$TextureBuffer$Type.RGB.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
