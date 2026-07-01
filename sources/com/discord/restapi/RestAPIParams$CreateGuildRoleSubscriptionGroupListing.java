package com.discord.restapi;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$CreateGuildRoleSubscriptionGroupListing {
    private final String description;
    private final Boolean fullServerGate;
    private final String image;

    public RestAPIParams$CreateGuildRoleSubscriptionGroupListing(String str, String str2, Boolean bool) {
        this.image = str;
        this.description = str2;
        this.fullServerGate = bool;
    }

    public static /* synthetic */ RestAPIParams$CreateGuildRoleSubscriptionGroupListing copy$default(RestAPIParams$CreateGuildRoleSubscriptionGroupListing restAPIParams$CreateGuildRoleSubscriptionGroupListing, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$CreateGuildRoleSubscriptionGroupListing.image;
        }
        if ((i & 2) != 0) {
            str2 = restAPIParams$CreateGuildRoleSubscriptionGroupListing.description;
        }
        if ((i & 4) != 0) {
            bool = restAPIParams$CreateGuildRoleSubscriptionGroupListing.fullServerGate;
        }
        return restAPIParams$CreateGuildRoleSubscriptionGroupListing.copy(str, str2, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getFullServerGate() {
        return this.fullServerGate;
    }

    public final RestAPIParams$CreateGuildRoleSubscriptionGroupListing copy(String image, String description, Boolean fullServerGate) {
        return new RestAPIParams$CreateGuildRoleSubscriptionGroupListing(image, description, fullServerGate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$CreateGuildRoleSubscriptionGroupListing)) {
            return false;
        }
        RestAPIParams$CreateGuildRoleSubscriptionGroupListing restAPIParams$CreateGuildRoleSubscriptionGroupListing = (RestAPIParams$CreateGuildRoleSubscriptionGroupListing) other;
        return m.areEqual(this.image, restAPIParams$CreateGuildRoleSubscriptionGroupListing.image) && m.areEqual(this.description, restAPIParams$CreateGuildRoleSubscriptionGroupListing.description) && m.areEqual(this.fullServerGate, restAPIParams$CreateGuildRoleSubscriptionGroupListing.fullServerGate);
    }

    public final String getDescription() {
        return this.description;
    }

    public final Boolean getFullServerGate() {
        return this.fullServerGate;
    }

    public final String getImage() {
        return this.image;
    }

    public int hashCode() {
        String str = this.image;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.fullServerGate;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CreateGuildRoleSubscriptionGroupListing(image=");
        sbU.append(this.image);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", fullServerGate=");
        return a.D(sbU, this.fullServerGate, ")");
    }
}
