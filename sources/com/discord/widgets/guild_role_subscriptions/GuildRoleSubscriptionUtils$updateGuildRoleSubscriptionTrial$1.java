package com.discord.widgets.guild_role_subscriptions;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: GuildRoleSubscriptionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTrial$1<T> implements Action1<GuildRoleSubscriptionTierFreeTrial> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

    public GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTrial$1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
        call2(guildRoleSubscriptionTierFreeTrial);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
        StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
        long j = this.$guildId;
        long id2 = this.$guildRoleSubscriptionTierListing.getId();
        m.checkNotNullExpressionValue(guildRoleSubscriptionTierFreeTrial, "it");
        storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierTrialUpdate(j, id2, guildRoleSubscriptionTierFreeTrial);
    }
}
