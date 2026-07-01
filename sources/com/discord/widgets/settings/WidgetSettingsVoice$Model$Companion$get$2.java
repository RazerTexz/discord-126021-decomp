package com.discord.widgets.settings;

import com.discord.rtcconnection.mediaengine.MediaEngine$LocalVoiceStatus;
import com.discord.rtcconnection.mediaengine.MediaEngine$OpenSLESConfig;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsVoice$Model$Companion$get$2 extends k implements Function3<StoreMediaSettings$VoiceConfiguration, MediaEngine$OpenSLESConfig, MediaEngine$LocalVoiceStatus, WidgetSettingsVoice$Model> {
    public static final WidgetSettingsVoice$Model$Companion$get$2 INSTANCE = new WidgetSettingsVoice$Model$Companion$get$2();

    public WidgetSettingsVoice$Model$Companion$get$2() {
        super(3, WidgetSettingsVoice$Model.class, "<init>", "<init>(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Lcom/discord/rtcconnection/mediaengine/MediaEngine$OpenSLESConfig;Lcom/discord/rtcconnection/mediaengine/MediaEngine$LocalVoiceStatus;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ WidgetSettingsVoice$Model invoke(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, MediaEngine$OpenSLESConfig mediaEngine$OpenSLESConfig, MediaEngine$LocalVoiceStatus mediaEngine$LocalVoiceStatus) {
        return invoke2(storeMediaSettings$VoiceConfiguration, mediaEngine$OpenSLESConfig, mediaEngine$LocalVoiceStatus);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsVoice$Model invoke2(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, MediaEngine$OpenSLESConfig mediaEngine$OpenSLESConfig, MediaEngine$LocalVoiceStatus mediaEngine$LocalVoiceStatus) {
        m.checkNotNullParameter(storeMediaSettings$VoiceConfiguration, "p1");
        m.checkNotNullParameter(mediaEngine$OpenSLESConfig, "p2");
        m.checkNotNullParameter(mediaEngine$LocalVoiceStatus, "p3");
        return new WidgetSettingsVoice$Model(storeMediaSettings$VoiceConfiguration, mediaEngine$OpenSLESConfig, mediaEngine$LocalVoiceStatus, null);
    }
}
