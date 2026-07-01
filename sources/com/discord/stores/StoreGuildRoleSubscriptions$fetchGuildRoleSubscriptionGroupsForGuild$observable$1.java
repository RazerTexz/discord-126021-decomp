package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import java.util.List;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$1<T1, T2, R> implements Func2<List<? extends GuildRoleSubscriptionGroupListing>, List<? extends GuildRoleSubscriptionTierFreeTrial>, Pair<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>> {
    public static final StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$1 INSTANCE = new StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> call(List<? extends GuildRoleSubscriptionGroupListing> list, List<? extends GuildRoleSubscriptionTierFreeTrial> list2) {
        return call2((List<GuildRoleSubscriptionGroupListing>) list, (List<GuildRoleSubscriptionTierFreeTrial>) list2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<List<GuildRoleSubscriptionGroupListing>, List<GuildRoleSubscriptionTierFreeTrial>> call2(List<GuildRoleSubscriptionGroupListing> list, List<GuildRoleSubscriptionTierFreeTrial> list2) {
        return new Pair<>(list, list2);
    }
}
