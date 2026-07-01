package com.discord.widgets.guild_role_subscriptions;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: GuildRoleSubscriptionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$2<T, R> implements b<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Integer $memberColor;
    public final /* synthetic */ String $memberIcon;
    public final /* synthetic */ RestAPI $restApi;

    public GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$2(RestAPI restAPI, long j, Integer num, String str) {
        this.$restApi = restAPI;
        this.$guildId = j;
        this.$memberColor = num;
        this.$memberIcon = str;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        return call2(guildRoleSubscriptionTierListing);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GuildRoleSubscriptionTierListing> call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
        RestAPI restAPI = this.$restApi;
        long j = this.$guildId;
        Integer num = this.$memberColor;
        String str = this.$memberIcon;
        m.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
        return GuildRoleSubscriptionUtils.access$updateGuildRoleSubscriptionDesign(guildRoleSubscriptionUtils, restAPI, j, num, str, guildRoleSubscriptionTierListing);
    }
}
