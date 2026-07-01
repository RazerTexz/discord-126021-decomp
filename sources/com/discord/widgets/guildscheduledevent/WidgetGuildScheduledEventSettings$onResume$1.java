package com.discord.widgets.guildscheduledevent;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventSettings$onResume$1 extends k implements Function1<GuildScheduledEventSettingsViewModel$ViewState, Unit> {
    public WidgetGuildScheduledEventSettings$onResume$1(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        super(1, widgetGuildScheduledEventSettings, WidgetGuildScheduledEventSettings.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventSettingsViewModel$ViewState guildScheduledEventSettingsViewModel$ViewState) {
        invoke2(guildScheduledEventSettingsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEventSettingsViewModel$ViewState guildScheduledEventSettingsViewModel$ViewState) {
        m.checkNotNullParameter(guildScheduledEventSettingsViewModel$ViewState, "p1");
        WidgetGuildScheduledEventSettings.access$configureUi((WidgetGuildScheduledEventSettings) this.receiver, guildScheduledEventSettingsViewModel$ViewState);
    }
}
