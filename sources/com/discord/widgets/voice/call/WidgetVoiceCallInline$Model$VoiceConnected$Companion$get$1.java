package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.stores.StoreStream;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1<T, R> implements b<Channel, Observable<? extends WidgetVoiceCallInline$Model$VoiceConnected>> {
    public static final WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1 INSTANCE = new WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1();

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceCallInline$Model$VoiceConnected> call2(Channel channel) {
        Object widgetVoiceCallInline$sam$rx_functions_Func3$0;
        if (channel == null) {
            return new k(null);
        }
        k kVar = new k(channel);
        Observable<MediaEngineConnection$InputMode> inputMode = StoreStream.Companion.getMediaSettings().getInputMode();
        Observable<StreamContext> forActiveStream = new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForActiveStream();
        WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1 widgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1 = WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1.INSTANCE;
        if (widgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1 != null) {
            widgetVoiceCallInline$sam$rx_functions_Func3$0 = widgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1;
            widgetVoiceCallInline$sam$rx_functions_Func3$0 = new WidgetVoiceCallInline$sam$rx_functions_Func3$0(widgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1);
        }
        widgetVoiceCallInline$sam$rx_functions_Func3$0 = widgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1;
        return Observable.i(kVar, inputMode, forActiveStream, (Func3) widgetVoiceCallInline$sam$rx_functions_Func3$0);
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceCallInline$Model$VoiceConnected> call(Channel channel) {
        return call2(channel);
    }
}
