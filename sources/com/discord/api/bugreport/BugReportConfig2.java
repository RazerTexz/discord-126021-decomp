package com.discord.api.bugreport;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.bugreport.Feature, reason: use source file name */
/* JADX INFO: compiled from: BugReportConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class BugReportConfig2 {
    private final Long asanaInboxId;
    private final String name;
    private final String squad;

    public BugReportConfig2(String str, String str2, Long l) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "squad");
        this.name = str;
        this.squad = str2;
        this.asanaInboxId = l;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Long getAsanaInboxId() {
        return this.asanaInboxId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getSquad() {
        return this.squad;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BugReportConfig2)) {
            return false;
        }
        BugReportConfig2 bugReportConfig2 = (BugReportConfig2) other;
        return Intrinsics3.areEqual(this.name, bugReportConfig2.name) && Intrinsics3.areEqual(this.squad, bugReportConfig2.squad) && Intrinsics3.areEqual(this.asanaInboxId, bugReportConfig2.asanaInboxId);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.squad;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.asanaInboxId;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Feature(name=");
        sbU.append(this.name);
        sbU.append(", squad=");
        sbU.append(this.squad);
        sbU.append(", asanaInboxId=");
        return outline.G(sbU, this.asanaInboxId, ")");
    }
}
