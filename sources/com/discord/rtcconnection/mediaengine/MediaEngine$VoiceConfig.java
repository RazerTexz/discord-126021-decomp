package com.discord.rtcconnection.mediaengine;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: MediaEngine.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MediaEngine$VoiceConfig {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final float outputVolume;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean echoCancellation;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final boolean noiseSuppression;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final boolean noiseCancellation;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final boolean automaticGainControl;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final MediaEngineConnection$InputMode inputMode;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final MediaEngineConnection$c inputModeOptions;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final boolean isSelfDeafened;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final boolean isSelfMuted;

    public MediaEngine$VoiceConfig(float f, boolean z2, boolean z3, boolean z4, boolean z5, MediaEngineConnection$InputMode mediaEngineConnection$InputMode, MediaEngineConnection$c mediaEngineConnection$c, boolean z6, boolean z7) {
        m.checkNotNullParameter(mediaEngineConnection$InputMode, "inputMode");
        m.checkNotNullParameter(mediaEngineConnection$c, "inputModeOptions");
        this.outputVolume = f;
        this.echoCancellation = z2;
        this.noiseSuppression = z3;
        this.noiseCancellation = z4;
        this.automaticGainControl = z5;
        this.inputMode = mediaEngineConnection$InputMode;
        this.inputModeOptions = mediaEngineConnection$c;
        this.isSelfDeafened = z6;
        this.isSelfMuted = z7;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaEngine$VoiceConfig)) {
            return false;
        }
        MediaEngine$VoiceConfig mediaEngine$VoiceConfig = (MediaEngine$VoiceConfig) other;
        return Float.compare(this.outputVolume, mediaEngine$VoiceConfig.outputVolume) == 0 && this.echoCancellation == mediaEngine$VoiceConfig.echoCancellation && this.noiseSuppression == mediaEngine$VoiceConfig.noiseSuppression && this.noiseCancellation == mediaEngine$VoiceConfig.noiseCancellation && this.automaticGainControl == mediaEngine$VoiceConfig.automaticGainControl && m.areEqual(this.inputMode, mediaEngine$VoiceConfig.inputMode) && m.areEqual(this.inputModeOptions, mediaEngine$VoiceConfig.inputModeOptions) && this.isSelfDeafened == mediaEngine$VoiceConfig.isSelfDeafened && this.isSelfMuted == mediaEngine$VoiceConfig.isSelfMuted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iFloatToIntBits = Float.floatToIntBits(this.outputVolume) * 31;
        boolean z2 = this.echoCancellation;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iFloatToIntBits + r1) * 31;
        boolean z3 = this.noiseSuppression;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.noiseCancellation;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.automaticGainControl;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        MediaEngineConnection$InputMode mediaEngineConnection$InputMode = this.inputMode;
        int iHashCode = (i4 + (mediaEngineConnection$InputMode != null ? mediaEngineConnection$InputMode.hashCode() : 0)) * 31;
        MediaEngineConnection$c mediaEngineConnection$c = this.inputModeOptions;
        int iHashCode2 = (iHashCode + (mediaEngineConnection$c != null ? mediaEngineConnection$c.hashCode() : 0)) * 31;
        boolean z6 = this.isSelfDeafened;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (iHashCode2 + r5) * 31;
        boolean z7 = this.isSelfMuted;
        return i5 + (z7 ? 1 : z7);
    }

    public String toString() {
        StringBuilder sbU = a.U("VoiceConfig(outputVolume=");
        sbU.append(this.outputVolume);
        sbU.append(", echoCancellation=");
        sbU.append(this.echoCancellation);
        sbU.append(", noiseSuppression=");
        sbU.append(this.noiseSuppression);
        sbU.append(", noiseCancellation=");
        sbU.append(this.noiseCancellation);
        sbU.append(", automaticGainControl=");
        sbU.append(this.automaticGainControl);
        sbU.append(", inputMode=");
        sbU.append(this.inputMode);
        sbU.append(", inputModeOptions=");
        sbU.append(this.inputModeOptions);
        sbU.append(", isSelfDeafened=");
        sbU.append(this.isSelfDeafened);
        sbU.append(", isSelfMuted=");
        return a.O(sbU, this.isSelfMuted, ")");
    }
}
