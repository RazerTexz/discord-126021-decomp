package com.discord.widgets.servers.guildboost;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildBoostConfirmation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildBoostConfirmation$onResume$1 extends k implements Function1<GuildBoostInProgressViewModel$ViewState, Unit> {
    public WidgetGuildBoostConfirmation$onResume$1(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
        super(1, widgetGuildBoostConfirmation, WidgetGuildBoostConfirmation.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostInProgressViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildBoostInProgressViewModel$ViewState guildBoostInProgressViewModel$ViewState) {
        invoke2(guildBoostInProgressViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildBoostInProgressViewModel$ViewState guildBoostInProgressViewModel$ViewState) {
        m.checkNotNullParameter(guildBoostInProgressViewModel$ViewState, "p1");
        WidgetGuildBoostConfirmation.access$configureUI((WidgetGuildBoostConfirmation) this.receiver, guildBoostInProgressViewModel$ViewState);
    }
}
