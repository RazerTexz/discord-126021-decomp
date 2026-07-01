package com.discord.api.report;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: ReportReason.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ReportReason {
    private final String description;
    private final String label;
    private final int reason;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getReason() {
        return this.reason;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportReason)) {
            return false;
        }
        ReportReason reportReason = (ReportReason) other;
        return this.reason == reportReason.reason && m.areEqual(this.label, reportReason.label) && m.areEqual(this.description, reportReason.description);
    }

    public int hashCode() {
        int i = this.reason * 31;
        String str = this.label;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ReportReason(reason=");
        sbU.append(this.reason);
        sbU.append(", label=");
        sbU.append(this.label);
        sbU.append(", description=");
        return a.J(sbU, this.description, ")");
    }
}
