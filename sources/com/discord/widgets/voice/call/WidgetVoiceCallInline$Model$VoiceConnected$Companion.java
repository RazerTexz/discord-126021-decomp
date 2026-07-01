package com.discord.widgets.voice.call;

import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInline$Model$VoiceConnected$Companion {
    private WidgetVoiceCallInline$Model$VoiceConnected$Companion() {
    }

    public final Observable<WidgetVoiceCallInline$Model$VoiceConnected> get() {
        Observable<R> observableY = StoreStream.Companion.getVoiceChannelSelected().observeSelectedChannel().Y(WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
        return ObservableExtensionsKt.computationLatest(observableY);
    }

    public /* synthetic */ WidgetVoiceCallInline$Model$VoiceConnected$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
