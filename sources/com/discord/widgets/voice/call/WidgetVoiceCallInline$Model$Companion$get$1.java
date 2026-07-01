package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInline$Model$Companion$get$1<T, R> implements b<WidgetVoiceCallInline$Model$VoiceConnected, WidgetVoiceCallInline$Model> {
    public static final WidgetVoiceCallInline$Model$Companion$get$1 INSTANCE = new WidgetVoiceCallInline$Model$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetVoiceCallInline$Model call(WidgetVoiceCallInline$Model$VoiceConnected widgetVoiceCallInline$Model$VoiceConnected) {
        return call2(widgetVoiceCallInline$Model$VoiceConnected);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetVoiceCallInline$Model call2(WidgetVoiceCallInline$Model$VoiceConnected widgetVoiceCallInline$Model$VoiceConnected) {
        return new WidgetVoiceCallInline$Model(widgetVoiceCallInline$Model$VoiceConnected);
    }
}
