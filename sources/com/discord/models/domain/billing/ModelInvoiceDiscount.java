package com.discord.models.domain.billing;

import b.d.b.a.a;

/* JADX INFO: compiled from: ModelInvoicePreview.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelInvoiceDiscount {
    private final int amount;
    private final int type;

    public ModelInvoiceDiscount(int i, int i2) {
        this.amount = i;
        this.type = i2;
    }

    public static /* synthetic */ ModelInvoiceDiscount copy$default(ModelInvoiceDiscount modelInvoiceDiscount, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = modelInvoiceDiscount.amount;
        }
        if ((i3 & 2) != 0) {
            i2 = modelInvoiceDiscount.type;
        }
        return modelInvoiceDiscount.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final ModelInvoiceDiscount copy(int amount, int type) {
        return new ModelInvoiceDiscount(amount, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelInvoiceDiscount)) {
            return false;
        }
        ModelInvoiceDiscount modelInvoiceDiscount = (ModelInvoiceDiscount) other;
        return this.amount == modelInvoiceDiscount.amount && this.type == modelInvoiceDiscount.type;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.amount * 31) + this.type;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelInvoiceDiscount(amount=");
        sbU.append(this.amount);
        sbU.append(", type=");
        return a.B(sbU, this.type, ")");
    }
}
