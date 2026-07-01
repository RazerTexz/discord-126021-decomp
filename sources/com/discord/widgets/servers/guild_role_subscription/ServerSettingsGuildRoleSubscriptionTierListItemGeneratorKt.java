package com.discord.widgets.servers.guild_role_subscription;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.ImageAsset;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierListItemGeneratorKt {
    public static final List<ServerSettingsGuildRoleSubscriptionTierAdapterItem> generateServerSettingsGuildRoleSubscriptionTierListItems(List<GuildRoleSubscriptionTierListing> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing : list) {
                long id2 = guildRoleSubscriptionTierListing.getId();
                String name = guildRoleSubscriptionTierListing.getName();
                int price = GuildRoleSubscriptionUtilsKt.getPrice(guildRoleSubscriptionTierListing);
                ImageAsset imageAsset = guildRoleSubscriptionTierListing.getImageAsset();
                arrayList.add(new ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier(id2, name, price, guildRoleSubscriptionTierListing.getApplicationId(), guildRoleSubscriptionTierListing.getPublished(), imageAsset != null ? Long.valueOf(imageAsset.getId()) : null));
            }
        }
        if ((list != null ? list.size() : 0) < i) {
            arrayList.add(ServerSettingsGuildRoleSubscriptionTierAdapterItem$AddTier.INSTANCE);
        }
        return arrayList;
    }
}
