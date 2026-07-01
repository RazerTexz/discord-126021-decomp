package com.discord.widgets.hubs.events;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubEventsPage$onResume$1 extends k implements Function1<WidgetHubEventsState, Unit> {
    public WidgetHubEventsPage$onResume$1(WidgetHubEventsPage widgetHubEventsPage) {
        super(1, widgetHubEventsPage, WidgetHubEventsPage.class, "configUI", "configUI(Lcom/discord/widgets/hubs/events/WidgetHubEventsState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetHubEventsState widgetHubEventsState) {
        invoke2(widgetHubEventsState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetHubEventsState widgetHubEventsState) {
        m.checkNotNullParameter(widgetHubEventsState, "p1");
        WidgetHubEventsPage.access$configUI((WidgetHubEventsPage) this.receiver, widgetHubEventsState);
    }
}
