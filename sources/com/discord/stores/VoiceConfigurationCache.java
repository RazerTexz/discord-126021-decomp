package com.discord.stores;

import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode$a;
import com.discord.utilities.cache.SharedPreferenceExtensionsKt;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: VoiceConfigurationCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceConfigurationCache {
    private final SharedPreferences sharedPreferences;

    public VoiceConfigurationCache(SharedPreferences sharedPreferences) {
        m.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.sharedPreferences = sharedPreferences;
    }

    private final boolean booleanFromVadUseKrisp(StoreMediaSettings$VadUseKrisp value) {
        return value != StoreMediaSettings$VadUseKrisp.Disabled;
    }

    private final int intFromNoiseProcessing(StoreMediaSettings$NoiseProcessing value) {
        return value == StoreMediaSettings$NoiseProcessing.CancellationTemporarilyDisabled ? StoreMediaSettings$NoiseProcessing.Cancellation.ordinal() : value.ordinal();
    }

    private final StoreMediaSettings$NoiseProcessing readNoiseProcessing() {
        try {
            return StoreMediaSettings$NoiseProcessing.values()[this.sharedPreferences.getInt("CACHE_KEY_VOICE_SETTINGS_NOISE_PROCESSING", StoreMediaSettings$VoiceConfiguration.Companion.getDEFAULT_NOISE_PROCESSING())];
        } catch (Exception unused) {
            return StoreMediaSettings$NoiseProcessing.Cancellation;
        }
    }

    private final StoreMediaSettings$VadUseKrisp readVadUseKrisp() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        StoreMediaSettings$VadUseKrisp vadUseKrisp = StoreMediaSettings$VoiceConfiguration.Companion.getDEFAULT_VOICE_CONFIG().getVadUseKrisp();
        StoreMediaSettings$VadUseKrisp storeMediaSettings$VadUseKrisp = StoreMediaSettings$VadUseKrisp.Enabled;
        return sharedPreferences.getBoolean("CACHE_KEY_VOICE_SETTINGS_VAD_USE_KRISP", vadUseKrisp == storeMediaSettings$VadUseKrisp) ? storeMediaSettings$VadUseKrisp : StoreMediaSettings$VadUseKrisp.Disabled;
    }

    public final StoreMediaSettings$VoiceConfiguration read() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        StoreMediaSettings$VoiceConfiguration$Companion storeMediaSettings$VoiceConfiguration$Companion = StoreMediaSettings$VoiceConfiguration.Companion;
        boolean z2 = sharedPreferences.getBoolean("CACHE_KEY_VOICE_SETTINGS_IS_MUTED", storeMediaSettings$VoiceConfiguration$Companion.getDEFAULT_VOICE_CONFIG().isSelfMuted());
        boolean z3 = this.sharedPreferences.getBoolean("CACHE_KEY_VOICE_SETTINGS_IS_DEAFENED", storeMediaSettings$VoiceConfiguration$Companion.getDEFAULT_VOICE_CONFIG().isSelfDeafened());
        boolean z4 = this.sharedPreferences.getBoolean("CACHE_KEY_VOICE_SETTINGS_AUTOMATIC_VAD", storeMediaSettings$VoiceConfiguration$Companion.getDEFAULT_VOICE_CONFIG().getAutomaticVad());
        StoreMediaSettings$VadUseKrisp vadUseKrisp = readVadUseKrisp();
        boolean z5 = this.sharedPreferences.getBoolean("CACHE_KEY_VOICE_SETTINGS_AUTOMATIC_GAIN_CONTROL", storeMediaSettings$VoiceConfiguration$Companion.getDEFAULT_VOICE_CONFIG().getAutomaticGainControl());
        boolean z6 = this.sharedPreferences.getBoolean("CACHE_KEY_VOICE_SETTINGS_ECHO_CANCELLATION", storeMediaSettings$VoiceConfiguration$Companion.getDEFAULT_VOICE_CONFIG().getEchoCancellation());
        StoreMediaSettings$NoiseProcessing noiseProcessing = readNoiseProcessing();
        float f = this.sharedPreferences.getFloat("CACHE_KEY_VOICE_SETTINGS_SENSITIVITY", storeMediaSettings$VoiceConfiguration$Companion.getDEFAULT_VOICE_CONFIG().getSensitivity());
        MediaEngineConnection$InputMode$a mediaEngineConnection$InputMode$a = MediaEngineConnection$InputMode.Companion;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        MediaEngineConnection$InputMode mediaEngineConnection$InputMode = MediaEngineConnection$InputMode.VOICE_ACTIVITY;
        int i = sharedPreferences2.getInt("CACHE_KEY_VOICE_SETTINGS_INPUT_MODE", mediaEngineConnection$InputMode.getNumeral());
        Objects.requireNonNull(mediaEngineConnection$InputMode$a);
        return new StoreMediaSettings$VoiceConfiguration(z2, z3, z4, vadUseKrisp, z5, z6, noiseProcessing, f, (i == 1 || i != 2) ? mediaEngineConnection$InputMode : MediaEngineConnection$InputMode.PUSH_TO_TALK, this.sharedPreferences.getFloat("CACHE_KEY_VOICE_SETTINGS_OUTPUT_VOLUME", storeMediaSettings$VoiceConfiguration$Companion.getDEFAULT_VOICE_CONFIG().getOutputVolume()), SharedPreferenceExtensionsKt.getStringEntrySetAsMap$default(this.sharedPreferences, "MUTED_USERS_V2", null, VoiceConfigurationCache$read$1.INSTANCE, 2, null), SharedPreferenceExtensionsKt.getStringEntrySetAsMap$default(this.sharedPreferences, "USER_OUTPUT_VOLUMES_V2", null, VoiceConfigurationCache$read$2.INSTANCE, 2, null), null, this.sharedPreferences.getBoolean("VIDEO_ENABLE_HARDWARE_SCALING", storeMediaSettings$VoiceConfiguration$Companion.getDEFAULT_VOICE_CONFIG().getEnableVideoHardwareScaling()), this.sharedPreferences.getBoolean("CACHE_KEY_HIDE_VOICE_PARTICIPANTS", storeMediaSettings$VoiceConfiguration$Companion.getDEFAULT_VOICE_CONFIG().getVoiceParticipantsHidden()), 4096, null);
    }

    public final void write(StoreMediaSettings$VoiceConfiguration voiceConfiguration) {
        m.checkNotNullParameter(voiceConfiguration, "voiceConfiguration");
        SharedPreferences$Editor sharedPreferences$EditorEdit = this.sharedPreferences.edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putBoolean("CACHE_KEY_VOICE_SETTINGS_IS_MUTED", voiceConfiguration.isSelfMuted());
        sharedPreferences$EditorEdit.putBoolean("CACHE_KEY_VOICE_SETTINGS_IS_DEAFENED", voiceConfiguration.isSelfDeafened());
        sharedPreferences$EditorEdit.putBoolean("CACHE_KEY_VOICE_SETTINGS_AUTOMATIC_VAD", voiceConfiguration.getAutomaticVad());
        sharedPreferences$EditorEdit.putBoolean("CACHE_KEY_VOICE_SETTINGS_VAD_USE_KRISP", booleanFromVadUseKrisp(voiceConfiguration.getVadUseKrisp()));
        sharedPreferences$EditorEdit.putBoolean("CACHE_KEY_VOICE_SETTINGS_AUTOMATIC_GAIN_CONTROL", voiceConfiguration.getAutomaticGainControl());
        sharedPreferences$EditorEdit.putInt("CACHE_KEY_VOICE_SETTINGS_NOISE_PROCESSING", intFromNoiseProcessing(voiceConfiguration.getNoiseProcessing()));
        sharedPreferences$EditorEdit.putBoolean("CACHE_KEY_VOICE_SETTINGS_ECHO_CANCELLATION", voiceConfiguration.getEchoCancellation());
        sharedPreferences$EditorEdit.putFloat("CACHE_KEY_VOICE_SETTINGS_SENSITIVITY", voiceConfiguration.getSensitivity());
        sharedPreferences$EditorEdit.putInt("CACHE_KEY_VOICE_SETTINGS_INPUT_MODE", voiceConfiguration.getInputMode().getNumeral());
        sharedPreferences$EditorEdit.putFloat("CACHE_KEY_VOICE_SETTINGS_OUTPUT_VOLUME", voiceConfiguration.getOutputVolume());
        SharedPreferenceExtensionsKt.putStringEntrySetAsMap$default(sharedPreferences$EditorEdit, "MUTED_USERS_V2", voiceConfiguration.getMutedUsers(), null, null, 12, null);
        SharedPreferenceExtensionsKt.putStringEntrySetAsMap$default(sharedPreferences$EditorEdit, "USER_OUTPUT_VOLUMES_V2", voiceConfiguration.getUserOutputVolumes(), null, null, 12, null);
        sharedPreferences$EditorEdit.putBoolean("VIDEO_ENABLE_HARDWARE_SCALING", voiceConfiguration.getEnableVideoHardwareScaling());
        sharedPreferences$EditorEdit.putBoolean("CACHE_KEY_HIDE_VOICE_PARTICIPANTS", voiceConfiguration.getVoiceParticipantsHidden());
        sharedPreferences$EditorEdit.apply();
    }
}
