package com.discord.widgets.home;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$onViewBoundOrOnResume$2 extends o implements Function1<WidgetHomeViewModel$Event, Unit> {
    public final /* synthetic */ WidgetHome this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHome$onViewBoundOrOnResume$2(WidgetHome widgetHome) {
        super(1);
        this.this$0 = widgetHome;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeViewModel$Event widgetHomeViewModel$Event) {
        invoke2(widgetHomeViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetHomeViewModel$Event widgetHomeViewModel$Event) {
        m.checkNotNullParameter(widgetHomeViewModel$Event, "event");
        WidgetHome.access$handleEvent(this.this$0, widgetHomeViewModel$Event);
    }
}
