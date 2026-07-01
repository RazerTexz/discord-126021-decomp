package com.discord.widgets.guildscheduledevent;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess$onResume$1 extends o implements Function1<WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded, Unit> {
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccess this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccess$onResume$1(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        super(1);
        this.this$0 = widgetGuildScheduledEventCreateSuccess;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded) {
        invoke2(widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded) {
        m.checkNotNullParameter(widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded, "viewState");
        WidgetGuildScheduledEventCreateSuccess.access$configureUI(this.this$0, widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded);
    }
}
