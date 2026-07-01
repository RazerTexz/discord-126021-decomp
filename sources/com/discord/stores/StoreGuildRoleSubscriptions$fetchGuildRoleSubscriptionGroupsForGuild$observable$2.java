package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import j0.k.b;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$2<T, R> implements b<List<? extends GuildRoleSubscriptionGroupListing>, Pair> {
    public static final StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$2 INSTANCE = new StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Pair call(List<? extends GuildRoleSubscriptionGroupListing> list) {
        return call2((List<GuildRoleSubscriptionGroupListing>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair call2(List<GuildRoleSubscriptionGroupListing> list) {
        return new Pair(list, null);
    }
}
