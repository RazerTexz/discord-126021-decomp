package com.discord.widgets.guild_role_subscriptions;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: GuildRoleSubscriptionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils$createGuildRoleSubscriptionTierListing$2<T> implements Action1<GuildRoleSubscriptionTierListing> {
    public final /* synthetic */ long $groupListingId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

    public GuildRoleSubscriptionUtils$createGuildRoleSubscriptionTierListing$2(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, long j2) {
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$groupListingId = j2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        call2(guildRoleSubscriptionTierListing);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
        long j = this.$guildId;
        long j2 = this.$groupListingId;
        m.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "tierListing");
        storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierListingCreate(j, j2, guildRoleSubscriptionTierListing);
    }
}
