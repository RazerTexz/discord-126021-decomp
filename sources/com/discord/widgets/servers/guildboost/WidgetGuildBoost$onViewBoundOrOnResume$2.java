package com.discord.widgets.servers.guildboost;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildBoost$onViewBoundOrOnResume$2 extends k implements Function1<GuildBoostViewModel$Event, Unit> {
    public WidgetGuildBoost$onViewBoundOrOnResume$2(WidgetGuildBoost widgetGuildBoost) {
        super(1, widgetGuildBoost, WidgetGuildBoost.class, "handleEvent", "handleEvent(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildBoostViewModel$Event guildBoostViewModel$Event) {
        invoke2(guildBoostViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildBoostViewModel$Event guildBoostViewModel$Event) {
        m.checkNotNullParameter(guildBoostViewModel$Event, "p1");
        WidgetGuildBoost.access$handleEvent((WidgetGuildBoost) this.receiver, guildBoostViewModel$Event);
    }
}
