package com.discord.widgets.user;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPruneUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetPruneUsers$onViewBoundOrOnResume$2 extends k implements Function1<WidgetPruneUsersViewModel$Event, Unit> {
    public WidgetPruneUsers$onViewBoundOrOnResume$2(WidgetPruneUsers widgetPruneUsers) {
        super(1, widgetPruneUsers, WidgetPruneUsers.class, "handleEvent", "handleEvent(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetPruneUsersViewModel$Event widgetPruneUsersViewModel$Event) {
        invoke2(widgetPruneUsersViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetPruneUsersViewModel$Event widgetPruneUsersViewModel$Event) {
        m.checkNotNullParameter(widgetPruneUsersViewModel$Event, "p1");
        WidgetPruneUsers.access$handleEvent((WidgetPruneUsers) this.receiver, widgetPruneUsersViewModel$Event);
    }
}
