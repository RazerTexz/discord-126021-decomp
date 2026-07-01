package com.discord.api.message.role_subscription;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RoleSubscriptionData.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RoleSubscriptionData {
    private final boolean isRenewal;
    private final long roleSubscriptionListingId;
    private final String tierName;
    private final int totalMonthsSubscribed;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getRoleSubscriptionListingId() {
        return this.roleSubscriptionListingId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getTierName() {
        return this.tierName;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getTotalMonthsSubscribed() {
        return this.totalMonthsSubscribed;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getIsRenewal() {
        return this.isRenewal;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleSubscriptionData)) {
            return false;
        }
        RoleSubscriptionData roleSubscriptionData = (RoleSubscriptionData) other;
        return this.roleSubscriptionListingId == roleSubscriptionData.roleSubscriptionListingId && m.areEqual(this.tierName, roleSubscriptionData.tierName) && this.totalMonthsSubscribed == roleSubscriptionData.totalMonthsSubscribed && this.isRenewal == roleSubscriptionData.isRenewal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public int hashCode() {
        long j = this.roleSubscriptionListingId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.tierName;
        int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.totalMonthsSubscribed) * 31;
        boolean z2 = this.isRenewal;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iHashCode + r0;
    }

    public String toString() {
        StringBuilder sbU = a.U("RoleSubscriptionData(roleSubscriptionListingId=");
        sbU.append(this.roleSubscriptionListingId);
        sbU.append(", tierName=");
        sbU.append(this.tierName);
        sbU.append(", totalMonthsSubscribed=");
        sbU.append(this.totalMonthsSubscribed);
        sbU.append(", isRenewal=");
        return a.O(sbU, this.isRenewal, ")");
    }
}
