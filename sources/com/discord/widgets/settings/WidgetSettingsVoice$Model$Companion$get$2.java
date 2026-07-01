package com.discord.widgets.settings;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.stores.StoreMediaSettings;
import com.discord.widgets.settings.WidgetSettingsVoice;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsVoice$Model$Companion$get$2 extends FunctionReferenceImpl implements Function3<StoreMediaSettings.VoiceConfiguration, MediaEngine.OpenSLESConfig, MediaEngine.LocalVoiceStatus, WidgetSettingsVoice.Model> {
    public static final WidgetSettingsVoice$Model$Companion$get$2 INSTANCE = new WidgetSettingsVoice$Model$Companion$get$2();

    public WidgetSettingsVoice$Model$Companion$get$2() {
        super(3, WidgetSettingsVoice.Model.class, "<init>", "<init>(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Lcom/discord/rtcconnection/mediaengine/MediaEngine$OpenSLESConfig;Lcom/discord/rtcconnection/mediaengine/MediaEngine$LocalVoiceStatus;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final WidgetSettingsVoice.Model invoke(StoreMediaSettings.VoiceConfiguration voiceConfiguration, MediaEngine.OpenSLESConfig openSLESConfig, MediaEngine.LocalVoiceStatus localVoiceStatus) {
        Intrinsics3.checkNotNullParameter(voiceConfiguration, "p1");
        Intrinsics3.checkNotNullParameter(openSLESConfig, "p2");
        Intrinsics3.checkNotNullParameter(localVoiceStatus, "p3");
        return new WidgetSettingsVoice.Model(voiceConfiguration, openSLESConfig, localVoiceStatus, null);
    }
}
