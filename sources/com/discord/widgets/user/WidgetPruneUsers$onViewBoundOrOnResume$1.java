package com.discord.widgets.user;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPruneUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetPruneUsers$onViewBoundOrOnResume$1 extends k implements Function1<WidgetPruneUsersViewModel$ViewState, Unit> {
    public WidgetPruneUsers$onViewBoundOrOnResume$1(WidgetPruneUsers widgetPruneUsers) {
        super(1, widgetPruneUsers, WidgetPruneUsers.class, "updateUI", "updateUI(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetPruneUsersViewModel$ViewState widgetPruneUsersViewModel$ViewState) {
        invoke2(widgetPruneUsersViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetPruneUsersViewModel$ViewState widgetPruneUsersViewModel$ViewState) {
        m.checkNotNullParameter(widgetPruneUsersViewModel$ViewState, "p1");
        WidgetPruneUsers.access$updateUI((WidgetPruneUsers) this.receiver, widgetPruneUsersViewModel$ViewState);
    }
}
