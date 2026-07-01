package com.discord.restapi;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$CreateGuildRoleSubscriptionTierListing {
    private final List<GuildRoleSubscriptionBenefit> benefits;
    private final boolean canAccessAllChannels;
    private final String description;
    private final String image;
    private final String name;
    private final int priceTier;

    public RestAPIParams$CreateGuildRoleSubscriptionTierListing(String str, String str2, String str3, List<GuildRoleSubscriptionBenefit> list, int i, boolean z2) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(list, "benefits");
        this.name = str;
        this.image = str2;
        this.description = str3;
        this.benefits = list;
        this.priceTier = i;
        this.canAccessAllChannels = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestAPIParams$CreateGuildRoleSubscriptionTierListing copy$default(RestAPIParams$CreateGuildRoleSubscriptionTierListing restAPIParams$CreateGuildRoleSubscriptionTierListing, String str, String str2, String str3, List list, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = restAPIParams$CreateGuildRoleSubscriptionTierListing.name;
        }
        if ((i2 & 2) != 0) {
            str2 = restAPIParams$CreateGuildRoleSubscriptionTierListing.image;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = restAPIParams$CreateGuildRoleSubscriptionTierListing.description;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            list = restAPIParams$CreateGuildRoleSubscriptionTierListing.benefits;
        }
        List list2 = list;
        if ((i2 & 16) != 0) {
            i = restAPIParams$CreateGuildRoleSubscriptionTierListing.priceTier;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            z2 = restAPIParams$CreateGuildRoleSubscriptionTierListing.canAccessAllChannels;
        }
        return restAPIParams$CreateGuildRoleSubscriptionTierListing.copy(str, str4, str5, list2, i3, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<GuildRoleSubscriptionBenefit> component4() {
        return this.benefits;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPriceTier() {
        return this.priceTier;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanAccessAllChannels() {
        return this.canAccessAllChannels;
    }

    public final RestAPIParams$CreateGuildRoleSubscriptionTierListing copy(String name, String image, String description, List<GuildRoleSubscriptionBenefit> benefits, int priceTier, boolean canAccessAllChannels) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(benefits, "benefits");
        return new RestAPIParams$CreateGuildRoleSubscriptionTierListing(name, image, description, benefits, priceTier, canAccessAllChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$CreateGuildRoleSubscriptionTierListing)) {
            return false;
        }
        RestAPIParams$CreateGuildRoleSubscriptionTierListing restAPIParams$CreateGuildRoleSubscriptionTierListing = (RestAPIParams$CreateGuildRoleSubscriptionTierListing) other;
        return m.areEqual(this.name, restAPIParams$CreateGuildRoleSubscriptionTierListing.name) && m.areEqual(this.image, restAPIParams$CreateGuildRoleSubscriptionTierListing.image) && m.areEqual(this.description, restAPIParams$CreateGuildRoleSubscriptionTierListing.description) && m.areEqual(this.benefits, restAPIParams$CreateGuildRoleSubscriptionTierListing.benefits) && this.priceTier == restAPIParams$CreateGuildRoleSubscriptionTierListing.priceTier && this.canAccessAllChannels == restAPIParams$CreateGuildRoleSubscriptionTierListing.canAccessAllChannels;
    }

    public final List<GuildRoleSubscriptionBenefit> getBenefits() {
        return this.benefits;
    }

    public final boolean getCanAccessAllChannels() {
        return this.canAccessAllChannels;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPriceTier() {
        return this.priceTier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.image;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<GuildRoleSubscriptionBenefit> list = this.benefits;
        int iHashCode4 = (((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31) + this.priceTier) * 31;
        boolean z2 = this.canAccessAllChannels;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode4 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("CreateGuildRoleSubscriptionTierListing(name=");
        sbU.append(this.name);
        sbU.append(", image=");
        sbU.append(this.image);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", benefits=");
        sbU.append(this.benefits);
        sbU.append(", priceTier=");
        sbU.append(this.priceTier);
        sbU.append(", canAccessAllChannels=");
        return a.O(sbU, this.canAccessAllChannels, ")");
    }
}
