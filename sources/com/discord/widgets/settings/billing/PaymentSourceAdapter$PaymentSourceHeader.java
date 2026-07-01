package com.discord.widgets.settings.billing;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: PaymentSourceAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PaymentSourceAdapter$PaymentSourceHeader implements PaymentSourceAdapter$Item {
    private final PaymentSourceAdapter$PaymentSourceHeader$Type headerType;
    private final String key;
    private final int type;

    public PaymentSourceAdapter$PaymentSourceHeader(PaymentSourceAdapter$PaymentSourceHeader$Type paymentSourceAdapter$PaymentSourceHeader$Type) {
        m.checkNotNullParameter(paymentSourceAdapter$PaymentSourceHeader$Type, "headerType");
        this.headerType = paymentSourceAdapter$PaymentSourceHeader$Type;
        this.type = 2;
        this.key = "headerType" + paymentSourceAdapter$PaymentSourceHeader$Type;
    }

    public static /* synthetic */ PaymentSourceAdapter$PaymentSourceHeader copy$default(PaymentSourceAdapter$PaymentSourceHeader paymentSourceAdapter$PaymentSourceHeader, PaymentSourceAdapter$PaymentSourceHeader$Type paymentSourceAdapter$PaymentSourceHeader$Type, int i, Object obj) {
        if ((i & 1) != 0) {
            paymentSourceAdapter$PaymentSourceHeader$Type = paymentSourceAdapter$PaymentSourceHeader.headerType;
        }
        return paymentSourceAdapter$PaymentSourceHeader.copy(paymentSourceAdapter$PaymentSourceHeader$Type);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PaymentSourceAdapter$PaymentSourceHeader$Type getHeaderType() {
        return this.headerType;
    }

    public final PaymentSourceAdapter$PaymentSourceHeader copy(PaymentSourceAdapter$PaymentSourceHeader$Type headerType) {
        m.checkNotNullParameter(headerType, "headerType");
        return new PaymentSourceAdapter$PaymentSourceHeader(headerType);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PaymentSourceAdapter$PaymentSourceHeader) && m.areEqual(this.headerType, ((PaymentSourceAdapter$PaymentSourceHeader) other).headerType);
        }
        return true;
    }

    public final PaymentSourceAdapter$PaymentSourceHeader$Type getHeaderType() {
        return this.headerType;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        PaymentSourceAdapter$PaymentSourceHeader$Type paymentSourceAdapter$PaymentSourceHeader$Type = this.headerType;
        if (paymentSourceAdapter$PaymentSourceHeader$Type != null) {
            return paymentSourceAdapter$PaymentSourceHeader$Type.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("PaymentSourceHeader(headerType=");
        sbU.append(this.headerType);
        sbU.append(")");
        return sbU.toString();
    }
}
