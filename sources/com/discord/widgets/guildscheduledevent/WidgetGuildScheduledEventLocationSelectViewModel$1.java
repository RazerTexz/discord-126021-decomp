package com.discord.widgets.guildscheduledevent;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelectViewModel$1 extends o implements Function1<WidgetGuildScheduledEventLocationSelectViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventLocationSelectViewModel$1(WidgetGuildScheduledEventLocationSelectViewModel widgetGuildScheduledEventLocationSelectViewModel) {
        super(1);
        this.this$0 = widgetGuildScheduledEventLocationSelectViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildScheduledEventLocationSelectViewModel$StoreState widgetGuildScheduledEventLocationSelectViewModel$StoreState) {
        invoke2(widgetGuildScheduledEventLocationSelectViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildScheduledEventLocationSelectViewModel$StoreState widgetGuildScheduledEventLocationSelectViewModel$StoreState) {
        WidgetGuildScheduledEventLocationSelectViewModel widgetGuildScheduledEventLocationSelectViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetGuildScheduledEventLocationSelectViewModel$StoreState, "it");
        WidgetGuildScheduledEventLocationSelectViewModel.access$handleStoreState(widgetGuildScheduledEventLocationSelectViewModel, widgetGuildScheduledEventLocationSelectViewModel$StoreState);
    }
}
