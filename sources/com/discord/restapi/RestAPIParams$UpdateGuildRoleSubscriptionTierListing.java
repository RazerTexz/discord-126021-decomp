package com.discord.restapi;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$UpdateGuildRoleSubscriptionTierListing {
    private final List<GuildRoleSubscriptionBenefit> benefits;
    private final Boolean canAccessAllChannels;
    private final String description;
    private final String image;
    private final String name;
    private final Integer priceTier;
    private final Boolean published;

    public RestAPIParams$UpdateGuildRoleSubscriptionTierListing(String str, String str2, String str3, Integer num, List<GuildRoleSubscriptionBenefit> list, Boolean bool, Boolean bool2) {
        this.name = str;
        this.image = str2;
        this.description = str3;
        this.priceTier = num;
        this.benefits = list;
        this.published = bool;
        this.canAccessAllChannels = bool2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestAPIParams$UpdateGuildRoleSubscriptionTierListing copy$default(RestAPIParams$UpdateGuildRoleSubscriptionTierListing restAPIParams$UpdateGuildRoleSubscriptionTierListing, String str, String str2, String str3, Integer num, List list, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$UpdateGuildRoleSubscriptionTierListing.name;
        }
        if ((i & 2) != 0) {
            str2 = restAPIParams$UpdateGuildRoleSubscriptionTierListing.image;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = restAPIParams$UpdateGuildRoleSubscriptionTierListing.description;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            num = restAPIParams$UpdateGuildRoleSubscriptionTierListing.priceTier;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            list = restAPIParams$UpdateGuildRoleSubscriptionTierListing.benefits;
        }
        List list2 = list;
        if ((i & 32) != 0) {
            bool = restAPIParams$UpdateGuildRoleSubscriptionTierListing.published;
        }
        Boolean bool3 = bool;
        if ((i & 64) != 0) {
            bool2 = restAPIParams$UpdateGuildRoleSubscriptionTierListing.canAccessAllChannels;
        }
        return restAPIParams$UpdateGuildRoleSubscriptionTierListing.copy(str, str4, str5, num2, list2, bool3, bool2);
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

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getPriceTier() {
        return this.priceTier;
    }

    public final List<GuildRoleSubscriptionBenefit> component5() {
        return this.benefits;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getPublished() {
        return this.published;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getCanAccessAllChannels() {
        return this.canAccessAllChannels;
    }

    public final RestAPIParams$UpdateGuildRoleSubscriptionTierListing copy(String name, String image, String description, Integer priceTier, List<GuildRoleSubscriptionBenefit> benefits, Boolean published, Boolean canAccessAllChannels) {
        return new RestAPIParams$UpdateGuildRoleSubscriptionTierListing(name, image, description, priceTier, benefits, published, canAccessAllChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$UpdateGuildRoleSubscriptionTierListing)) {
            return false;
        }
        RestAPIParams$UpdateGuildRoleSubscriptionTierListing restAPIParams$UpdateGuildRoleSubscriptionTierListing = (RestAPIParams$UpdateGuildRoleSubscriptionTierListing) other;
        return m.areEqual(this.name, restAPIParams$UpdateGuildRoleSubscriptionTierListing.name) && m.areEqual(this.image, restAPIParams$UpdateGuildRoleSubscriptionTierListing.image) && m.areEqual(this.description, restAPIParams$UpdateGuildRoleSubscriptionTierListing.description) && m.areEqual(this.priceTier, restAPIParams$UpdateGuildRoleSubscriptionTierListing.priceTier) && m.areEqual(this.benefits, restAPIParams$UpdateGuildRoleSubscriptionTierListing.benefits) && m.areEqual(this.published, restAPIParams$UpdateGuildRoleSubscriptionTierListing.published) && m.areEqual(this.canAccessAllChannels, restAPIParams$UpdateGuildRoleSubscriptionTierListing.canAccessAllChannels);
    }

    public final List<GuildRoleSubscriptionBenefit> getBenefits() {
        return this.benefits;
    }

    public final Boolean getCanAccessAllChannels() {
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

    public final Integer getPriceTier() {
        return this.priceTier;
    }

    public final Boolean getPublished() {
        return this.published;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.image;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.priceTier;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        List<GuildRoleSubscriptionBenefit> list = this.benefits;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.published;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.canAccessAllChannels;
        return iHashCode6 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UpdateGuildRoleSubscriptionTierListing(name=");
        sbU.append(this.name);
        sbU.append(", image=");
        sbU.append(this.image);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", priceTier=");
        sbU.append(this.priceTier);
        sbU.append(", benefits=");
        sbU.append(this.benefits);
        sbU.append(", published=");
        sbU.append(this.published);
        sbU.append(", canAccessAllChannels=");
        return a.D(sbU, this.canAccessAllChannels, ")");
    }
}
