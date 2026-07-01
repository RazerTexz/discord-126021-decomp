package com.discord.models.domain.billing;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: com.discord.models.domain.billing.ModelInvoiceItem, reason: use source file name */
/* JADX INFO: compiled from: ModelInvoicePreview.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelInvoicePreview3 {
    private final int amount;
    private final List<ModelInvoicePreview2> discount;
    private final long id;
    private final boolean proration;
    private final int quantity;
    private final long subscriptionPlanId;
    private final int subscriptionPlanPrice;

    public ModelInvoicePreview3(int i, List<ModelInvoicePreview2> list, long j, boolean z2, int i2, long j2, int i3) {
        Intrinsics3.checkNotNullParameter(list, "discount");
        this.amount = i;
        this.discount = list;
        this.id = j;
        this.proration = z2;
        this.quantity = i2;
        this.subscriptionPlanId = j2;
        this.subscriptionPlanPrice = i3;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    public final List<ModelInvoicePreview2> component2() {
        return this.discount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getProration() {
        return this.proration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getSubscriptionPlanPrice() {
        return this.subscriptionPlanPrice;
    }

    public final ModelInvoicePreview3 copy(int amount, List<ModelInvoicePreview2> discount, long id2, boolean proration, int quantity, long subscriptionPlanId, int subscriptionPlanPrice) {
        Intrinsics3.checkNotNullParameter(discount, "discount");
        return new ModelInvoicePreview3(amount, discount, id2, proration, quantity, subscriptionPlanId, subscriptionPlanPrice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelInvoicePreview3)) {
            return false;
        }
        ModelInvoicePreview3 modelInvoicePreview3 = (ModelInvoicePreview3) other;
        return this.amount == modelInvoicePreview3.amount && Intrinsics3.areEqual(this.discount, modelInvoicePreview3.discount) && this.id == modelInvoicePreview3.id && this.proration == modelInvoicePreview3.proration && this.quantity == modelInvoicePreview3.quantity && this.subscriptionPlanId == modelInvoicePreview3.subscriptionPlanId && this.subscriptionPlanPrice == modelInvoicePreview3.subscriptionPlanPrice;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final List<ModelInvoicePreview2> getDiscount() {
        return this.discount;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean getProration() {
        return this.proration;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    public final int getSubscriptionPlanPrice() {
        return this.subscriptionPlanPrice;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public int hashCode() {
        int i = this.amount * 31;
        List<ModelInvoicePreview2> list = this.discount;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        long j = this.id;
        int i2 = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        boolean z2 = this.proration;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i3 = (((i2 + r1) * 31) + this.quantity) * 31;
        long j2 = this.subscriptionPlanId;
        return ((i3 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.subscriptionPlanPrice;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelInvoiceItem(amount=");
        sbU.append(this.amount);
        sbU.append(", discount=");
        sbU.append(this.discount);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", proration=");
        sbU.append(this.proration);
        sbU.append(", quantity=");
        sbU.append(this.quantity);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", subscriptionPlanPrice=");
        return outline.B(sbU, this.subscriptionPlanPrice, ")");
    }
}
