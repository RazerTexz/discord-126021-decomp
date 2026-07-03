package com.discord.models.store.dto;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelStoreDirectoryLayout.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelStoreDirectoryLayout {
    private final List<Long> allSkus;
    private final long id;

    public ModelStoreDirectoryLayout(long j, List<Long> list) {
        C12238m.checkNotNullParameter(list, "allSkus");
        this.id = j;
        this.allSkus = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelStoreDirectoryLayout copy$default(ModelStoreDirectoryLayout modelStoreDirectoryLayout, long j, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelStoreDirectoryLayout.id;
        }
        if ((i & 2) != 0) {
            list = modelStoreDirectoryLayout.allSkus;
        }
        return modelStoreDirectoryLayout.copy(j, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<Long> component2() {
        return this.allSkus;
    }

    public final ModelStoreDirectoryLayout copy(long id2, List<Long> allSkus) {
        C12238m.checkNotNullParameter(allSkus, "allSkus");
        return new ModelStoreDirectoryLayout(id2, allSkus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStoreDirectoryLayout)) {
            return false;
        }
        ModelStoreDirectoryLayout modelStoreDirectoryLayout = (ModelStoreDirectoryLayout) other;
        return this.id == modelStoreDirectoryLayout.id && C12238m.areEqual(this.allSkus, modelStoreDirectoryLayout.allSkus);
    }

    public final List<Long> getAllSkus() {
        return this.allSkus;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<Long> list = this.allSkus;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelStoreDirectoryLayout(id=");
        sbM833U.append(this.id);
        sbM833U.append(", allSkus=");
        return C1643a.m824L(sbM833U, this.allSkus, ")");
    }
}
