package org.webrtc.audio;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.NoiseSuppressor;
import androidx.annotation.Nullable;
import java.util.UUID;
import org.webrtc.Logging;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public class WebRtcAudioEffects {
    private static final UUID AOSP_ACOUSTIC_ECHO_CANCELER = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
    private static final UUID AOSP_NOISE_SUPPRESSOR = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
    private static final boolean DEBUG = false;
    private static final String TAG = "WebRtcAudioEffectsExternal";

    @Nullable
    private static AudioEffect.Descriptor[] cachedEffects;

    @Nullable
    private AcousticEchoCanceler aec;

    /* JADX INFO: renamed from: ns */
    @Nullable
    private NoiseSuppressor f27621ns;
    private boolean shouldEnableAec;
    private boolean shouldEnableNs;

    public WebRtcAudioEffects() {
        StringBuilder sbM833U = C1643a.m833U("ctor");
        sbM833U.append(WebRtcAudioUtils.getThreadInfo());
        Logging.m11027d(TAG, sbM833U.toString());
    }

    private static void assertTrue(boolean z2) {
        if (!z2) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private boolean effectTypeIsVoIP(UUID uuid) {
        return (AudioEffect.EFFECT_TYPE_AEC.equals(uuid) && isAcousticEchoCancelerSupported()) || (AudioEffect.EFFECT_TYPE_NS.equals(uuid) && isNoiseSuppressorSupported());
    }

    @Nullable
    private static AudioEffect.Descriptor[] getAvailableEffects() {
        AudioEffect.Descriptor[] descriptorArr = cachedEffects;
        if (descriptorArr != null) {
            return descriptorArr;
        }
        AudioEffect.Descriptor[] descriptorArrQueryEffects = AudioEffect.queryEffects();
        cachedEffects = descriptorArrQueryEffects;
        return descriptorArrQueryEffects;
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC, AOSP_ACOUSTIC_ECHO_CANCELER);
    }

    private static boolean isEffectTypeAvailable(UUID uuid, UUID uuid2) {
        AudioEffect.Descriptor[] availableEffects = getAvailableEffects();
        if (availableEffects == null) {
            return false;
        }
        for (AudioEffect.Descriptor descriptor : availableEffects) {
            if (descriptor.type.equals(uuid)) {
                return !descriptor.uuid.equals(uuid2);
            }
        }
        return false;
    }

    public static boolean isNoiseSuppressorSupported() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS, AOSP_NOISE_SUPPRESSOR);
    }

    public void enable(int i) {
        Logging.m11027d(TAG, "enable(audioSession=" + i + ")");
        assertTrue(this.aec == null);
        assertTrue(this.f27621ns == null);
        if (isAcousticEchoCancelerSupported()) {
            AcousticEchoCanceler acousticEchoCancelerCreate = AcousticEchoCanceler.create(i);
            this.aec = acousticEchoCancelerCreate;
            if (acousticEchoCancelerCreate != null) {
                boolean enabled = acousticEchoCancelerCreate.getEnabled();
                boolean z2 = this.shouldEnableAec && isAcousticEchoCancelerSupported();
                if (this.aec.setEnabled(z2) != 0) {
                    Logging.m11028e(TAG, "Failed to set the AcousticEchoCanceler state");
                }
                StringBuilder sbM833U = C1643a.m833U("AcousticEchoCanceler: was ");
                sbM833U.append(enabled ? "enabled" : "disabled");
                sbM833U.append(", enable: ");
                sbM833U.append(z2);
                sbM833U.append(", is now: ");
                sbM833U.append(this.aec.getEnabled() ? "enabled" : "disabled");
                Logging.m11027d(TAG, sbM833U.toString());
            } else {
                Logging.m11028e(TAG, "Failed to create the AcousticEchoCanceler instance");
            }
        }
        if (isNoiseSuppressorSupported()) {
            NoiseSuppressor noiseSuppressorCreate = NoiseSuppressor.create(i);
            this.f27621ns = noiseSuppressorCreate;
            if (noiseSuppressorCreate == null) {
                Logging.m11028e(TAG, "Failed to create the NoiseSuppressor instance");
                return;
            }
            boolean enabled2 = noiseSuppressorCreate.getEnabled();
            boolean z3 = this.shouldEnableNs && isNoiseSuppressorSupported();
            if (this.f27621ns.setEnabled(z3) != 0) {
                Logging.m11028e(TAG, "Failed to set the NoiseSuppressor state");
            }
            StringBuilder sbM833U2 = C1643a.m833U("NoiseSuppressor: was ");
            sbM833U2.append(enabled2 ? "enabled" : "disabled");
            sbM833U2.append(", enable: ");
            sbM833U2.append(z3);
            sbM833U2.append(", is now: ");
            sbM833U2.append(this.f27621ns.getEnabled() ? "enabled" : "disabled");
            Logging.m11027d(TAG, sbM833U2.toString());
        }
    }

    public void release() {
        Logging.m11027d(TAG, "release");
        AcousticEchoCanceler acousticEchoCanceler = this.aec;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.release();
            this.aec = null;
        }
        NoiseSuppressor noiseSuppressor = this.f27621ns;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
            this.f27621ns = null;
        }
    }

    public boolean setAEC(boolean z2) {
        Logging.m11027d(TAG, "setAEC(" + z2 + ")");
        if (!isAcousticEchoCancelerSupported()) {
            Logging.m11031w(TAG, "Platform AEC is not supported");
            this.shouldEnableAec = false;
            return false;
        }
        if (this.aec == null || z2 == this.shouldEnableAec) {
            this.shouldEnableAec = z2;
            return true;
        }
        Logging.m11028e(TAG, "Platform AEC state can't be modified while recording");
        return false;
    }

    public boolean setNS(boolean z2) {
        Logging.m11027d(TAG, "setNS(" + z2 + ")");
        if (!isNoiseSuppressorSupported()) {
            Logging.m11031w(TAG, "Platform NS is not supported");
            this.shouldEnableNs = false;
            return false;
        }
        if (this.f27621ns == null || z2 == this.shouldEnableNs) {
            this.shouldEnableNs = z2;
            return true;
        }
        Logging.m11028e(TAG, "Platform NS state can't be modified while recording");
        return false;
    }
}
