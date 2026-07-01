package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelStoreListing.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelStoreListing {
    private final long id;
    private final ModelSku sku;

    public ModelStoreListing(ModelSku modelSku, long j) {
        m.checkNotNullParameter(modelSku, "sku");
        this.sku = modelSku;
        this.id = j;
    }

    public static /* synthetic */ ModelStoreListing copy$default(ModelStoreListing modelStoreListing, ModelSku modelSku, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            modelSku = modelStoreListing.sku;
        }
        if ((i & 2) != 0) {
            j = modelStoreListing.id;
        }
        return modelStoreListing.copy(modelSku, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelSku getSku() {
        return this.sku;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final ModelStoreListing copy(ModelSku sku, long id2) {
        m.checkNotNullParameter(sku, "sku");
        return new ModelStoreListing(sku, id2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStoreListing)) {
            return false;
        }
        ModelStoreListing modelStoreListing = (ModelStoreListing) other;
        return m.areEqual(this.sku, modelStoreListing.sku) && this.id == modelStoreListing.id;
    }

    public final long getId() {
        return this.id;
    }

    public final ModelSku getSku() {
        return this.sku;
    }

    public int hashCode() {
        ModelSku modelSku = this.sku;
        int iHashCode = modelSku != null ? modelSku.hashCode() : 0;
        long j = this.id;
        return (iHashCode * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelStoreListing(sku=");
        sbU.append(this.sku);
        sbU.append(", id=");
        return a.C(sbU, this.id, ")");
    }
}
