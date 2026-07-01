package com.discord.widgets.servers.guild_role_subscription;

import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionViewModel$Companion {
    private ServerSettingsGuildRoleSubscriptionViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(ServerSettingsGuildRoleSubscriptionViewModel$Companion serverSettingsGuildRoleSubscriptionViewModel$Companion, long j, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds) {
        return serverSettingsGuildRoleSubscriptionViewModel$Companion.observeStoreState(j, observationDeck, storeGuildRoleSubscriptions, storeGuilds);
    }

    private final Observable<ServerSettingsGuildRoleSubscriptionViewModel$StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new ServerSettingsGuildRoleSubscriptionViewModel$Companion$observeStoreState$1(storeGuildRoleSubscriptions, guildId, storeGuilds), 14, null);
    }

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
