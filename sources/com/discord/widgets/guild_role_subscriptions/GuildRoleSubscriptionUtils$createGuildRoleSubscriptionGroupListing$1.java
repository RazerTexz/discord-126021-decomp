package com.discord.widgets.guild_role_subscriptions;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: GuildRoleSubscriptionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils$createGuildRoleSubscriptionGroupListing$1<T, R> implements b<GuildRoleSubscriptionGroupListing, Observable<? extends GuildRoleSubscriptionTierListing>> {
    public final /* synthetic */ boolean $canAccessAllChannels;
    public final /* synthetic */ List $channelBenefits;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ List $intangibleBenefits;
    public final /* synthetic */ String $memberBadge;
    public final /* synthetic */ int $memberColor;
    public final /* synthetic */ int $priceTier;
    public final /* synthetic */ RestAPI $restApi;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
    public final /* synthetic */ String $tierDescription;
    public final /* synthetic */ String $tierImage;
    public final /* synthetic */ String $tierName;

    public GuildRoleSubscriptionUtils$createGuildRoleSubscriptionGroupListing$1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, RestAPI restAPI, String str, String str2, int i, String str3, int i2, String str4, boolean z2, List list, List list2) {
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$restApi = restAPI;
        this.$tierName = str;
        this.$tierDescription = str2;
        this.$priceTier = i;
        this.$tierImage = str3;
        this.$memberColor = i2;
        this.$memberBadge = str4;
        this.$canAccessAllChannels = z2;
        this.$channelBenefits = list;
        this.$intangibleBenefits = list2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        return call2(guildRoleSubscriptionGroupListing);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GuildRoleSubscriptionTierListing> call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
        long j = this.$guildId;
        m.checkNotNullExpressionValue(guildRoleSubscriptionGroupListing, "subscriptionGroupListing");
        storeGuildRoleSubscriptions.handleGuildRoleSubscriptionGroupUpdate(j, guildRoleSubscriptionGroupListing);
        return GuildRoleSubscriptionUtils.INSTANCE.createGuildRoleSubscriptionTierListing(this.$restApi, this.$storeGuildRoleSubscriptions, this.$guildId, guildRoleSubscriptionGroupListing.getId(), this.$tierName, this.$tierDescription, this.$priceTier, this.$tierImage, this.$memberColor, this.$memberBadge, this.$canAccessAllChannels, this.$channelBenefits, this.$intangibleBenefits);
    }
}
