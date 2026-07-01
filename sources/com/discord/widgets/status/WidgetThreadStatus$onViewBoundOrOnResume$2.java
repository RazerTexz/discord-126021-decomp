package com.discord.widgets.status;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadStatus$onViewBoundOrOnResume$2 extends k implements Function1<WidgetThreadStatus$Event, Unit> {
    public WidgetThreadStatus$onViewBoundOrOnResume$2(WidgetThreadStatus widgetThreadStatus) {
        super(1, widgetThreadStatus, WidgetThreadStatus.class, "handleEvent", "handleEvent(Lcom/discord/widgets/status/WidgetThreadStatus$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadStatus$Event widgetThreadStatus$Event) {
        invoke2(widgetThreadStatus$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadStatus$Event widgetThreadStatus$Event) {
        m.checkNotNullParameter(widgetThreadStatus$Event, "p1");
        WidgetThreadStatus.access$handleEvent((WidgetThreadStatus) this.receiver, widgetThreadStatus$Event);
    }
}
