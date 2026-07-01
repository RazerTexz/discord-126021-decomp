package com.discord.widgets.hubs.events;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$listener$1$onPrimaryButtonClicked$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage7 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;
    public final /* synthetic */ WidgetHubEventsPage6 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsPage7(WidgetHubEventsPage6 widgetHubEventsPage6, WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
        super(0);
        this.this$0 = widgetHubEventsPage6;
        this.$eventData = widgetHubEventsViewModel2;
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
