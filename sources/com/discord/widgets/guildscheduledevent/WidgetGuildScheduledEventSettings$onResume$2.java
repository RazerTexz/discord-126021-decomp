package com.discord.widgets.guildscheduledevent;

import androidx.core.app.NotificationCompat;
import d0.o;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onResume$2<T1, T2, R> implements Func2<GuildScheduledEventSettingsViewModel$ViewState, GuildScheduledEventDirectoryAssociationState, Pair<? extends GuildScheduledEventSettingsViewModel$ViewState, ? extends GuildScheduledEventDirectoryAssociationState>> {
    public static final WidgetGuildScheduledEventSettings$onResume$2 INSTANCE = new WidgetGuildScheduledEventSettings$onResume$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends GuildScheduledEventSettingsViewModel$ViewState, ? extends GuildScheduledEventDirectoryAssociationState> call(GuildScheduledEventSettingsViewModel$ViewState guildScheduledEventSettingsViewModel$ViewState, GuildScheduledEventDirectoryAssociationState guildScheduledEventDirectoryAssociationState) {
        return call2(guildScheduledEventSettingsViewModel$ViewState, guildScheduledEventDirectoryAssociationState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<GuildScheduledEventSettingsViewModel$ViewState, GuildScheduledEventDirectoryAssociationState> call2(GuildScheduledEventSettingsViewModel$ViewState guildScheduledEventSettingsViewModel$ViewState, GuildScheduledEventDirectoryAssociationState guildScheduledEventDirectoryAssociationState) {
        return o.to(guildScheduledEventSettingsViewModel$ViewState, guildScheduledEventDirectoryAssociationState);
    }
}
