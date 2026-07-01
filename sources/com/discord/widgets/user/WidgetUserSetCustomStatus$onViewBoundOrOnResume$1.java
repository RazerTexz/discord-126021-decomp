package com.discord.widgets.user;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSetCustomStatus$onViewBoundOrOnResume$1 extends k implements Function1<WidgetUserSetCustomStatusViewModel$ViewState, Unit> {
    public WidgetUserSetCustomStatus$onViewBoundOrOnResume$1(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
        super(1, widgetUserSetCustomStatus, WidgetUserSetCustomStatus.class, "updateView", "updateView(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSetCustomStatusViewModel$ViewState widgetUserSetCustomStatusViewModel$ViewState) {
        invoke2(widgetUserSetCustomStatusViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserSetCustomStatusViewModel$ViewState widgetUserSetCustomStatusViewModel$ViewState) {
        m.checkNotNullParameter(widgetUserSetCustomStatusViewModel$ViewState, "p1");
        WidgetUserSetCustomStatus.access$updateView((WidgetUserSetCustomStatus) this.receiver, widgetUserSetCustomStatusViewModel$ViewState);
    }
}
