package com.discord.api.application;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

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
        return this.id == applicationAsset.id && this.type == applicationAsset.type && m.areEqual(this.name, applicationAsset.name);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + this.type) * 31;
        String str = this.name;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ApplicationAsset(id=");
        sbU.append(this.id);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", name=");
        return a.J(sbU, this.name, ")");
    }
}
