package com.discord.widgets.user;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSetCustomStatus$onViewBoundOrOnResume$2 extends k implements Function1<WidgetUserSetCustomStatusViewModel$Event, Unit> {
    public WidgetUserSetCustomStatus$onViewBoundOrOnResume$2(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
        super(1, widgetUserSetCustomStatus, WidgetUserSetCustomStatus.class, "handleEvent", "handleEvent(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSetCustomStatusViewModel$Event widgetUserSetCustomStatusViewModel$Event) {
        invoke2(widgetUserSetCustomStatusViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserSetCustomStatusViewModel$Event widgetUserSetCustomStatusViewModel$Event) {
        m.checkNotNullParameter(widgetUserSetCustomStatusViewModel$Event, "p1");
        WidgetUserSetCustomStatus.access$handleEvent((WidgetUserSetCustomStatus) this.receiver, widgetUserSetCustomStatusViewModel$Event);
    }
}
