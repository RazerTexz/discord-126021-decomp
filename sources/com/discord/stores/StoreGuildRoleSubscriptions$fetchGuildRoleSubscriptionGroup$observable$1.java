package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import java.util.List;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$1<T1, T2, R> implements Func2<GuildRoleSubscriptionGroupListing, List<? extends GuildRoleSubscriptionTierFreeTrial>, Pair<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>> {
    public static final StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$1 INSTANCE = new StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List<? extends GuildRoleSubscriptionTierFreeTrial> list) {
        return call2(guildRoleSubscriptionGroupListing, (List<GuildRoleSubscriptionTierFreeTrial>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<GuildRoleSubscriptionGroupListing, List<GuildRoleSubscriptionTierFreeTrial>> call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List<GuildRoleSubscriptionTierFreeTrial> list) {
        return new Pair<>(guildRoleSubscriptionGroupListing, list);
    }
}
