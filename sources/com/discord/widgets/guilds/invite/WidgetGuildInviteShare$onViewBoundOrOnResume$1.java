package com.discord.widgets.guilds.invite;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInviteShare$onViewBoundOrOnResume$1 extends k implements Function1<WidgetGuildInviteShareViewModel$ViewState$Loaded, Unit> {
    public WidgetGuildInviteShare$onViewBoundOrOnResume$1(WidgetGuildInviteShare widgetGuildInviteShare) {
        super(1, widgetGuildInviteShare, WidgetGuildInviteShare.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded) {
        invoke2(widgetGuildInviteShareViewModel$ViewState$Loaded);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded) {
        m.checkNotNullParameter(widgetGuildInviteShareViewModel$ViewState$Loaded, "p1");
        WidgetGuildInviteShare.access$configureUI((WidgetGuildInviteShare) this.receiver, widgetGuildInviteShareViewModel$ViewState$Loaded);
    }
}
