package com.discord.api.activity;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

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

    public final List<Long> b() {
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
        return m.areEqual(this.id, activityParty.id) && m.areEqual(this.size, activityParty.size);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Long> list = this.size;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ActivityParty(id=");
        sbU.append(this.id);
        sbU.append(", size=");
        return a.L(sbU, this.size, ")");
    }
}
