package com.discord.widgets.settings;

import com.discord.rtcconnection.mediaengine.MediaEngine$OpenSLESConfig;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$Model$Companion {
    private WidgetSettingsVoice$Model$Companion() {
    }

    public final Observable<WidgetSettingsVoice$Model> get(Observable<Boolean> requestListenForSensitivity) {
        m.checkNotNullParameter(requestListenForSensitivity, "requestListenForSensitivity");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableJ = Observable.j(requestListenForSensitivity, storeStream$Companion.getMediaEngine().getIsNativeEngineInitialized(), WidgetSettingsVoice$Model$Companion$get$shouldListenForSensitivity$1.INSTANCE);
        Observable<StoreMediaSettings$VoiceConfiguration> voiceConfig = storeStream$Companion.getMediaSettings().getVoiceConfig();
        Observable<MediaEngine$OpenSLESConfig> openSLESConfig = storeStream$Companion.getMediaEngine().getOpenSLESConfig();
        Observable observableY = observableJ.Y(WidgetSettingsVoice$Model$Companion$get$1.INSTANCE);
        WidgetSettingsVoice$Model$Companion$get$2 widgetSettingsVoice$Model$Companion$get$2 = WidgetSettingsVoice$Model$Companion$get$2.INSTANCE;
        Object widgetSettingsVoice$sam$rx_functions_Func3$0 = widgetSettingsVoice$Model$Companion$get$2;
        if (widgetSettingsVoice$Model$Companion$get$2 != null) {
            widgetSettingsVoice$sam$rx_functions_Func3$0 = new WidgetSettingsVoice$sam$rx_functions_Func3$0(widgetSettingsVoice$Model$Companion$get$2);
        }
        Observable observableI = Observable.i(voiceConfig, openSLESConfig, observableY, (Func3) widgetSettingsVoice$sam$rx_functions_Func3$0);
        m.checkNotNullExpressionValue(observableI, "Observable\n            .…    ::Model\n            )");
        Observable<WidgetSettingsVoice$Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetSettingsVoice$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
