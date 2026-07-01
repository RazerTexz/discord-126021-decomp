package com.discord.widgets.guildscheduledevent;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventListBottomSheet$onViewCreated$5 extends k implements Function1<GuildScheduledEventListItem$Event, Unit> {
    public WidgetGuildScheduledEventListBottomSheet$onViewCreated$5(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onShareClicked", "onShareClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem$Event guildScheduledEventListItem$Event) {
        invoke2(guildScheduledEventListItem$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEventListItem$Event guildScheduledEventListItem$Event) {
        m.checkNotNullParameter(guildScheduledEventListItem$Event, "p1");
        WidgetGuildScheduledEventListBottomSheet.access$onShareClicked((WidgetGuildScheduledEventListBottomSheet) this.receiver, guildScheduledEventListItem$Event);
    }
}
