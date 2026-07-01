package com.discord.widgets.servers.guild_role_subscription;


/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierAdapterItem$AddTier extends ServerSettingsGuildRoleSubscriptionTierAdapterItem {
    public static final ServerSettingsGuildRoleSubscriptionTierAdapterItem$AddTier INSTANCE = new ServerSettingsGuildRoleSubscriptionTierAdapterItem$AddTier();
    private static final String key = "AddTierItem";

    private ServerSettingsGuildRoleSubscriptionTierAdapterItem$AddTier() {
        super(null);
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return key;
    }
}
