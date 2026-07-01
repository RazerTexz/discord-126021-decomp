package org.webrtc;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public enum MediaStreamTrack$MediaType {
    MEDIA_TYPE_AUDIO(0),
    MEDIA_TYPE_VIDEO(1);

    private final int nativeIndex;

    MediaStreamTrack$MediaType(int i) {
        this.nativeIndex = i;
    }

    @CalledByNative("MediaType")
    public static MediaStreamTrack$MediaType fromNativeIndex(int i) {
        MediaStreamTrack$MediaType[] mediaStreamTrack$MediaTypeArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            MediaStreamTrack$MediaType mediaStreamTrack$MediaType = mediaStreamTrack$MediaTypeArrValues[i2];
            if (mediaStreamTrack$MediaType.getNative() == i) {
                return mediaStreamTrack$MediaType;
            }
        }
        throw new IllegalArgumentException(a.q("Unknown native media type: ", i));
    }

    @CalledByNative("MediaType")
    public int getNative() {
        return this.nativeIndex;
    }
}
