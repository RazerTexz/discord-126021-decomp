package com.discord.widgets.guild_role_subscriptions.tier;


/* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierAdapterItem$AllChannelsAccessBenefitItem extends GuildRoleSubscriptionTierAdapterItem {
    public static final GuildRoleSubscriptionTierAdapterItem$AllChannelsAccessBenefitItem INSTANCE = new GuildRoleSubscriptionTierAdapterItem$AllChannelsAccessBenefitItem();
    private static final String key = "allChannelsAccessBenefitItem";

    private GuildRoleSubscriptionTierAdapterItem$AllChannelsAccessBenefitItem() {
        super(null);
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return key;
    }
}
