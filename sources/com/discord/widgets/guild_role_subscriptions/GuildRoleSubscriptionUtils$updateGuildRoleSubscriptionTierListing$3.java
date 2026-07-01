package com.discord.widgets.guild_role_subscriptions;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.nullserializable.NullSerializable;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: GuildRoleSubscriptionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$3<T, R> implements b<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>> {
    public final /* synthetic */ NullSerializable $activeTrialUserLimit;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ RestAPI $restApi;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
    public final /* synthetic */ NullSerializable $trialInterval;

    public GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$3(RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, NullSerializable nullSerializable, NullSerializable nullSerializable2) {
        this.$restApi = restAPI;
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$trialInterval = nullSerializable;
        this.$activeTrialUserLimit = nullSerializable2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        return call2(guildRoleSubscriptionTierListing);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GuildRoleSubscriptionTierListing> call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
        RestAPI restAPI = this.$restApi;
        StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
        long j = this.$guildId;
        m.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
        return GuildRoleSubscriptionUtils.access$updateGuildRoleSubscriptionTrial(guildRoleSubscriptionUtils, restAPI, storeGuildRoleSubscriptions, j, guildRoleSubscriptionTierListing, this.$trialInterval, this.$activeTrialUserLimit);
    }
}
