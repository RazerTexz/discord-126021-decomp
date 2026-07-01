package com.discord.widgets.guildscheduledevent;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventListBottomSheet$onResume$1 extends k implements Function1<GuildScheduledEventListViewModel$ViewState, Unit> {
    public WidgetGuildScheduledEventListBottomSheet$onResume$1(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListViewModel$ViewState guildScheduledEventListViewModel$ViewState) {
        invoke2(guildScheduledEventListViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEventListViewModel$ViewState guildScheduledEventListViewModel$ViewState) {
        m.checkNotNullParameter(guildScheduledEventListViewModel$ViewState, "p1");
        WidgetGuildScheduledEventListBottomSheet.access$configureUi((WidgetGuildScheduledEventListBottomSheet) this.receiver, guildScheduledEventListViewModel$ViewState);
    }
}
