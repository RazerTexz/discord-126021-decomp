package com.discord.widgets.guildscheduledevent;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventSettings$onResume$3 extends k implements Function1<Pair<? extends GuildScheduledEventSettingsViewModel$ViewState, ? extends GuildScheduledEventDirectoryAssociationState>, Unit> {
    public WidgetGuildScheduledEventSettings$onResume$3(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        super(1, widgetGuildScheduledEventSettings, WidgetGuildScheduledEventSettings.class, "configureVisibilitySettings", "configureVisibilitySettings(Lkotlin/Pair;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends GuildScheduledEventSettingsViewModel$ViewState, ? extends GuildScheduledEventDirectoryAssociationState> pair) {
        invoke2((Pair<? extends GuildScheduledEventSettingsViewModel$ViewState, GuildScheduledEventDirectoryAssociationState>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<? extends GuildScheduledEventSettingsViewModel$ViewState, GuildScheduledEventDirectoryAssociationState> pair) {
        m.checkNotNullParameter(pair, "p1");
        WidgetGuildScheduledEventSettings.access$configureVisibilitySettings((WidgetGuildScheduledEventSettings) this.receiver, pair);
    }
}
