package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.billing.ModelBillingAddress;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelPaymentSource.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class ModelPaymentSource {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int PAYMENT_SOURCE_TYPE_CARD = 1;
    private static final int PAYMENT_SOURCE_TYPE_PAYPAL = 2;
    private final ModelBillingAddress billingAddress;
    private final boolean default;
    private final String id;
    private final boolean invalid;

    /* JADX INFO: compiled from: ModelPaymentSource.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ModelPaymentSource wrap(ModelPaymentSource3 raw) throws UnableToWrapException {
            Intrinsics3.checkNotNullParameter(raw, "raw");
            try {
                int type = raw.getType();
                if (type == 1) {
                    String brand = raw.getBrand();
                    Intrinsics3.checkNotNull(brand);
                    String last_4 = raw.getLast_4();
                    Intrinsics3.checkNotNull(last_4);
                    return new ModelPaymentSourceCard(brand, last_4, raw.getExpiresMonth(), raw.getExpiresYear(), raw.getId(), raw.getInvalid(), raw.getBillingAddress(), raw.getDefault());
                }
                if (type == 2) {
                    String email = raw.getEmail();
                    Intrinsics3.checkNotNull(email);
                    return new ModelPaymentSourcePaypal(email, raw.getId(), raw.getInvalid(), raw.getBillingAddress(), raw.getDefault());
                }
                throw new IllegalArgumentException("unsupported payment source type: " + raw.getType());
            } catch (Throwable th) {
                throw new UnableToWrapException(th);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ModelPaymentSource.kt */
    public static final /* data */ class ModelPaymentSourceCard extends ModelPaymentSource {
        private final ModelBillingAddress billingAddress;
        private final String brand;
        private final boolean default;
        private final int expiresMonth;
        private final int expiresYear;
        private final String id;
        private final boolean invalid;
        private final String last4;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModelPaymentSourceCard(String str, String str2, int i, int i2, String str3, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3) {
            super(str3, z2, modelBillingAddress, z3, null);
            Intrinsics3.checkNotNullParameter(str, "brand");
            Intrinsics3.checkNotNullParameter(str2, "last4");
            Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(modelBillingAddress, "billingAddress");
            this.brand = str;
            this.last4 = str2;
            this.expiresMonth = i;
            this.expiresYear = i2;
            this.id = str3;
            this.invalid = z2;
            this.billingAddress = modelBillingAddress;
            this.default = z3;
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

        public final ModelPaymentSourceCard copy(String brand, String last4, int expiresMonth, int expiresYear, String id2, boolean invalid, ModelBillingAddress billingAddress, boolean z2) {
            Intrinsics3.checkNotNullParameter(brand, "brand");
            Intrinsics3.checkNotNullParameter(last4, "last4");
            Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(billingAddress, "billingAddress");
            return new ModelPaymentSourceCard(brand, last4, expiresMonth, expiresYear, id2, invalid, billingAddress, z2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModelPaymentSourceCard)) {
                return false;
            }
            ModelPaymentSourceCard modelPaymentSourceCard = (ModelPaymentSourceCard) other;
            return Intrinsics3.areEqual(this.brand, modelPaymentSourceCard.brand) && Intrinsics3.areEqual(this.last4, modelPaymentSourceCard.last4) && this.expiresMonth == modelPaymentSourceCard.expiresMonth && this.expiresYear == modelPaymentSourceCard.expiresYear && Intrinsics3.areEqual(getId(), modelPaymentSourceCard.getId()) && getInvalid() == modelPaymentSourceCard.getInvalid() && Intrinsics3.areEqual(getBillingAddress(), modelPaymentSourceCard.getBillingAddress()) && getDefault() == modelPaymentSourceCard.getDefault();
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
            StringBuilder sbU = outline.U("ModelPaymentSourceCard(brand=");
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

    /* JADX INFO: compiled from: ModelPaymentSource.kt */
    public static final /* data */ class ModelPaymentSourcePaypal extends ModelPaymentSource {
        private final ModelBillingAddress billingAddress;
        private final boolean default;
        private final String email;
        private final String id;
        private final boolean invalid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModelPaymentSourcePaypal(String str, String str2, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3) {
            super(str2, z2, modelBillingAddress, z3, null);
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
            Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(modelBillingAddress, "billingAddress");
            this.email = str;
            this.id = str2;
            this.invalid = z2;
            this.billingAddress = modelBillingAddress;
            this.default = z3;
        }

        public static /* synthetic */ ModelPaymentSourcePaypal copy$default(ModelPaymentSourcePaypal modelPaymentSourcePaypal, String str, String str2, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = modelPaymentSourcePaypal.email;
            }
            if ((i & 2) != 0) {
                str2 = modelPaymentSourcePaypal.getId();
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                z2 = modelPaymentSourcePaypal.getInvalid();
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                modelBillingAddress = modelPaymentSourcePaypal.getBillingAddress();
            }
            ModelBillingAddress modelBillingAddress2 = modelBillingAddress;
            if ((i & 16) != 0) {
                z3 = modelPaymentSourcePaypal.getDefault();
            }
            return modelPaymentSourcePaypal.copy(str, str3, z4, modelBillingAddress2, z3);
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

        public final ModelPaymentSourcePaypal copy(String email, String id2, boolean invalid, ModelBillingAddress billingAddress, boolean z2) {
            Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
            Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(billingAddress, "billingAddress");
            return new ModelPaymentSourcePaypal(email, id2, invalid, billingAddress, z2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModelPaymentSourcePaypal)) {
                return false;
            }
            ModelPaymentSourcePaypal modelPaymentSourcePaypal = (ModelPaymentSourcePaypal) other;
            return Intrinsics3.areEqual(this.email, modelPaymentSourcePaypal.email) && Intrinsics3.areEqual(getId(), modelPaymentSourcePaypal.getId()) && getInvalid() == modelPaymentSourcePaypal.getInvalid() && Intrinsics3.areEqual(getBillingAddress(), modelPaymentSourcePaypal.getBillingAddress()) && getDefault() == modelPaymentSourcePaypal.getDefault();
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
            StringBuilder sbU = outline.U("ModelPaymentSourcePaypal(email=");
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

    /* JADX INFO: compiled from: ModelPaymentSource.kt */
    public static final class UnableToWrapException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnableToWrapException(Throwable th) {
            super(th);
            Intrinsics3.checkNotNullParameter(th, "cause");
        }
    }

    private ModelPaymentSource(String str, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3) {
        this.id = str;
        this.invalid = z2;
        this.billingAddress = modelBillingAddress;
        this.default = z3;
    }

    public ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    public boolean getDefault() {
        return this.default;
    }

    public String getId() {
        return this.id;
    }

    public boolean getInvalid() {
        return this.invalid;
    }

    public /* synthetic */ ModelPaymentSource(String str, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z2, modelBillingAddress, z3);
    }
}
