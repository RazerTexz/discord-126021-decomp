package com.discord.widgets.nux;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt$handleSubmit$1$3<T> implements Action1<Error> {
    public final /* synthetic */ WidgetNuxChannelPrompt$handleSubmit$1 this$0;

    public WidgetNuxChannelPrompt$handleSubmit$1$3(WidgetNuxChannelPrompt$handleSubmit$1 widgetNuxChannelPrompt$handleSubmit$1) {
        this.this$0 = widgetNuxChannelPrompt$handleSubmit$1;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Error error) {
        call2(error);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Error error) {
        WidgetNuxChannelPrompt widgetNuxChannelPrompt = this.this$0.this$0;
        m.checkNotNullExpressionValue(error, "error");
        widgetNuxChannelPrompt.handleError(error);
    }
}
