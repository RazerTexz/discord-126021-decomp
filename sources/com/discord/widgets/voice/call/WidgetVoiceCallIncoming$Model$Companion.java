package com.discord.widgets.voice.call;

import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallIncoming$Model$Companion {
    private WidgetVoiceCallIncoming$Model$Companion() {
    }

    public final Observable<WidgetVoiceCallIncoming$Model> get() {
        Observable<R> observableY = StoreStream.Companion.getCallsIncoming().observeIncoming().Y(WidgetVoiceCallIncoming$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
        Observable<WidgetVoiceCallIncoming$Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetVoiceCallIncoming$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
