package com.discord.widgets.guild_role_subscriptions;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import j0.k.b;

/* JADX INFO: compiled from: GuildRoleSubscriptionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTrial$2<T, R> implements b<GuildRoleSubscriptionTierFreeTrial, GuildRoleSubscriptionTierListing> {
    public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;

    public GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTrial$2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ GuildRoleSubscriptionTierListing call(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
        return call2(guildRoleSubscriptionTierFreeTrial);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildRoleSubscriptionTierListing call2(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
        return this.$guildRoleSubscriptionTierListing;
    }
}
