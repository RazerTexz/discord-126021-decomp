package com.discord.widgets.guildscheduledevent;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventLocationSelect$onResume$1 extends k implements Function1<WidgetGuildScheduledEventLocationSelectViewModel$ViewState, Unit> {
    public WidgetGuildScheduledEventLocationSelect$onResume$1(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        super(1, widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelect.class, "configureUI", "configureUI(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildScheduledEventLocationSelectViewModel$ViewState widgetGuildScheduledEventLocationSelectViewModel$ViewState) {
        invoke2(widgetGuildScheduledEventLocationSelectViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildScheduledEventLocationSelectViewModel$ViewState widgetGuildScheduledEventLocationSelectViewModel$ViewState) {
        m.checkNotNullParameter(widgetGuildScheduledEventLocationSelectViewModel$ViewState, "p1");
        WidgetGuildScheduledEventLocationSelect.access$configureUI((WidgetGuildScheduledEventLocationSelect) this.receiver, widgetGuildScheduledEventLocationSelectViewModel$ViewState);
    }
}
