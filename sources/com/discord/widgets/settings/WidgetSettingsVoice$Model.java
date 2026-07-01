package com.discord.widgets.settings;

import com.discord.rtcconnection.mediaengine.MediaEngine$LocalVoiceStatus;
import com.discord.rtcconnection.mediaengine.MediaEngine$OpenSLESConfig;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$Model {
    public static final WidgetSettingsVoice$Model$Companion Companion = new WidgetSettingsVoice$Model$Companion(null);
    private final MediaEngine$LocalVoiceStatus localVoiceStatus;
    private final boolean modePTT;
    private final boolean modeVAD;
    private final MediaEngine$OpenSLESConfig openSLESConfig;
    private final StoreMediaSettings$VoiceConfiguration voiceConfig;

    private WidgetSettingsVoice$Model(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, MediaEngine$OpenSLESConfig mediaEngine$OpenSLESConfig, MediaEngine$LocalVoiceStatus mediaEngine$LocalVoiceStatus) {
        this.voiceConfig = storeMediaSettings$VoiceConfiguration;
        this.openSLESConfig = mediaEngine$OpenSLESConfig;
        this.localVoiceStatus = mediaEngine$LocalVoiceStatus;
        this.modePTT = storeMediaSettings$VoiceConfiguration.getInputMode() == MediaEngineConnection$InputMode.PUSH_TO_TALK;
        this.modeVAD = storeMediaSettings$VoiceConfiguration.getInputMode() == MediaEngineConnection$InputMode.VOICE_ACTIVITY;
    }

    public final MediaEngine$LocalVoiceStatus getLocalVoiceStatus() {
        return this.localVoiceStatus;
    }

    public final boolean getModePTT() {
        return this.modePTT;
    }

    public final boolean getModeVAD() {
        return this.modeVAD;
    }

    public final MediaEngine$OpenSLESConfig getOpenSLESConfig() {
        return this.openSLESConfig;
    }

    public final StoreMediaSettings$VoiceConfiguration getVoiceConfig() {
        return this.voiceConfig;
    }

    public /* synthetic */ WidgetSettingsVoice$Model(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, MediaEngine$OpenSLESConfig mediaEngine$OpenSLESConfig, MediaEngine$LocalVoiceStatus mediaEngine$LocalVoiceStatus, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeMediaSettings$VoiceConfiguration, mediaEngine$OpenSLESConfig, mediaEngine$LocalVoiceStatus);
    }
}
