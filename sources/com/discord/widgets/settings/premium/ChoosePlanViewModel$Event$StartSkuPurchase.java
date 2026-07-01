package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.android.billingclient.api.BillingFlowParams;
import d0.z.d.m;

/* JADX INFO: compiled from: ChoosePlanViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChoosePlanViewModel$Event$StartSkuPurchase extends ChoosePlanViewModel$Event {
    private final BillingFlowParams billingParams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChoosePlanViewModel$Event$StartSkuPurchase(BillingFlowParams billingFlowParams) {
        super(null);
        m.checkNotNullParameter(billingFlowParams, "billingParams");
        this.billingParams = billingFlowParams;
    }

    public static /* synthetic */ ChoosePlanViewModel$Event$StartSkuPurchase copy$default(ChoosePlanViewModel$Event$StartSkuPurchase choosePlanViewModel$Event$StartSkuPurchase, BillingFlowParams billingFlowParams, int i, Object obj) {
        if ((i & 1) != 0) {
            billingFlowParams = choosePlanViewModel$Event$StartSkuPurchase.billingParams;
        }
        return choosePlanViewModel$Event$StartSkuPurchase.copy(billingFlowParams);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BillingFlowParams getBillingParams() {
        return this.billingParams;
    }

    public final ChoosePlanViewModel$Event$StartSkuPurchase copy(BillingFlowParams billingParams) {
        m.checkNotNullParameter(billingParams, "billingParams");
        return new ChoosePlanViewModel$Event$StartSkuPurchase(billingParams);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ChoosePlanViewModel$Event$StartSkuPurchase) && m.areEqual(this.billingParams, ((ChoosePlanViewModel$Event$StartSkuPurchase) other).billingParams);
        }
        return true;
    }

    public final BillingFlowParams getBillingParams() {
        return this.billingParams;
    }

    public int hashCode() {
        BillingFlowParams billingFlowParams = this.billingParams;
        if (billingFlowParams != null) {
            return billingFlowParams.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("StartSkuPurchase(billingParams=");
        sbU.append(this.billingParams);
        sbU.append(")");
        return sbU.toString();
    }
}
