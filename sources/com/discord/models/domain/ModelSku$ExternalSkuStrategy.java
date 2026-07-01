package com.discord.models.domain;

import b.d.b.a.a;

/* JADX INFO: compiled from: ModelSku.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSku$ExternalSkuStrategy {
    private final int type;

    public ModelSku$ExternalSkuStrategy(int i) {
        this.type = i;
    }

    public static /* synthetic */ ModelSku$ExternalSkuStrategy copy$default(ModelSku$ExternalSkuStrategy modelSku$ExternalSkuStrategy, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = modelSku$ExternalSkuStrategy.type;
        }
        return modelSku$ExternalSkuStrategy.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final ModelSku$ExternalSkuStrategy copy(int type) {
        return new ModelSku$ExternalSkuStrategy(type);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelSku$ExternalSkuStrategy) && this.type == ((ModelSku$ExternalSkuStrategy) other).type;
        }
        return true;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type;
    }

    public String toString() {
        return a.B(a.U("ExternalSkuStrategy(type="), this.type, ")");
    }

    /* JADX INFO: renamed from: getType, reason: collision with other method in class */
    public final ModelSku$ExternalStrategyTypes m6getType() {
        return ModelSku$ExternalStrategyTypes.Companion.from(this.type);
    }
}
