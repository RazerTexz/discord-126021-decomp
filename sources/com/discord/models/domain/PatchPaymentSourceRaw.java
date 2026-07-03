package com.discord.models.domain;

import com.discord.models.domain.billing.ModelBillingAddress;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelPaymentSource.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PatchPaymentSourceRaw {
    private final ModelBillingAddress billingAddress;
    private final boolean default;

    public PatchPaymentSourceRaw(ModelBillingAddress modelBillingAddress, boolean z2) {
        C12238m.checkNotNullParameter(modelBillingAddress, "billingAddress");
        this.billingAddress = modelBillingAddress;
        this.default = z2;
    }

    public static /* synthetic */ PatchPaymentSourceRaw copy$default(PatchPaymentSourceRaw patchPaymentSourceRaw, ModelBillingAddress modelBillingAddress, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelBillingAddress = patchPaymentSourceRaw.billingAddress;
        }
        if ((i & 2) != 0) {
            z2 = patchPaymentSourceRaw.default;
        }
        return patchPaymentSourceRaw.copy(modelBillingAddress, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    public final PatchPaymentSourceRaw copy(ModelBillingAddress billingAddress, boolean z2) {
        C12238m.checkNotNullParameter(billingAddress, "billingAddress");
        return new PatchPaymentSourceRaw(billingAddress, z2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PatchPaymentSourceRaw)) {
            return false;
        }
        PatchPaymentSourceRaw patchPaymentSourceRaw = (PatchPaymentSourceRaw) other;
        return C12238m.areEqual(this.billingAddress, patchPaymentSourceRaw.billingAddress) && this.default == patchPaymentSourceRaw.default;
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
        StringBuilder sbM833U = C1643a.m833U("PatchPaymentSourceRaw(billingAddress=");
        sbM833U.append(this.billingAddress);
        sbM833U.append(", default=");
        return C1643a.m827O(sbM833U, this.default, ")");
    }
}
