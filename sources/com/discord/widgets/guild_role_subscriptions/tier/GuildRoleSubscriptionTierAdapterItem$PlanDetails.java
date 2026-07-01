package com.discord.widgets.guild_role_subscriptions.tier;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierAdapterItem$PlanDetails extends GuildRoleSubscriptionTierAdapterItem {
    private final String coverImage;
    private final String description;
    private final String key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionTierAdapterItem$PlanDetails(String str, String str2) {
        super(null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        m.checkNotNullParameter(str2, "coverImage");
        this.description = str;
        this.coverImage = str2;
        this.key = "planDetails";
    }

    public static /* synthetic */ GuildRoleSubscriptionTierAdapterItem$PlanDetails copy$default(GuildRoleSubscriptionTierAdapterItem$PlanDetails guildRoleSubscriptionTierAdapterItem$PlanDetails, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guildRoleSubscriptionTierAdapterItem$PlanDetails.description;
        }
        if ((i & 2) != 0) {
            str2 = guildRoleSubscriptionTierAdapterItem$PlanDetails.coverImage;
        }
        return guildRoleSubscriptionTierAdapterItem$PlanDetails.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCoverImage() {
        return this.coverImage;
    }

    public final GuildRoleSubscriptionTierAdapterItem$PlanDetails copy(String description, String coverImage) {
        m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        m.checkNotNullParameter(coverImage, "coverImage");
        return new GuildRoleSubscriptionTierAdapterItem$PlanDetails(description, coverImage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierAdapterItem$PlanDetails)) {
            return false;
        }
        GuildRoleSubscriptionTierAdapterItem$PlanDetails guildRoleSubscriptionTierAdapterItem$PlanDetails = (GuildRoleSubscriptionTierAdapterItem$PlanDetails) other;
        return m.areEqual(this.description, guildRoleSubscriptionTierAdapterItem$PlanDetails.description) && m.areEqual(this.coverImage, guildRoleSubscriptionTierAdapterItem$PlanDetails.coverImage);
    }

    public final String getCoverImage() {
        return this.coverImage;
    }

    public final String getDescription() {
        return this.description;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public int hashCode() {
        String str = this.description;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.coverImage;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("PlanDetails(description=");
        sbU.append(this.description);
        sbU.append(", coverImage=");
        return a.J(sbU, this.coverImage, ")");
    }
}
