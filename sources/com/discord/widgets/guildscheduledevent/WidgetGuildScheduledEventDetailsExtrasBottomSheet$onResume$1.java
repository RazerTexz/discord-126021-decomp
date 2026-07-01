package com.discord.widgets.guildscheduledevent;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventDetailsExtrasBottomSheet$onResume$1 extends k implements Function1<GuildScheduledEventDetailsViewModel$ViewState, Unit> {
    public WidgetGuildScheduledEventDetailsExtrasBottomSheet$onResume$1(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet) {
        super(1, widgetGuildScheduledEventDetailsExtrasBottomSheet, WidgetGuildScheduledEventDetailsExtrasBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDetailsViewModel$ViewState guildScheduledEventDetailsViewModel$ViewState) {
        invoke2(guildScheduledEventDetailsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEventDetailsViewModel$ViewState guildScheduledEventDetailsViewModel$ViewState) {
        m.checkNotNullParameter(guildScheduledEventDetailsViewModel$ViewState, "p1");
        WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$configureUi((WidgetGuildScheduledEventDetailsExtrasBottomSheet) this.receiver, guildScheduledEventDetailsViewModel$ViewState);
    }
}
