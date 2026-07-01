package com.discord.api.report;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ReportNodeChild {
    private final String name;
    private final int ref;

    public ReportNodeChild(String str, int i) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
        this.ref = i;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getRef() {
        return this.ref;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportNodeChild)) {
            return false;
        }
        ReportNodeChild reportNodeChild = (ReportNodeChild) other;
        return m.areEqual(this.name, reportNodeChild.name) && this.ref == reportNodeChild.ref;
    }

    public int hashCode() {
        String str = this.name;
        return ((str != null ? str.hashCode() : 0) * 31) + this.ref;
    }

    public String toString() {
        StringBuilder sbU = a.U("ReportNodeChild(name=");
        sbU.append(this.name);
        sbU.append(", ref=");
        return a.B(sbU, this.ref, ")");
    }
}
