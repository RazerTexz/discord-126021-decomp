package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.mediaengine.MediaEngine$LocalVoiceStatus;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$Model$Companion$get$1<T, R> implements b<Boolean, Observable<? extends MediaEngine$LocalVoiceStatus>> {
    public static final WidgetSettingsVoice$Model$Companion$get$1 INSTANCE = new WidgetSettingsVoice$Model$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends MediaEngine$LocalVoiceStatus> call(Boolean bool) {
        return call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends MediaEngine$LocalVoiceStatus> call2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "isListeningForSensitivity");
        return bool.booleanValue() ? StoreStream.Companion.getMediaEngine().getLocalVoiceStatus() : new k(WidgetSettingsVoice.access$getLOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED$cp());
    }
}
