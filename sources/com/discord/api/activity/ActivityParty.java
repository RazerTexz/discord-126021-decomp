package com.discord.api.activity;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActivityParty.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActivityParty {
    private final String id;
    private final List<Long> size;

    public ActivityParty(String str, List<Long> list) {
        this.id = str;
        this.size = list;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b */
    public final List<Long> m7559b() {
        return this.size;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityParty)) {
            return false;
        }
        ActivityParty activityParty = (ActivityParty) other;
        return C12238m.areEqual(this.id, activityParty.id) && C12238m.areEqual(this.size, activityParty.size);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Long> list = this.size;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ActivityParty(id=");
        sbM833U.append(this.id);
        sbM833U.append(", size=");
        return C1643a.m824L(sbM833U, this.size, ")");
    }
}
