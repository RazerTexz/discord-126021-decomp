package com.discord.widgets.servers.guild_role_subscription;

import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierListViewModel$Companion {
    private ServerSettingsGuildRoleSubscriptionTierListViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(ServerSettingsGuildRoleSubscriptionTierListViewModel$Companion serverSettingsGuildRoleSubscriptionTierListViewModel$Companion, long j, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return serverSettingsGuildRoleSubscriptionTierListViewModel$Companion.observeStoreState(j, observationDeck, storeGuildRoleSubscriptions);
    }

    private final Observable<ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new ServerSettingsGuildRoleSubscriptionTierListViewModel$Companion$observeStoreState$1(storeGuildRoleSubscriptions, guildId), 14, null);
    }

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionTierListViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
