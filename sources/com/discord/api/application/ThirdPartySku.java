package com.discord.api.application;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ThirdPartySku.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ThirdPartySku {
    private final String distributor;
    private final String id;
    private final String sku;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDistributor() {
        return this.distributor;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getSku() {
        return this.sku;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThirdPartySku)) {
            return false;
        }
        ThirdPartySku thirdPartySku = (ThirdPartySku) other;
        return C12238m.areEqual(this.id, thirdPartySku.id) && C12238m.areEqual(this.sku, thirdPartySku.sku) && C12238m.areEqual(this.distributor, thirdPartySku.distributor);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sku;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.distributor;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ThirdPartySku(id=");
        sbM833U.append(this.id);
        sbM833U.append(", sku=");
        sbM833U.append(this.sku);
        sbM833U.append(", distributor=");
        return C1643a.m822J(sbM833U, this.distributor, ")");
    }
}
