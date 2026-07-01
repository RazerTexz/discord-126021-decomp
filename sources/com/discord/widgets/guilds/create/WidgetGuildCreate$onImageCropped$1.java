package com.discord.widgets.guilds.create;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildCreate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildCreate$onImageCropped$1<T> implements Action1<String> {
    public final /* synthetic */ WidgetGuildCreate this$0;

    public WidgetGuildCreate$onImageCropped$1(WidgetGuildCreate widgetGuildCreate) {
        this.this$0 = widgetGuildCreate;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        WidgetGuildCreate.access$getViewModel$p(this.this$0).updateGuildIconUri(str);
    }
}
