package com.discord.models.domain.billing;

import b.d.b.a.outline;

/* JADX INFO: renamed from: com.discord.models.domain.billing.ModelInvoiceDiscount, reason: use source file name */
/* JADX INFO: compiled from: ModelInvoicePreview.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelInvoicePreview2 {
    private final int amount;
    private final int type;

    public ModelInvoicePreview2(int i, int i2) {
        this.amount = i;
        this.type = i2;
    }

    public static /* synthetic */ ModelInvoicePreview2 copy$default(ModelInvoicePreview2 modelInvoicePreview2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = modelInvoicePreview2.amount;
        }
        if ((i3 & 2) != 0) {
            i2 = modelInvoicePreview2.type;
        }
        return modelInvoicePreview2.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final ModelInvoicePreview2 copy(int amount, int type) {
        return new ModelInvoicePreview2(amount, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelInvoicePreview2)) {
            return false;
        }
        ModelInvoicePreview2 modelInvoicePreview2 = (ModelInvoicePreview2) other;
        return this.amount == modelInvoicePreview2.amount && this.type == modelInvoicePreview2.type;
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
        StringBuilder sbU = outline.U("ModelInvoiceDiscount(amount=");
        sbU.append(this.amount);
        sbU.append(", type=");
        return outline.B(sbU, this.type, ")");
    }
}
