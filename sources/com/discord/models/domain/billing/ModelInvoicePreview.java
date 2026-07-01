package com.discord.models.domain.billing;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: ModelInvoicePreview.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelInvoicePreview {
    private final String currency;
    private final long id;
    private final List<ModelInvoicePreview3> invoiceItems;
    private final String subscriptionPeriodEnd;
    private final String subscriptionPeriodStart;
    private final int subtotal;
    private final int tax;
    private final boolean taxInclusive;
    private final int total;

    public ModelInvoicePreview(String str, long j, List<ModelInvoicePreview3> list, String str2, String str3, int i, int i2, boolean z2, int i3) {
        Intrinsics3.checkNotNullParameter(str, "currency");
        Intrinsics3.checkNotNullParameter(list, "invoiceItems");
        Intrinsics3.checkNotNullParameter(str2, "subscriptionPeriodEnd");
        Intrinsics3.checkNotNullParameter(str3, "subscriptionPeriodStart");
        this.currency = str;
        this.id = j;
        this.invoiceItems = list;
        this.subscriptionPeriodEnd = str2;
        this.subscriptionPeriodStart = str3;
        this.subtotal = i;
        this.tax = i2;
        this.taxInclusive = z2;
        this.total = i3;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<ModelInvoicePreview3> component3() {
        return this.invoiceItems;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubscriptionPeriodEnd() {
        return this.subscriptionPeriodEnd;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSubscriptionPeriodStart() {
        return this.subscriptionPeriodStart;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSubtotal() {
        return this.subtotal;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getTax() {
        return this.tax;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getTaxInclusive() {
        return this.taxInclusive;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final ModelInvoicePreview copy(String currency, long id2, List<ModelInvoicePreview3> invoiceItems, String subscriptionPeriodEnd, String subscriptionPeriodStart, int subtotal, int tax, boolean taxInclusive, int total) {
        Intrinsics3.checkNotNullParameter(currency, "currency");
        Intrinsics3.checkNotNullParameter(invoiceItems, "invoiceItems");
        Intrinsics3.checkNotNullParameter(subscriptionPeriodEnd, "subscriptionPeriodEnd");
        Intrinsics3.checkNotNullParameter(subscriptionPeriodStart, "subscriptionPeriodStart");
        return new ModelInvoicePreview(currency, id2, invoiceItems, subscriptionPeriodEnd, subscriptionPeriodStart, subtotal, tax, taxInclusive, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelInvoicePreview)) {
            return false;
        }
        ModelInvoicePreview modelInvoicePreview = (ModelInvoicePreview) other;
        return Intrinsics3.areEqual(this.currency, modelInvoicePreview.currency) && this.id == modelInvoicePreview.id && Intrinsics3.areEqual(this.invoiceItems, modelInvoicePreview.invoiceItems) && Intrinsics3.areEqual(this.subscriptionPeriodEnd, modelInvoicePreview.subscriptionPeriodEnd) && Intrinsics3.areEqual(this.subscriptionPeriodStart, modelInvoicePreview.subscriptionPeriodStart) && this.subtotal == modelInvoicePreview.subtotal && this.tax == modelInvoicePreview.tax && this.taxInclusive == modelInvoicePreview.taxInclusive && this.total == modelInvoicePreview.total;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final long getId() {
        return this.id;
    }

    public final List<ModelInvoicePreview3> getInvoiceItems() {
        return this.invoiceItems;
    }

    public final String getSubscriptionPeriodEnd() {
        return this.subscriptionPeriodEnd;
    }

    public final String getSubscriptionPeriodStart() {
        return this.subscriptionPeriodStart;
    }

    public final int getSubtotal() {
        return this.subtotal;
    }

    public final int getTax() {
        return this.tax;
    }

    public final boolean getTaxInclusive() {
        return this.taxInclusive;
    }

    public final int getTotal() {
        return this.total;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        String str = this.currency;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.id;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        List<ModelInvoicePreview3> list = this.invoiceItems;
        int iHashCode2 = (i + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.subscriptionPeriodEnd;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subscriptionPeriodStart;
        int iHashCode4 = (((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.subtotal) * 31) + this.tax) * 31;
        boolean z2 = this.taxInclusive;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return ((iHashCode4 + r1) * 31) + this.total;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelInvoicePreview(currency=");
        sbU.append(this.currency);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", invoiceItems=");
        sbU.append(this.invoiceItems);
        sbU.append(", subscriptionPeriodEnd=");
        sbU.append(this.subscriptionPeriodEnd);
        sbU.append(", subscriptionPeriodStart=");
        sbU.append(this.subscriptionPeriodStart);
        sbU.append(", subtotal=");
        sbU.append(this.subtotal);
        sbU.append(", tax=");
        sbU.append(this.tax);
        sbU.append(", taxInclusive=");
        sbU.append(this.taxInclusive);
        sbU.append(", total=");
        return outline.B(sbU, this.total, ")");
    }
}
