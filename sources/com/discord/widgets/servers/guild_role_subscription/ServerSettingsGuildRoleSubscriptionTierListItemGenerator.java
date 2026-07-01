package com.discord.widgets.servers.guild_role_subscription;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.ImageAsset;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils2;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierListItemGeneratorKt, reason: use source file name */
/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierListItemGenerator {
    public static final List<ServerSettingsGuildRoleSubscriptionTierAdapter2> generateServerSettingsGuildRoleSubscriptionTierListItems(List<GuildRoleSubscriptionTierListing> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing : list) {
                long id2 = guildRoleSubscriptionTierListing.getId();
                String name = guildRoleSubscriptionTierListing.getName();
                int price = GuildRoleSubscriptionUtils2.getPrice(guildRoleSubscriptionTierListing);
                ImageAsset imageAsset = guildRoleSubscriptionTierListing.getImageAsset();
                arrayList.add(new ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier(id2, name, price, guildRoleSubscriptionTierListing.getApplicationId(), guildRoleSubscriptionTierListing.getPublished(), imageAsset != null ? Long.valueOf(imageAsset.getId()) : null));
            }
        }
        if ((list != null ? list.size() : 0) < i) {
            arrayList.add(ServerSettingsGuildRoleSubscriptionTierAdapter2.AddTier.INSTANCE);
        }
        return arrayList;
    }
}
