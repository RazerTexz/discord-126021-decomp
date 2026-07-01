package com.discord.stores;

import b.d.b.a.a;
import com.discord.rtcconnection.mediaengine.MediaEngine$VoiceConfig;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$c;
import d0.t.h0;
import d0.t.k;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreMediaSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMediaSettings$VoiceConfiguration {
    public static final StoreMediaSettings$VoiceConfiguration$Companion Companion = new StoreMediaSettings$VoiceConfiguration$Companion(null);
    private static final int DEFAULT_NOISE_PROCESSING;
    public static final float DEFAULT_OUTPUT_VOLUME = 100.0f;
    public static final float DEFAULT_SENSITIVITY = -50.0f;
    private static final StoreMediaSettings$VoiceConfiguration DEFAULT_VOICE_CONFIG;
    private final boolean automaticGainControl;
    private final boolean automaticVad;
    private final boolean echoCancellation;
    private final boolean enableVideoHardwareScaling;
    private final MediaEngineConnection$InputMode inputMode;
    private final boolean isSelfDeafened;
    private final boolean isSelfMuted;
    private final Map<Long, Boolean> mutedUsers;
    private final StoreMediaSettings$NoiseProcessing noiseProcessing;
    private final Map<Long, Boolean> offScreenUsers;
    private final float outputVolume;
    private final float sensitivity;
    private final Map<Long, Float> userOutputVolumes;
    private final StoreMediaSettings$VadUseKrisp vadUseKrisp;
    private final boolean voiceParticipantsHidden;

    static {
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = new StoreMediaSettings$VoiceConfiguration(false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32767, null);
        DEFAULT_VOICE_CONFIG = storeMediaSettings$VoiceConfiguration;
        DEFAULT_NOISE_PROCESSING = storeMediaSettings$VoiceConfiguration.noiseProcessing.ordinal();
    }

    public StoreMediaSettings$VoiceConfiguration() {
        this(false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32767, null);
    }

    public StoreMediaSettings$VoiceConfiguration(boolean z2, boolean z3, boolean z4, StoreMediaSettings$VadUseKrisp storeMediaSettings$VadUseKrisp, boolean z5, boolean z6, StoreMediaSettings$NoiseProcessing storeMediaSettings$NoiseProcessing, float f, MediaEngineConnection$InputMode mediaEngineConnection$InputMode, float f2, Map<Long, Boolean> map, Map<Long, Float> map2, Map<Long, Boolean> map3, boolean z7, boolean z8) {
        m.checkNotNullParameter(storeMediaSettings$VadUseKrisp, "vadUseKrisp");
        m.checkNotNullParameter(storeMediaSettings$NoiseProcessing, "noiseProcessing");
        m.checkNotNullParameter(mediaEngineConnection$InputMode, "inputMode");
        m.checkNotNullParameter(map, "mutedUsers");
        m.checkNotNullParameter(map2, "userOutputVolumes");
        m.checkNotNullParameter(map3, "offScreenUsers");
        this.isSelfMuted = z2;
        this.isSelfDeafened = z3;
        this.automaticVad = z4;
        this.vadUseKrisp = storeMediaSettings$VadUseKrisp;
        this.automaticGainControl = z5;
        this.echoCancellation = z6;
        this.noiseProcessing = storeMediaSettings$NoiseProcessing;
        this.sensitivity = f;
        this.inputMode = mediaEngineConnection$InputMode;
        this.outputVolume = f2;
        this.mutedUsers = map;
        this.userOutputVolumes = map2;
        this.offScreenUsers = map3;
        this.enableVideoHardwareScaling = z7;
        this.voiceParticipantsHidden = z8;
    }

    public static final /* synthetic */ int access$getDEFAULT_NOISE_PROCESSING$cp() {
        return DEFAULT_NOISE_PROCESSING;
    }

    public static final /* synthetic */ StoreMediaSettings$VoiceConfiguration access$getDEFAULT_VOICE_CONFIG$cp() {
        return DEFAULT_VOICE_CONFIG;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final boolean getIsSelfMuted() {
        return this.isSelfMuted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreMediaSettings$VoiceConfiguration copy$default(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, boolean z2, boolean z3, boolean z4, StoreMediaSettings$VadUseKrisp storeMediaSettings$VadUseKrisp, boolean z5, boolean z6, StoreMediaSettings$NoiseProcessing storeMediaSettings$NoiseProcessing, float f, MediaEngineConnection$InputMode mediaEngineConnection$InputMode, float f2, Map map, Map map2, Map map3, boolean z7, boolean z8, int i, Object obj) {
        return storeMediaSettings$VoiceConfiguration.copy((i & 1) != 0 ? storeMediaSettings$VoiceConfiguration.isSelfMuted : z2, (i & 2) != 0 ? storeMediaSettings$VoiceConfiguration.isSelfDeafened : z3, (i & 4) != 0 ? storeMediaSettings$VoiceConfiguration.automaticVad : z4, (i & 8) != 0 ? storeMediaSettings$VoiceConfiguration.vadUseKrisp : storeMediaSettings$VadUseKrisp, (i & 16) != 0 ? storeMediaSettings$VoiceConfiguration.automaticGainControl : z5, (i & 32) != 0 ? storeMediaSettings$VoiceConfiguration.echoCancellation : z6, (i & 64) != 0 ? storeMediaSettings$VoiceConfiguration.noiseProcessing : storeMediaSettings$NoiseProcessing, (i & 128) != 0 ? storeMediaSettings$VoiceConfiguration.sensitivity : f, (i & 256) != 0 ? storeMediaSettings$VoiceConfiguration.inputMode : mediaEngineConnection$InputMode, (i & 512) != 0 ? storeMediaSettings$VoiceConfiguration.outputVolume : f2, (i & 1024) != 0 ? storeMediaSettings$VoiceConfiguration.mutedUsers : map, (i & 2048) != 0 ? storeMediaSettings$VoiceConfiguration.userOutputVolumes : map2, (i & 4096) != 0 ? storeMediaSettings$VoiceConfiguration.offScreenUsers : map3, (i & 8192) != 0 ? storeMediaSettings$VoiceConfiguration.enableVideoHardwareScaling : z7, (i & 16384) != 0 ? storeMediaSettings$VoiceConfiguration.voiceParticipantsHidden : z8);
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final float getOutputVolume() {
        return this.outputVolume;
    }

    public final Map<Long, Boolean> component11() {
        return this.mutedUsers;
    }

    public final Map<Long, Float> component12() {
        return this.userOutputVolumes;
    }

    public final Map<Long, Boolean> component13() {
        return this.offScreenUsers;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getEnableVideoHardwareScaling() {
        return this.enableVideoHardwareScaling;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getVoiceParticipantsHidden() {
        return this.voiceParticipantsHidden;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSelfDeafened() {
        return this.isSelfDeafened;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAutomaticVad() {
        return this.automaticVad;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreMediaSettings$VadUseKrisp getVadUseKrisp() {
        return this.vadUseKrisp;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getAutomaticGainControl() {
        return this.automaticGainControl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getEchoCancellation() {
        return this.echoCancellation;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final StoreMediaSettings$NoiseProcessing getNoiseProcessing() {
        return this.noiseProcessing;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final float getSensitivity() {
        return this.sensitivity;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final MediaEngineConnection$InputMode getInputMode() {
        return this.inputMode;
    }

    public final StoreMediaSettings$VoiceConfiguration copy(boolean isSelfMuted, boolean isSelfDeafened, boolean automaticVad, StoreMediaSettings$VadUseKrisp vadUseKrisp, boolean automaticGainControl, boolean echoCancellation, StoreMediaSettings$NoiseProcessing noiseProcessing, float sensitivity, MediaEngineConnection$InputMode inputMode, float outputVolume, Map<Long, Boolean> mutedUsers, Map<Long, Float> userOutputVolumes, Map<Long, Boolean> offScreenUsers, boolean enableVideoHardwareScaling, boolean voiceParticipantsHidden) {
        m.checkNotNullParameter(vadUseKrisp, "vadUseKrisp");
        m.checkNotNullParameter(noiseProcessing, "noiseProcessing");
        m.checkNotNullParameter(inputMode, "inputMode");
        m.checkNotNullParameter(mutedUsers, "mutedUsers");
        m.checkNotNullParameter(userOutputVolumes, "userOutputVolumes");
        m.checkNotNullParameter(offScreenUsers, "offScreenUsers");
        return new StoreMediaSettings$VoiceConfiguration(isSelfMuted, isSelfDeafened, automaticVad, vadUseKrisp, automaticGainControl, echoCancellation, noiseProcessing, sensitivity, inputMode, outputVolume, mutedUsers, userOutputVolumes, offScreenUsers, enableVideoHardwareScaling, voiceParticipantsHidden);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreMediaSettings$VoiceConfiguration)) {
            return false;
        }
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = (StoreMediaSettings$VoiceConfiguration) other;
        return this.isSelfMuted == storeMediaSettings$VoiceConfiguration.isSelfMuted && this.isSelfDeafened == storeMediaSettings$VoiceConfiguration.isSelfDeafened && this.automaticVad == storeMediaSettings$VoiceConfiguration.automaticVad && m.areEqual(this.vadUseKrisp, storeMediaSettings$VoiceConfiguration.vadUseKrisp) && this.automaticGainControl == storeMediaSettings$VoiceConfiguration.automaticGainControl && this.echoCancellation == storeMediaSettings$VoiceConfiguration.echoCancellation && m.areEqual(this.noiseProcessing, storeMediaSettings$VoiceConfiguration.noiseProcessing) && Float.compare(this.sensitivity, storeMediaSettings$VoiceConfiguration.sensitivity) == 0 && m.areEqual(this.inputMode, storeMediaSettings$VoiceConfiguration.inputMode) && Float.compare(this.outputVolume, storeMediaSettings$VoiceConfiguration.outputVolume) == 0 && m.areEqual(this.mutedUsers, storeMediaSettings$VoiceConfiguration.mutedUsers) && m.areEqual(this.userOutputVolumes, storeMediaSettings$VoiceConfiguration.userOutputVolumes) && m.areEqual(this.offScreenUsers, storeMediaSettings$VoiceConfiguration.offScreenUsers) && this.enableVideoHardwareScaling == storeMediaSettings$VoiceConfiguration.enableVideoHardwareScaling && this.voiceParticipantsHidden == storeMediaSettings$VoiceConfiguration.voiceParticipantsHidden;
    }

    public final boolean getAutomaticGainControl() {
        return this.automaticGainControl;
    }

    public final boolean getAutomaticVad() {
        return this.automaticVad;
    }

    public final boolean getEchoCancellation() {
        return this.echoCancellation;
    }

    public final boolean getEnableVideoHardwareScaling() {
        return this.enableVideoHardwareScaling;
    }

    public final MediaEngineConnection$InputMode getInputMode() {
        return this.inputMode;
    }

    public final Map<Long, Boolean> getMutedUsers() {
        return this.mutedUsers;
    }

    public final StoreMediaSettings$NoiseProcessing getNoiseProcessing() {
        return this.noiseProcessing;
    }

    public final Map<Long, Boolean> getOffScreenUsers() {
        return this.offScreenUsers;
    }

    public final float getOutputVolume() {
        return this.outputVolume;
    }

    public final float getSensitivity() {
        return this.sensitivity;
    }

    public final Map<Long, Float> getUserOutputVolumes() {
        return this.userOutputVolumes;
    }

    public final StoreMediaSettings$VadUseKrisp getVadUseKrisp() {
        return this.vadUseKrisp;
    }

    public final boolean getVoiceParticipantsHidden() {
        return this.voiceParticipantsHidden;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public int hashCode() {
        boolean z2 = this.isSelfMuted;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isSelfDeafened;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.automaticVad;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        StoreMediaSettings$VadUseKrisp storeMediaSettings$VadUseKrisp = this.vadUseKrisp;
        int iHashCode = (i3 + (storeMediaSettings$VadUseKrisp != null ? storeMediaSettings$VadUseKrisp.hashCode() : 0)) * 31;
        boolean z5 = this.automaticGainControl;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (iHashCode + r4) * 31;
        boolean z6 = this.echoCancellation;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        StoreMediaSettings$NoiseProcessing storeMediaSettings$NoiseProcessing = this.noiseProcessing;
        int iFloatToIntBits = (Float.floatToIntBits(this.sensitivity) + ((i5 + (storeMediaSettings$NoiseProcessing != null ? storeMediaSettings$NoiseProcessing.hashCode() : 0)) * 31)) * 31;
        MediaEngineConnection$InputMode mediaEngineConnection$InputMode = this.inputMode;
        int iFloatToIntBits2 = (Float.floatToIntBits(this.outputVolume) + ((iFloatToIntBits + (mediaEngineConnection$InputMode != null ? mediaEngineConnection$InputMode.hashCode() : 0)) * 31)) * 31;
        Map<Long, Boolean> map = this.mutedUsers;
        int iHashCode2 = (iFloatToIntBits2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, Float> map2 = this.userOutputVolumes;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, Boolean> map3 = this.offScreenUsers;
        int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
        boolean z7 = this.enableVideoHardwareScaling;
        ?? r6 = z7;
        if (z7) {
            r6 = 1;
        }
        int i6 = (iHashCode4 + r6) * 31;
        boolean z8 = this.voiceParticipantsHidden;
        return i6 + (z8 ? 1 : z8);
    }

    public final boolean isSelfDeafened() {
        return this.isSelfDeafened;
    }

    public final boolean isSelfMuted() {
        return this.isSelfMuted || this.isSelfDeafened;
    }

    public final MediaEngine$VoiceConfig toMediaEngineVoiceConfig() {
        int i = 63 & 1;
        int i2 = 63 & 8;
        int i3 = 63 & 16;
        return new MediaEngine$VoiceConfig(this.outputVolume, this.echoCancellation, k.contains(new StoreMediaSettings$NoiseProcessing[]{StoreMediaSettings$NoiseProcessing.Suppression, StoreMediaSettings$NoiseProcessing.CancellationTemporarilyDisabled}, this.noiseProcessing), this.noiseProcessing == StoreMediaSettings$NoiseProcessing.Cancellation, this.automaticGainControl, this.inputMode, new MediaEngineConnection$c((int) this.sensitivity, (2 & 63) != 0 ? 10 : 0, (63 & 4) != 0 ? 40 : 0, this.automaticVad, this.vadUseKrisp == StoreMediaSettings$VadUseKrisp.Enabled, (63 & 32) != 0 ? 5 : 0), this.isSelfDeafened, isSelfMuted());
    }

    public String toString() {
        StringBuilder sbU = a.U("VoiceConfiguration(isSelfMuted=");
        sbU.append(this.isSelfMuted);
        sbU.append(", isSelfDeafened=");
        sbU.append(this.isSelfDeafened);
        sbU.append(", automaticVad=");
        sbU.append(this.automaticVad);
        sbU.append(", vadUseKrisp=");
        sbU.append(this.vadUseKrisp);
        sbU.append(", automaticGainControl=");
        sbU.append(this.automaticGainControl);
        sbU.append(", echoCancellation=");
        sbU.append(this.echoCancellation);
        sbU.append(", noiseProcessing=");
        sbU.append(this.noiseProcessing);
        sbU.append(", sensitivity=");
        sbU.append(this.sensitivity);
        sbU.append(", inputMode=");
        sbU.append(this.inputMode);
        sbU.append(", outputVolume=");
        sbU.append(this.outputVolume);
        sbU.append(", mutedUsers=");
        sbU.append(this.mutedUsers);
        sbU.append(", userOutputVolumes=");
        sbU.append(this.userOutputVolumes);
        sbU.append(", offScreenUsers=");
        sbU.append(this.offScreenUsers);
        sbU.append(", enableVideoHardwareScaling=");
        sbU.append(this.enableVideoHardwareScaling);
        sbU.append(", voiceParticipantsHidden=");
        return a.O(sbU, this.voiceParticipantsHidden, ")");
    }

    public /* synthetic */ StoreMediaSettings$VoiceConfiguration(boolean z2, boolean z3, boolean z4, StoreMediaSettings$VadUseKrisp storeMediaSettings$VadUseKrisp, boolean z5, boolean z6, StoreMediaSettings$NoiseProcessing storeMediaSettings$NoiseProcessing, float f, MediaEngineConnection$InputMode mediaEngineConnection$InputMode, float f2, Map map, Map map2, Map map3, boolean z7, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? true : z4, (i & 8) != 0 ? StoreMediaSettings$VadUseKrisp.Enabled : storeMediaSettings$VadUseKrisp, (i & 16) != 0 ? true : z5, (i & 32) == 0 ? z6 : true, (i & 64) != 0 ? StoreMediaSettings$NoiseProcessing.Cancellation : storeMediaSettings$NoiseProcessing, (i & 128) != 0 ? -50.0f : f, (i & 256) != 0 ? MediaEngineConnection$InputMode.VOICE_ACTIVITY : mediaEngineConnection$InputMode, (i & 512) != 0 ? 100.0f : f2, (i & 1024) != 0 ? h0.emptyMap() : map, (i & 2048) != 0 ? h0.emptyMap() : map2, (i & 4096) != 0 ? h0.emptyMap() : map3, (i & 8192) != 0 ? false : z7, (i & 16384) == 0 ? z8 : false);
    }
}
