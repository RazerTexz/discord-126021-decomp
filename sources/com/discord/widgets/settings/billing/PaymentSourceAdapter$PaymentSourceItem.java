package com.discord.widgets.settings.billing;

import b.d.b.a.a;
import com.discord.models.domain.ModelPaymentSource;
import d0.z.d.m;

/* JADX INFO: compiled from: PaymentSourceAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PaymentSourceAdapter$PaymentSourceItem implements PaymentSourceAdapter$Item {
    private final boolean isPremium;
    private final String key;
    private final ModelPaymentSource paymentSource;
    private final int type;

    public PaymentSourceAdapter$PaymentSourceItem(ModelPaymentSource modelPaymentSource, boolean z2) {
        m.checkNotNullParameter(modelPaymentSource, "paymentSource");
        this.paymentSource = modelPaymentSource;
        this.isPremium = z2;
        this.key = modelPaymentSource.getId();
    }

    public static /* synthetic */ PaymentSourceAdapter$PaymentSourceItem copy$default(PaymentSourceAdapter$PaymentSourceItem paymentSourceAdapter$PaymentSourceItem, ModelPaymentSource modelPaymentSource, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelPaymentSource = paymentSourceAdapter$PaymentSourceItem.paymentSource;
        }
        if ((i & 2) != 0) {
            z2 = paymentSourceAdapter$PaymentSourceItem.isPremium;
        }
        return paymentSourceAdapter$PaymentSourceItem.copy(modelPaymentSource, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelPaymentSource getPaymentSource() {
        return this.paymentSource;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsPremium() {
        return this.isPremium;
    }

    public final PaymentSourceAdapter$PaymentSourceItem copy(ModelPaymentSource paymentSource, boolean isPremium) {
        m.checkNotNullParameter(paymentSource, "paymentSource");
        return new PaymentSourceAdapter$PaymentSourceItem(paymentSource, isPremium);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentSourceAdapter$PaymentSourceItem)) {
            return false;
        }
        PaymentSourceAdapter$PaymentSourceItem paymentSourceAdapter$PaymentSourceItem = (PaymentSourceAdapter$PaymentSourceItem) other;
        return m.areEqual(this.paymentSource, paymentSourceAdapter$PaymentSourceItem.paymentSource) && this.isPremium == paymentSourceAdapter$PaymentSourceItem.isPremium;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final ModelPaymentSource getPaymentSource() {
        return this.paymentSource;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        ModelPaymentSource modelPaymentSource = this.paymentSource;
        int iHashCode = (modelPaymentSource != null ? modelPaymentSource.hashCode() : 0) * 31;
        boolean z2 = this.isPremium;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isPremium() {
        return this.isPremium;
    }

    public String toString() {
        StringBuilder sbU = a.U("PaymentSourceItem(paymentSource=");
        sbU.append(this.paymentSource);
        sbU.append(", isPremium=");
        return a.O(sbU, this.isPremium, ")");
    }
}
