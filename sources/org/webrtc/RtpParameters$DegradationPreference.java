package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public enum RtpParameters$DegradationPreference {
    DISABLED,
    MAINTAIN_FRAMERATE,
    MAINTAIN_RESOLUTION,
    BALANCED;

    @CalledByNative("DegradationPreference")
    public static RtpParameters$DegradationPreference fromNativeIndex(int i) {
        return values()[i];
    }
}
