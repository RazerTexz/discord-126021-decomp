package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.billing.ModelBillingAddress;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.models.domain.PaymentSourceRaw, reason: use source file name */
/* JADX INFO: compiled from: ModelPaymentSource.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelPaymentSource3 {
    private final ModelBillingAddress billingAddress;
    private final String brand;
    private final boolean default;
    private final String email;
    private final int expiresMonth;
    private final int expiresYear;
    private final String id;
    private final boolean invalid;
    private final String last_4;
    private final int type;

    public ModelPaymentSource3(int i, String str, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3, String str2, String str3, String str4, int i2, int i3) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(modelBillingAddress, "billingAddress");
        this.type = i;
        this.id = str;
        this.invalid = z2;
        this.billingAddress = modelBillingAddress;
        this.default = z3;
        this.email = str2;
        this.brand = str3;
        this.last_4 = str4;
        this.expiresMonth = i2;
        this.expiresYear = i3;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getExpiresYear() {
        return this.expiresYear;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getInvalid() {
        return this.invalid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLast_4() {
        return this.last_4;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getExpiresMonth() {
        return this.expiresMonth;
    }

    public final ModelPaymentSource3 copy(int type, String id2, boolean invalid, ModelBillingAddress billingAddress, boolean z2, String email, String brand, String last_4, int expiresMonth, int expiresYear) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(billingAddress, "billingAddress");
        return new ModelPaymentSource3(type, id2, invalid, billingAddress, z2, email, brand, last_4, expiresMonth, expiresYear);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelPaymentSource3)) {
            return false;
        }
        ModelPaymentSource3 modelPaymentSource3 = (ModelPaymentSource3) other;
        return this.type == modelPaymentSource3.type && Intrinsics3.areEqual(this.id, modelPaymentSource3.id) && this.invalid == modelPaymentSource3.invalid && Intrinsics3.areEqual(this.billingAddress, modelPaymentSource3.billingAddress) && this.default == modelPaymentSource3.default && Intrinsics3.areEqual(this.email, modelPaymentSource3.email) && Intrinsics3.areEqual(this.brand, modelPaymentSource3.brand) && Intrinsics3.areEqual(this.last_4, modelPaymentSource3.last_4) && this.expiresMonth == modelPaymentSource3.expiresMonth && this.expiresYear == modelPaymentSource3.expiresYear;
    }

    public final ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final boolean getDefault() {
        return this.default;
    }

    public final String getEmail() {
        return this.email;
    }

    public final int getExpiresMonth() {
        return this.expiresMonth;
    }

    public final int getExpiresYear() {
        return this.expiresYear;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getInvalid() {
        return this.invalid;
    }

    public final String getLast_4() {
        return this.last_4;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int i = this.type * 31;
        String str = this.id;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.invalid;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (iHashCode + r1) * 31;
        ModelBillingAddress modelBillingAddress = this.billingAddress;
        int iHashCode2 = (i2 + (modelBillingAddress != null ? modelBillingAddress.hashCode() : 0)) * 31;
        boolean z3 = this.default;
        int i3 = (iHashCode2 + (z3 ? 1 : z3)) * 31;
        String str2 = this.email;
        int iHashCode3 = (i3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.brand;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.last_4;
        return ((((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.expiresMonth) * 31) + this.expiresYear;
    }

    public String toString() {
        StringBuilder sbU = outline.U("PaymentSourceRaw(type=");
        sbU.append(this.type);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", invalid=");
        sbU.append(this.invalid);
        sbU.append(", billingAddress=");
        sbU.append(this.billingAddress);
        sbU.append(", default=");
        sbU.append(this.default);
        sbU.append(", email=");
        sbU.append(this.email);
        sbU.append(", brand=");
        sbU.append(this.brand);
        sbU.append(", last_4=");
        sbU.append(this.last_4);
        sbU.append(", expiresMonth=");
        sbU.append(this.expiresMonth);
        sbU.append(", expiresYear=");
        return outline.B(sbU, this.expiresYear, ")");
    }
}
