package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreSearch$SearchTarget {
    private final long id;
    private final StoreSearch$SearchTarget$Type type;

    public StoreSearch$SearchTarget(StoreSearch$SearchTarget$Type storeSearch$SearchTarget$Type, long j) {
        m.checkNotNullParameter(storeSearch$SearchTarget$Type, "type");
        this.type = storeSearch$SearchTarget$Type;
        this.id = j;
    }

    public static /* synthetic */ StoreSearch$SearchTarget copy$default(StoreSearch$SearchTarget storeSearch$SearchTarget, StoreSearch$SearchTarget$Type storeSearch$SearchTarget$Type, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            storeSearch$SearchTarget$Type = storeSearch$SearchTarget.type;
        }
        if ((i & 2) != 0) {
            j = storeSearch$SearchTarget.id;
        }
        return storeSearch$SearchTarget.copy(storeSearch$SearchTarget$Type, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreSearch$SearchTarget$Type getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final StoreSearch$SearchTarget copy(StoreSearch$SearchTarget$Type type, long id2) {
        m.checkNotNullParameter(type, "type");
        return new StoreSearch$SearchTarget(type, id2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreSearch$SearchTarget)) {
            return false;
        }
        StoreSearch$SearchTarget storeSearch$SearchTarget = (StoreSearch$SearchTarget) other;
        return m.areEqual(this.type, storeSearch$SearchTarget.type) && this.id == storeSearch$SearchTarget.id;
    }

    public final long getId() {
        return this.id;
    }

    public final StoreSearch$SearchTarget$Type getType() {
        return this.type;
    }

    public int hashCode() {
        StoreSearch$SearchTarget$Type storeSearch$SearchTarget$Type = this.type;
        return b.a(this.id) + ((storeSearch$SearchTarget$Type != null ? storeSearch$SearchTarget$Type.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("SearchTarget(type=");
        sbU.append(this.type);
        sbU.append(", id=");
        return a.C(sbU, this.id, ")");
    }
}
