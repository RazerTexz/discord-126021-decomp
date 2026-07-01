package com.discord.widgets.guildscheduledevent;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccessViewModel$1<T> implements Action1<WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded> {
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel this$0;

    public WidgetGuildScheduledEventCreateSuccessViewModel$1(WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel) {
        this.this$0 = widgetGuildScheduledEventCreateSuccessViewModel;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded) {
        call2(widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded) {
        WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded, "viewState");
        WidgetGuildScheduledEventCreateSuccessViewModel.access$generateInviteLinkFromViewState(widgetGuildScheduledEventCreateSuccessViewModel, widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded);
    }
}
