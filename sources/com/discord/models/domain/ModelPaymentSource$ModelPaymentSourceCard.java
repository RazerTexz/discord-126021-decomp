package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.models.domain.billing.ModelBillingAddress;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelPaymentSource.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelPaymentSource$ModelPaymentSourceCard extends ModelPaymentSource {
    private final ModelBillingAddress billingAddress;
    private final String brand;
    private final boolean default;
    private final int expiresMonth;
    private final int expiresYear;
    private final String id;
    private final boolean invalid;
    private final String last4;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelPaymentSource$ModelPaymentSourceCard(String str, String str2, int i, int i2, String str3, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3) {
        super(str3, z2, modelBillingAddress, z3, null);
        m.checkNotNullParameter(str, "brand");
        m.checkNotNullParameter(str2, "last4");
        m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(modelBillingAddress, "billingAddress");
        this.brand = str;
        this.last4 = str2;
        this.expiresMonth = i;
        this.expiresYear = i2;
        this.id = str3;
        this.invalid = z2;
        this.billingAddress = modelBillingAddress;
        this.default = z3;
    }

    public static /* synthetic */ ModelPaymentSource$ModelPaymentSourceCard copy$default(ModelPaymentSource$ModelPaymentSourceCard modelPaymentSource$ModelPaymentSourceCard, String str, String str2, int i, int i2, String str3, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3, int i3, Object obj) {
        return modelPaymentSource$ModelPaymentSourceCard.copy((i3 & 1) != 0 ? modelPaymentSource$ModelPaymentSourceCard.brand : str, (i3 & 2) != 0 ? modelPaymentSource$ModelPaymentSourceCard.last4 : str2, (i3 & 4) != 0 ? modelPaymentSource$ModelPaymentSourceCard.expiresMonth : i, (i3 & 8) != 0 ? modelPaymentSource$ModelPaymentSourceCard.expiresYear : i2, (i3 & 16) != 0 ? modelPaymentSource$ModelPaymentSourceCard.getId() : str3, (i3 & 32) != 0 ? modelPaymentSource$ModelPaymentSourceCard.getInvalid() : z2, (i3 & 64) != 0 ? modelPaymentSource$ModelPaymentSourceCard.getBillingAddress() : modelBillingAddress, (i3 & 128) != 0 ? modelPaymentSource$ModelPaymentSourceCard.getDefault() : z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLast4() {
        return this.last4;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getExpiresMonth() {
        return this.expiresMonth;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getExpiresYear() {
        return this.expiresYear;
    }

    public final String component5() {
        return getId();
    }

    public final boolean component6() {
        return getInvalid();
    }

    public final ModelBillingAddress component7() {
        return getBillingAddress();
    }

    public final boolean component8() {
        return getDefault();
    }

    public final ModelPaymentSource$ModelPaymentSourceCard copy(String brand, String last4, int expiresMonth, int expiresYear, String id2, boolean invalid, ModelBillingAddress billingAddress, boolean z2) {
        m.checkNotNullParameter(brand, "brand");
        m.checkNotNullParameter(last4, "last4");
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(billingAddress, "billingAddress");
        return new ModelPaymentSource$ModelPaymentSourceCard(brand, last4, expiresMonth, expiresYear, id2, invalid, billingAddress, z2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelPaymentSource$ModelPaymentSourceCard)) {
            return false;
        }
        ModelPaymentSource$ModelPaymentSourceCard modelPaymentSource$ModelPaymentSourceCard = (ModelPaymentSource$ModelPaymentSourceCard) other;
        return m.areEqual(this.brand, modelPaymentSource$ModelPaymentSourceCard.brand) && m.areEqual(this.last4, modelPaymentSource$ModelPaymentSourceCard.last4) && this.expiresMonth == modelPaymentSource$ModelPaymentSourceCard.expiresMonth && this.expiresYear == modelPaymentSource$ModelPaymentSourceCard.expiresYear && m.areEqual(getId(), modelPaymentSource$ModelPaymentSourceCard.getId()) && getInvalid() == modelPaymentSource$ModelPaymentSourceCard.getInvalid() && m.areEqual(getBillingAddress(), modelPaymentSource$ModelPaymentSourceCard.getBillingAddress()) && getDefault() == modelPaymentSource$ModelPaymentSourceCard.getDefault();
    }

    @Override // com.discord.models.domain.ModelPaymentSource
    public ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    public final String getBrand() {
        return this.brand;
    }

    @Override // com.discord.models.domain.ModelPaymentSource
    public boolean getDefault() {
        return this.default;
    }

    public final int getExpiresMonth() {
        return this.expiresMonth;
    }

    public final int getExpiresYear() {
        return this.expiresYear;
    }

    @Override // com.discord.models.domain.ModelPaymentSource
    public String getId() {
        return this.id;
    }

    @Override // com.discord.models.domain.ModelPaymentSource
    public boolean getInvalid() {
        return this.invalid;
    }

    public final String getLast4() {
        return this.last4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.brand;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.last4;
        int iHashCode2 = (((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.expiresMonth) * 31) + this.expiresYear) * 31;
        String id2 = getId();
        int iHashCode3 = (iHashCode2 + (id2 != null ? id2.hashCode() : 0)) * 31;
        boolean invalid = getInvalid();
        int i = invalid;
        if (invalid) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        ModelBillingAddress billingAddress = getBillingAddress();
        int iHashCode4 = (i2 + (billingAddress != null ? billingAddress.hashCode() : 0)) * 31;
        boolean z2 = getDefault();
        return iHashCode4 + (z2 ? 1 : z2);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelPaymentSourceCard(brand=");
        sbU.append(this.brand);
        sbU.append(", last4=");
        sbU.append(this.last4);
        sbU.append(", expiresMonth=");
        sbU.append(this.expiresMonth);
        sbU.append(", expiresYear=");
        sbU.append(this.expiresYear);
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
