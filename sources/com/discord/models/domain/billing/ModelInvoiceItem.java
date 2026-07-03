package com.discord.models.domain.billing;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelInvoicePreview.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelInvoiceItem {
    private final int amount;
    private final List<ModelInvoiceDiscount> discount;
    private final long id;
    private final boolean proration;
    private final int quantity;
    private final long subscriptionPlanId;
    private final int subscriptionPlanPrice;

    public ModelInvoiceItem(int i, List<ModelInvoiceDiscount> list, long j, boolean z2, int i2, long j2, int i3) {
        C12238m.checkNotNullParameter(list, "discount");
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

    public final List<ModelInvoiceDiscount> component2() {
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

    public final ModelInvoiceItem copy(int amount, List<ModelInvoiceDiscount> discount, long id2, boolean proration, int quantity, long subscriptionPlanId, int subscriptionPlanPrice) {
        C12238m.checkNotNullParameter(discount, "discount");
        return new ModelInvoiceItem(amount, discount, id2, proration, quantity, subscriptionPlanId, subscriptionPlanPrice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelInvoiceItem)) {
            return false;
        }
        ModelInvoiceItem modelInvoiceItem = (ModelInvoiceItem) other;
        return this.amount == modelInvoiceItem.amount && C12238m.areEqual(this.discount, modelInvoiceItem.discount) && this.id == modelInvoiceItem.id && this.proration == modelInvoiceItem.proration && this.quantity == modelInvoiceItem.quantity && this.subscriptionPlanId == modelInvoiceItem.subscriptionPlanId && this.subscriptionPlanPrice == modelInvoiceItem.subscriptionPlanPrice;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final List<ModelInvoiceDiscount> getDiscount() {
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
        List<ModelInvoiceDiscount> list = this.discount;
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
        StringBuilder sbM833U = C1643a.m833U("ModelInvoiceItem(amount=");
        sbM833U.append(this.amount);
        sbM833U.append(", discount=");
        sbM833U.append(this.discount);
        sbM833U.append(", id=");
        sbM833U.append(this.id);
        sbM833U.append(", proration=");
        sbM833U.append(this.proration);
        sbM833U.append(", quantity=");
        sbM833U.append(this.quantity);
        sbM833U.append(", subscriptionPlanId=");
        sbM833U.append(this.subscriptionPlanId);
        sbM833U.append(", subscriptionPlanPrice=");
        return C1643a.m814B(sbM833U, this.subscriptionPlanPrice, ")");
    }
}
