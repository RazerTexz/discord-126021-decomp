package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.models.domain.billing.ModelBillingAddress;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelPaymentSource.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelPaymentSource$ModelPaymentSourcePaypal extends ModelPaymentSource {
    private final ModelBillingAddress billingAddress;
    private final boolean default;
    private final String email;
    private final String id;
    private final boolean invalid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelPaymentSource$ModelPaymentSourcePaypal(String str, String str2, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3) {
        super(str2, z2, modelBillingAddress, z3, null);
        m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(modelBillingAddress, "billingAddress");
        this.email = str;
        this.id = str2;
        this.invalid = z2;
        this.billingAddress = modelBillingAddress;
        this.default = z3;
    }

    public static /* synthetic */ ModelPaymentSource$ModelPaymentSourcePaypal copy$default(ModelPaymentSource$ModelPaymentSourcePaypal modelPaymentSource$ModelPaymentSourcePaypal, String str, String str2, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelPaymentSource$ModelPaymentSourcePaypal.email;
        }
        if ((i & 2) != 0) {
            str2 = modelPaymentSource$ModelPaymentSourcePaypal.getId();
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z2 = modelPaymentSource$ModelPaymentSourcePaypal.getInvalid();
        }
        boolean z4 = z2;
        if ((i & 8) != 0) {
            modelBillingAddress = modelPaymentSource$ModelPaymentSourcePaypal.getBillingAddress();
        }
        ModelBillingAddress modelBillingAddress2 = modelBillingAddress;
        if ((i & 16) != 0) {
            z3 = modelPaymentSource$ModelPaymentSourcePaypal.getDefault();
        }
        return modelPaymentSource$ModelPaymentSourcePaypal.copy(str, str3, z4, modelBillingAddress2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final String component2() {
        return getId();
    }

    public final boolean component3() {
        return getInvalid();
    }

    public final ModelBillingAddress component4() {
        return getBillingAddress();
    }

    public final boolean component5() {
        return getDefault();
    }

    public final ModelPaymentSource$ModelPaymentSourcePaypal copy(String email, String id2, boolean invalid, ModelBillingAddress billingAddress, boolean z2) {
        m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(billingAddress, "billingAddress");
        return new ModelPaymentSource$ModelPaymentSourcePaypal(email, id2, invalid, billingAddress, z2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelPaymentSource$ModelPaymentSourcePaypal)) {
            return false;
        }
        ModelPaymentSource$ModelPaymentSourcePaypal modelPaymentSource$ModelPaymentSourcePaypal = (ModelPaymentSource$ModelPaymentSourcePaypal) other;
        return m.areEqual(this.email, modelPaymentSource$ModelPaymentSourcePaypal.email) && m.areEqual(getId(), modelPaymentSource$ModelPaymentSourcePaypal.getId()) && getInvalid() == modelPaymentSource$ModelPaymentSourcePaypal.getInvalid() && m.areEqual(getBillingAddress(), modelPaymentSource$ModelPaymentSourcePaypal.getBillingAddress()) && getDefault() == modelPaymentSource$ModelPaymentSourcePaypal.getDefault();
    }

    @Override // com.discord.models.domain.ModelPaymentSource
    public ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    @Override // com.discord.models.domain.ModelPaymentSource
    public boolean getDefault() {
        return this.default;
    }

    public final String getEmail() {
        return this.email;
    }

    @Override // com.discord.models.domain.ModelPaymentSource
    public String getId() {
        return this.id;
    }

    @Override // com.discord.models.domain.ModelPaymentSource
    public boolean getInvalid() {
        return this.invalid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String id2 = getId();
        int iHashCode2 = (iHashCode + (id2 != null ? id2.hashCode() : 0)) * 31;
        boolean invalid = getInvalid();
        int i = invalid;
        if (invalid) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        ModelBillingAddress billingAddress = getBillingAddress();
        int iHashCode3 = (i2 + (billingAddress != null ? billingAddress.hashCode() : 0)) * 31;
        boolean z2 = getDefault();
        return iHashCode3 + (z2 ? 1 : z2);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelPaymentSourcePaypal(email=");
        sbU.append(this.email);
        sbU.append(", id=");
        sbU.append(getId());
        sbU.append(", invalid=");
        sbU.append(getInvalid());
        sbU.append(", billingAddress=");
        sbU.append(getBillingAddress());
        sbU.append(", default=");
        sbU.append(getDefault());
        sbU.append(")");
        return sbU.toString();
    }
}
