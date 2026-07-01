package com.discord.rtcconnection.mediaengine;

import b.d.b.a.a;

/* JADX INFO: compiled from: MediaEngine.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MediaEngine$LocalVoiceStatus {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final float amplitude;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isSpeaking;

    public MediaEngine$LocalVoiceStatus(float f, boolean z2) {
        this.amplitude = f;
        this.isSpeaking = z2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaEngine$LocalVoiceStatus)) {
            return false;
        }
        MediaEngine$LocalVoiceStatus mediaEngine$LocalVoiceStatus = (MediaEngine$LocalVoiceStatus) other;
        return Float.compare(this.amplitude, mediaEngine$LocalVoiceStatus.amplitude) == 0 && this.isSpeaking == mediaEngine$LocalVoiceStatus.isSpeaking;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iFloatToIntBits = Float.floatToIntBits(this.amplitude) * 31;
        boolean z2 = this.isSpeaking;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iFloatToIntBits + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("LocalVoiceStatus(amplitude=");
        sbU.append(this.amplitude);
        sbU.append(", isSpeaking=");
        return a.O(sbU, this.isSpeaking, ")");
    }
}
