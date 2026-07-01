package com.discord.widgets.nux;

import androidx.core.app.NotificationCompat;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt$onViewBound$3<R> implements Func0<Boolean> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetNuxChannelPrompt this$0;

    public WidgetNuxChannelPrompt$onViewBound$3(WidgetNuxChannelPrompt widgetNuxChannelPrompt, long j) {
        this.this$0 = widgetNuxChannelPrompt;
        this.$guildId = j;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        WidgetNuxChannelPrompt.access$finishActivity(this.this$0, this.$guildId);
        return Boolean.TRUE;
    }
}
