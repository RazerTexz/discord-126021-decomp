package com.discord.widgets.servers.guild_role_subscription;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier extends ServerSettingsGuildRoleSubscriptionTierAdapterItem {
    private final long applicationId;
    private final boolean isPublished;
    private final String key;
    private final Long tierImageAssetId;
    private final long tierListingId;
    private final String tierName;
    private final int tierPrice;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier(long j, String str, int i, long j2, boolean z2, Long l) {
        super(null);
        m.checkNotNullParameter(str, "tierName");
        this.tierListingId = j;
        this.tierName = str;
        this.tierPrice = i;
        this.applicationId = j2;
        this.isPublished = z2;
        this.tierImageAssetId = l;
        this.key = String.valueOf(j);
    }

    public static /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier copy$default(ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier, long j, String str, int i, long j2, boolean z2, Long l, int i2, Object obj) {
        return serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.copy((i2 & 1) != 0 ? serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.tierListingId : j, (i2 & 2) != 0 ? serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.tierName : str, (i2 & 4) != 0 ? serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.tierPrice : i, (i2 & 8) != 0 ? serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.applicationId : j2, (i2 & 16) != 0 ? serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.isPublished : z2, (i2 & 32) != 0 ? serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.tierImageAssetId : l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTierListingId() {
        return this.tierListingId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTierName() {
        return this.tierName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTierPrice() {
        return this.tierPrice;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsPublished() {
        return this.isPublished;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getTierImageAssetId() {
        return this.tierImageAssetId;
    }

    public final ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier copy(long tierListingId, String tierName, int tierPrice, long applicationId, boolean isPublished, Long tierImageAssetId) {
        m.checkNotNullParameter(tierName, "tierName");
        return new ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier(tierListingId, tierName, tierPrice, applicationId, isPublished, tierImageAssetId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier)) {
            return false;
        }
        ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier = (ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier) other;
        return this.tierListingId == serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.tierListingId && m.areEqual(this.tierName, serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.tierName) && this.tierPrice == serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.tierPrice && this.applicationId == serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.applicationId && this.isPublished == serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.isPublished && m.areEqual(this.tierImageAssetId, serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier.tierImageAssetId);
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Long getTierImageAssetId() {
        return this.tierImageAssetId;
    }

    public final long getTierListingId() {
        return this.tierListingId;
    }

    public final String getTierName() {
        return this.tierName;
    }

    public final int getTierPrice() {
        return this.tierPrice;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    public int hashCode() {
        int iA = b.a(this.tierListingId) * 31;
        String str = this.tierName;
        int iA2 = (b.a(this.applicationId) + ((((iA + (str != null ? str.hashCode() : 0)) * 31) + this.tierPrice) * 31)) * 31;
        boolean z2 = this.isPublished;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iA2 + r0) * 31;
        Long l = this.tierImageAssetId;
        return i + (l != null ? l.hashCode() : 0);
    }

    public final boolean isPublished() {
        return this.isPublished;
    }

    public String toString() {
        StringBuilder sbU = a.U("Tier(tierListingId=");
        sbU.append(this.tierListingId);
        sbU.append(", tierName=");
        sbU.append(this.tierName);
        sbU.append(", tierPrice=");
        sbU.append(this.tierPrice);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", isPublished=");
        sbU.append(this.isPublished);
        sbU.append(", tierImageAssetId=");
        return a.G(sbU, this.tierImageAssetId, ")");
    }
}
