package com.discord.widgets.guild_role_subscriptions;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGuildRoleSubscriptions;
import rx.functions.Action1;

/* JADX INFO: compiled from: GuildRoleSubscriptionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils$deleteGuildRoleSubscriptionTierListing$1<T> implements Action1<Void> {
    public final /* synthetic */ long $groupListingId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
    public final /* synthetic */ long $tierListingId;

    public GuildRoleSubscriptionUtils$deleteGuildRoleSubscriptionTierListing$1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, long j2, long j3) {
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$groupListingId = j2;
        this.$tierListingId = j3;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Void r1) {
        call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Void r8) {
        this.$storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierListingDelete(this.$guildId, this.$groupListingId, this.$tierListingId);
    }
}
