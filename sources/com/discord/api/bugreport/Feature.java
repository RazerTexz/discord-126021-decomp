package com.discord.api.bugreport;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BugReportConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Feature {
    private final Long asanaInboxId;
    private final String name;
    private final String squad;

    public Feature(String str, String str2, Long l) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "squad");
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
        if (!(other instanceof Feature)) {
            return false;
        }
        Feature feature = (Feature) other;
        return C12238m.areEqual(this.name, feature.name) && C12238m.areEqual(this.squad, feature.squad) && C12238m.areEqual(this.asanaInboxId, feature.asanaInboxId);
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
        StringBuilder sbM833U = C1643a.m833U("Feature(name=");
        sbM833U.append(this.name);
        sbM833U.append(", squad=");
        sbM833U.append(this.squad);
        sbM833U.append(", asanaInboxId=");
        return C1643a.m819G(sbM833U, this.asanaInboxId, ")");
    }
}
