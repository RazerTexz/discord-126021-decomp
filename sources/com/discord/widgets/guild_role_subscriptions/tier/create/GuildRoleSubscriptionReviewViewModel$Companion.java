package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.stores.StoreChannels;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildRoleSubscriptionReviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionReviewViewModel$Companion {
    private GuildRoleSubscriptionReviewViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(GuildRoleSubscriptionReviewViewModel$Companion guildRoleSubscriptionReviewViewModel$Companion, long j, ObservationDeck observationDeck, StoreChannels storeChannels) {
        return guildRoleSubscriptionReviewViewModel$Companion.observeStoreState(j, observationDeck, storeChannels);
    }

    private final Observable<GuildRoleSubscriptionReviewViewModel$StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreChannels storeChannels) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storeChannels}, false, null, null, new GuildRoleSubscriptionReviewViewModel$Companion$observeStoreState$1(storeChannels, guildId), 14, null);
    }

    public /* synthetic */ GuildRoleSubscriptionReviewViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
