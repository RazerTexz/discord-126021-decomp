package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: StoreAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreAuditLog$AuditLogFilter {
    public static final StoreAuditLog$AuditLogFilter$Companion Companion = new StoreAuditLog$AuditLogFilter$Companion(null);
    private final int actionFilter;
    private final long userFilter;

    public StoreAuditLog$AuditLogFilter(long j, int i) {
        this.userFilter = j;
        this.actionFilter = i;
    }

    public static /* synthetic */ StoreAuditLog$AuditLogFilter copy$default(StoreAuditLog$AuditLogFilter storeAuditLog$AuditLogFilter, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = storeAuditLog$AuditLogFilter.userFilter;
        }
        if ((i2 & 2) != 0) {
            i = storeAuditLog$AuditLogFilter.actionFilter;
        }
        return storeAuditLog$AuditLogFilter.copy(j, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserFilter() {
        return this.userFilter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getActionFilter() {
        return this.actionFilter;
    }

    public final StoreAuditLog$AuditLogFilter copy(long userFilter, int actionFilter) {
        return new StoreAuditLog$AuditLogFilter(userFilter, actionFilter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreAuditLog$AuditLogFilter)) {
            return false;
        }
        StoreAuditLog$AuditLogFilter storeAuditLog$AuditLogFilter = (StoreAuditLog$AuditLogFilter) other;
        return this.userFilter == storeAuditLog$AuditLogFilter.userFilter && this.actionFilter == storeAuditLog$AuditLogFilter.actionFilter;
    }

    public final int getActionFilter() {
        return this.actionFilter;
    }

    public final long getUserFilter() {
        return this.userFilter;
    }

    public int hashCode() {
        return (b.a(this.userFilter) * 31) + this.actionFilter;
    }

    public String toString() {
        StringBuilder sbU = a.U("AuditLogFilter(userFilter=");
        sbU.append(this.userFilter);
        sbU.append(", actionFilter=");
        return a.B(sbU, this.actionFilter, ")");
    }
}
