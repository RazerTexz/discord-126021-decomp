package com.discord.widgets.hubs.events;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage$listener$1$onPrimaryButtonClicked$1 extends o implements Function0<Unit> {
    public final /* synthetic */ HubGuildScheduledEventData $eventData;
    public final /* synthetic */ WidgetHubEventsPage$listener$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsPage$listener$1$onPrimaryButtonClicked$1(WidgetHubEventsPage$listener$1 widgetHubEventsPage$listener$1, HubGuildScheduledEventData hubGuildScheduledEventData) {
        super(0);
        this.this$0 = widgetHubEventsPage$listener$1;
        this.$eventData = hubGuildScheduledEventData;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.this$0.getViewModel().toggleRsvp(this.$eventData.getEvent());
    }
}
