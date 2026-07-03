package com.discord.api.application;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApplicationAsset.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationAsset {
    private final long id;
    private final String name;
    private final int type;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationAsset)) {
            return false;
        }
        ApplicationAsset applicationAsset = (ApplicationAsset) other;
        return this.id == applicationAsset.id && this.type == applicationAsset.type && C12238m.areEqual(this.name, applicationAsset.name);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + this.type) * 31;
        String str = this.name;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ApplicationAsset(id=");
        sbM833U.append(this.id);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", name=");
        return C1643a.m822J(sbM833U, this.name, ")");
    }
}
