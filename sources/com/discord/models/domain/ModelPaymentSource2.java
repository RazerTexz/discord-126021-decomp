package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.billing.ModelBillingAddress;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.models.domain.PatchPaymentSourceRaw, reason: use source file name */
/* JADX INFO: compiled from: ModelPaymentSource.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelPaymentSource2 {
    private final ModelBillingAddress billingAddress;
    private final boolean default;

    public ModelPaymentSource2(ModelBillingAddress modelBillingAddress, boolean z2) {
        Intrinsics3.checkNotNullParameter(modelBillingAddress, "billingAddress");
        this.billingAddress = modelBillingAddress;
        this.default = z2;
    }

    public static /* synthetic */ ModelPaymentSource2 copy$default(ModelPaymentSource2 modelPaymentSource2, ModelBillingAddress modelBillingAddress, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelBillingAddress = modelPaymentSource2.billingAddress;
        }
        if ((i & 2) != 0) {
            z2 = modelPaymentSource2.default;
        }
        return modelPaymentSource2.copy(modelBillingAddress, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    public final ModelPaymentSource2 copy(ModelBillingAddress billingAddress, boolean z2) {
        Intrinsics3.checkNotNullParameter(billingAddress, "billingAddress");
        return new ModelPaymentSource2(billingAddress, z2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelPaymentSource2)) {
            return false;
        }
        ModelPaymentSource2 modelPaymentSource2 = (ModelPaymentSource2) other;
        return Intrinsics3.areEqual(this.billingAddress, modelPaymentSource2.billingAddress) && this.default == modelPaymentSource2.default;
    }

    public final ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    public final boolean getDefault() {
        return this.default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        ModelBillingAddress modelBillingAddress = this.billingAddress;
        int iHashCode = (modelBillingAddress != null ? modelBillingAddress.hashCode() : 0) * 31;
        boolean z2 = this.default;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = outline.U("PatchPaymentSourceRaw(billingAddress=");
        sbU.append(this.billingAddress);
        sbU.append(", default=");
        return outline.O(sbU, this.default, ")");
    }
}
