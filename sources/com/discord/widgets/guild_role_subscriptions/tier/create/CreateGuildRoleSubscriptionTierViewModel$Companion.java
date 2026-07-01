package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreateGuildRoleSubscriptionTierViewModel$Companion {
    private CreateGuildRoleSubscriptionTierViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(CreateGuildRoleSubscriptionTierViewModel$Companion createGuildRoleSubscriptionTierViewModel$Companion, long j, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds) {
        return createGuildRoleSubscriptionTierViewModel$Companion.observeStoreState(j, observationDeck, storeGuildRoleSubscriptions, storeGuilds);
    }

    private final Observable<CreateGuildRoleSubscriptionTierViewModel$StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new CreateGuildRoleSubscriptionTierViewModel$Companion$observeStoreState$1(storeGuildRoleSubscriptions, guildId, storeGuilds), 14, null);
    }

    public /* synthetic */ CreateGuildRoleSubscriptionTierViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
