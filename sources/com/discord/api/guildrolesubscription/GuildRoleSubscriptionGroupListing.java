package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: GuildRoleSubscriptionGroupListing.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionGroupListing {
    private final long applicationId;
    private final String description;
    private final boolean fullServerGate;
    private final long guildId;
    private final long id;
    private final ImageAsset imageAsset;
    private final List<GuildRoleSubscriptionTierListing> subscriptionListings;
    private final List<Long> subscriptionListingsIds;

    public GuildRoleSubscriptionGroupListing(long j, long j2, long j3, ImageAsset imageAsset, String str, List<Long> list, List<GuildRoleSubscriptionTierListing> list2, boolean z2) {
        this.id = j;
        this.guildId = j2;
        this.applicationId = j3;
        this.imageAsset = imageAsset;
        this.description = str;
        this.subscriptionListingsIds = list;
        this.subscriptionListings = list2;
        this.fullServerGate = z2;
    }

    public static GuildRoleSubscriptionGroupListing a(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, long j, long j2, long j3, ImageAsset imageAsset, String str, List list, List list2, boolean z2, int i) {
        long j4 = (i & 1) != 0 ? guildRoleSubscriptionGroupListing.id : j;
        long j5 = (i & 2) != 0 ? guildRoleSubscriptionGroupListing.guildId : j2;
        long j6 = (i & 4) != 0 ? guildRoleSubscriptionGroupListing.applicationId : j3;
        ImageAsset imageAsset2 = (i & 8) != 0 ? guildRoleSubscriptionGroupListing.imageAsset : null;
        String str2 = (i & 16) != 0 ? guildRoleSubscriptionGroupListing.description : null;
        List<Long> list3 = (i & 32) != 0 ? guildRoleSubscriptionGroupListing.subscriptionListingsIds : null;
        List list4 = (i & 64) != 0 ? guildRoleSubscriptionGroupListing.subscriptionListings : list2;
        boolean z3 = (i & 128) != 0 ? guildRoleSubscriptionGroupListing.fullServerGate : z2;
        Objects.requireNonNull(guildRoleSubscriptionGroupListing);
        return new GuildRoleSubscriptionGroupListing(j4, j5, j6, imageAsset2, str2, list3, list4, z3);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getFullServerGate() {
        return this.fullServerGate;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionGroupListing)) {
            return false;
        }
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = (GuildRoleSubscriptionGroupListing) other;
        return this.id == guildRoleSubscriptionGroupListing.id && this.guildId == guildRoleSubscriptionGroupListing.guildId && this.applicationId == guildRoleSubscriptionGroupListing.applicationId && Intrinsics3.areEqual(this.imageAsset, guildRoleSubscriptionGroupListing.imageAsset) && Intrinsics3.areEqual(this.description, guildRoleSubscriptionGroupListing.description) && Intrinsics3.areEqual(this.subscriptionListingsIds, guildRoleSubscriptionGroupListing.subscriptionListingsIds) && Intrinsics3.areEqual(this.subscriptionListings, guildRoleSubscriptionGroupListing.subscriptionListings) && this.fullServerGate == guildRoleSubscriptionGroupListing.fullServerGate;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final ImageAsset getImageAsset() {
        return this.imageAsset;
    }

    public final List<GuildRoleSubscriptionTierListing> h() {
        return this.subscriptionListings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    public int hashCode() {
        long j = this.id;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.applicationId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        ImageAsset imageAsset = this.imageAsset;
        int iHashCode = (i2 + (imageAsset != null ? imageAsset.hashCode() : 0)) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<Long> list = this.subscriptionListingsIds;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<GuildRoleSubscriptionTierListing> list2 = this.subscriptionListings;
        int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z2 = this.fullServerGate;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iHashCode4 + r0;
    }

    public final List<Long> i() {
        return this.subscriptionListingsIds;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleSubscriptionGroupListing(id=");
        sbU.append(this.id);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", imageAsset=");
        sbU.append(this.imageAsset);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", subscriptionListingsIds=");
        sbU.append(this.subscriptionListingsIds);
        sbU.append(", subscriptionListings=");
        sbU.append(this.subscriptionListings);
        sbU.append(", fullServerGate=");
        return outline.O(sbU, this.fullServerGate, ")");
    }
}
