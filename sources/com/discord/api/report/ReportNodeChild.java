package com.discord.api.report;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ReportNodeChild {
    private final String name;
    private final int ref;

    public ReportNodeChild(String str, int i) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
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
        return C12238m.areEqual(this.name, reportNodeChild.name) && this.ref == reportNodeChild.ref;
    }

    public int hashCode() {
        String str = this.name;
        return ((str != null ? str.hashCode() : 0) * 31) + this.ref;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ReportNodeChild(name=");
        sbM833U.append(this.name);
        sbM833U.append(", ref=");
        return C1643a.m814B(sbM833U, this.ref, ")");
    }
}
