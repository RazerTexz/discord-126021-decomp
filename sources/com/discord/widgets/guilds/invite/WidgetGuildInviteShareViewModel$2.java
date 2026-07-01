package com.discord.widgets.guilds.invite;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInviteShareViewModel$2 extends k implements Function1<WidgetGuildInviteShareViewModel$ViewState, Unit> {
    public WidgetGuildInviteShareViewModel$2(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
        super(1, widgetGuildInviteShareViewModel, WidgetGuildInviteShareViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildInviteShareViewModel$ViewState widgetGuildInviteShareViewModel$ViewState) {
        invoke2(widgetGuildInviteShareViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildInviteShareViewModel$ViewState widgetGuildInviteShareViewModel$ViewState) {
        m.checkNotNullParameter(widgetGuildInviteShareViewModel$ViewState, "p1");
        WidgetGuildInviteShareViewModel.access$updateViewState((WidgetGuildInviteShareViewModel) this.receiver, widgetGuildInviteShareViewModel$ViewState);
    }
}
