package com.discord.widgets.servers.guildboost;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildBoost$onViewBoundOrOnResume$1 extends k implements Function1<GuildBoostViewModel$ViewState, Unit> {
    public WidgetGuildBoost$onViewBoundOrOnResume$1(WidgetGuildBoost widgetGuildBoost) {
        super(1, widgetGuildBoost, WidgetGuildBoost.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildBoostViewModel$ViewState guildBoostViewModel$ViewState) {
        invoke2(guildBoostViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildBoostViewModel$ViewState guildBoostViewModel$ViewState) {
        m.checkNotNullParameter(guildBoostViewModel$ViewState, "p1");
        WidgetGuildBoost.access$configureUI((WidgetGuildBoost) this.receiver, guildBoostViewModel$ViewState);
    }
}
