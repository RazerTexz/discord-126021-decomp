package com.discord.widgets.guildscheduledevent;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventCreateSuccessViewModel$2 extends k implements Function1<WidgetGuildScheduledEventCreateSuccessViewModel$ViewState, Unit> {
    public WidgetGuildScheduledEventCreateSuccessViewModel$2(WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel) {
        super(1, widgetGuildScheduledEventCreateSuccessViewModel, WidgetGuildScheduledEventCreateSuccessViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildScheduledEventCreateSuccessViewModel$ViewState widgetGuildScheduledEventCreateSuccessViewModel$ViewState) {
        invoke2(widgetGuildScheduledEventCreateSuccessViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildScheduledEventCreateSuccessViewModel$ViewState widgetGuildScheduledEventCreateSuccessViewModel$ViewState) {
        m.checkNotNullParameter(widgetGuildScheduledEventCreateSuccessViewModel$ViewState, "p1");
        WidgetGuildScheduledEventCreateSuccessViewModel.access$updateViewState((WidgetGuildScheduledEventCreateSuccessViewModel) this.receiver, widgetGuildScheduledEventCreateSuccessViewModel$ViewState);
    }
}
