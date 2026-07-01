package com.discord.widgets.servers.guildboost;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildBoostTransfer$onViewBoundOrOnResume$1 extends k implements Function1<GuildBoostTransferInProgressViewModel$ViewState, Unit> {
    public WidgetGuildBoostTransfer$onViewBoundOrOnResume$1(WidgetGuildBoostTransfer widgetGuildBoostTransfer) {
        super(1, widgetGuildBoostTransfer, WidgetGuildBoostTransfer.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildBoostTransferInProgressViewModel$ViewState guildBoostTransferInProgressViewModel$ViewState) {
        invoke2(guildBoostTransferInProgressViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildBoostTransferInProgressViewModel$ViewState guildBoostTransferInProgressViewModel$ViewState) {
        m.checkNotNullParameter(guildBoostTransferInProgressViewModel$ViewState, "p1");
        WidgetGuildBoostTransfer.access$configureUI((WidgetGuildBoostTransfer) this.receiver, guildBoostTransferInProgressViewModel$ViewState);
    }
}
