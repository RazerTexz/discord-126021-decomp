package com.discord.widgets.voice.call;

import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInline$Model$Companion {
    private WidgetVoiceCallInline$Model$Companion() {
    }

    public final Observable<WidgetVoiceCallInline$Model> get() {
        Observable observableG = WidgetVoiceCallInline$Model$VoiceConnected.Companion.get().G(WidgetVoiceCallInline$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "VoiceConnected\n         …eConnected)\n            }");
        return observableG;
    }

    public /* synthetic */ WidgetVoiceCallInline$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
