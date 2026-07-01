package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreEmoji$EmojiContext$Guild;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion {
    private ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion serverSettingsGuildRoleSubscriptionEditTierViewModel$Companion, long j, long j2, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreChannels storeChannels, StoreEmoji storeEmoji, StoreGuilds storeGuilds) {
        return serverSettingsGuildRoleSubscriptionEditTierViewModel$Companion.observeStoreState(j, j2, observationDeck, storeGuildRoleSubscriptions, storeChannels, storeEmoji, storeGuilds);
    }

    private final Observable<ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState> observeStoreState(long guildId, long guildRoleSubscriptionTierListingId, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreChannels storeChannels, StoreEmoji storeEmoji, StoreGuilds storeGuilds) {
        Observable<ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState> observableJ = Observable.j(storeEmoji.getEmojiSet(new StoreEmoji$EmojiContext$Guild(guildId), false, false), ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storeGuildRoleSubscriptions, storeChannels, storeGuilds}, false, null, null, new ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion$observeStoreState$1(storeGuildRoleSubscriptions, guildId, storeChannels, storeGuilds, guildRoleSubscriptionTierListingId), 14, null), ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion$observeStoreState$2.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…oreData\n        )\n      }");
        return observableJ;
    }

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
