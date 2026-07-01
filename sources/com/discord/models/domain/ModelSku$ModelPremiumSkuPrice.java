package com.discord.models.domain;

import b.d.b.a.a;

/* JADX INFO: compiled from: ModelSku.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSku$ModelPremiumSkuPrice {
    private final int amount;
    private final int percentage;

    public ModelSku$ModelPremiumSkuPrice(int i, int i2) {
        this.amount = i;
        this.percentage = i2;
    }

    public static /* synthetic */ ModelSku$ModelPremiumSkuPrice copy$default(ModelSku$ModelPremiumSkuPrice modelSku$ModelPremiumSkuPrice, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = modelSku$ModelPremiumSkuPrice.amount;
        }
        if ((i3 & 2) != 0) {
            i2 = modelSku$ModelPremiumSkuPrice.percentage;
        }
        return modelSku$ModelPremiumSkuPrice.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPercentage() {
        return this.percentage;
    }

    public final ModelSku$ModelPremiumSkuPrice copy(int amount, int percentage) {
        return new ModelSku$ModelPremiumSkuPrice(amount, percentage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSku$ModelPremiumSkuPrice)) {
            return false;
        }
        ModelSku$ModelPremiumSkuPrice modelSku$ModelPremiumSkuPrice = (ModelSku$ModelPremiumSkuPrice) other;
        return this.amount == modelSku$ModelPremiumSkuPrice.amount && this.percentage == modelSku$ModelPremiumSkuPrice.percentage;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final int getPercentage() {
        return this.percentage;
    }

    public int hashCode() {
        return (this.amount * 31) + this.percentage;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelPremiumSkuPrice(amount=");
        sbU.append(this.amount);
        sbU.append(", percentage=");
        return a.B(sbU, this.percentage, ")");
    }
}
