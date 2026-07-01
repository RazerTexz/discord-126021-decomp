package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import j0.k.b;
import kotlin.Pair;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$2<T, R> implements b<GuildRoleSubscriptionGroupListing, Pair> {
    public static final StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$2 INSTANCE = new StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Pair call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        return call2(guildRoleSubscriptionGroupListing);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        return new Pair(guildRoleSubscriptionGroupListing, null);
    }
}
