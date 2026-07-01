package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallIncoming$configureUI$1<R> implements Func0<Boolean> {
    public final /* synthetic */ WidgetVoiceCallIncoming$Model $model;
    public final /* synthetic */ WidgetVoiceCallIncoming this$0;

    public WidgetVoiceCallIncoming$configureUI$1(WidgetVoiceCallIncoming widgetVoiceCallIncoming, WidgetVoiceCallIncoming$Model widgetVoiceCallIncoming$Model) {
        this.this$0 = widgetVoiceCallIncoming;
        this.$model = widgetVoiceCallIncoming$Model;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        this.this$0.onDecline(this.$model.getChannelId());
        return Boolean.TRUE;
    }
}
