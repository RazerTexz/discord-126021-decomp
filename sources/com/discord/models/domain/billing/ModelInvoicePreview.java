package com.discord.models.domain.billing;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelInvoicePreview.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelInvoicePreview {
    private final String currency;
    private final long id;
    private final List<ModelInvoiceItem> invoiceItems;
    private final String subscriptionPeriodEnd;
    private final String subscriptionPeriodStart;
    private final int subtotal;
    private final int tax;
    private final boolean taxInclusive;
    private final int total;

    public ModelInvoicePreview(String str, long j, List<ModelInvoiceItem> list, String str2, String str3, int i, int i2, boolean z2, int i3) {
        C12238m.checkNotNullParameter(str, "currency");
        C12238m.checkNotNullParameter(list, "invoiceItems");
        C12238m.checkNotNullParameter(str2, "subscriptionPeriodEnd");
        C12238m.checkNotNullParameter(str3, "subscriptionPeriodStart");
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

    public final List<ModelInvoiceItem> component3() {
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

    public final ModelInvoicePreview copy(String currency, long id2, List<ModelInvoiceItem> invoiceItems, String subscriptionPeriodEnd, String subscriptionPeriodStart, int subtotal, int tax, boolean taxInclusive, int total) {
        C12238m.checkNotNullParameter(currency, "currency");
        C12238m.checkNotNullParameter(invoiceItems, "invoiceItems");
        C12238m.checkNotNullParameter(subscriptionPeriodEnd, "subscriptionPeriodEnd");
        C12238m.checkNotNullParameter(subscriptionPeriodStart, "subscriptionPeriodStart");
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
        return C12238m.areEqual(this.currency, modelInvoicePreview.currency) && this.id == modelInvoicePreview.id && C12238m.areEqual(this.invoiceItems, modelInvoicePreview.invoiceItems) && C12238m.areEqual(this.subscriptionPeriodEnd, modelInvoicePreview.subscriptionPeriodEnd) && C12238m.areEqual(this.subscriptionPeriodStart, modelInvoicePreview.subscriptionPeriodStart) && this.subtotal == modelInvoicePreview.subtotal && this.tax == modelInvoicePreview.tax && this.taxInclusive == modelInvoicePreview.taxInclusive && this.total == modelInvoicePreview.total;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final long getId() {
        return this.id;
    }

    public final List<ModelInvoiceItem> getInvoiceItems() {
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
        List<ModelInvoiceItem> list = this.invoiceItems;
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
        StringBuilder sbM833U = C1643a.m833U("ModelInvoicePreview(currency=");
        sbM833U.append(this.currency);
        sbM833U.append(", id=");
        sbM833U.append(this.id);
        sbM833U.append(", invoiceItems=");
        sbM833U.append(this.invoiceItems);
        sbM833U.append(", subscriptionPeriodEnd=");
        sbM833U.append(this.subscriptionPeriodEnd);
        sbM833U.append(", subscriptionPeriodStart=");
        sbM833U.append(this.subscriptionPeriodStart);
        sbM833U.append(", subtotal=");
        sbM833U.append(this.subtotal);
        sbM833U.append(", tax=");
        sbM833U.append(this.tax);
        sbM833U.append(", taxInclusive=");
        sbM833U.append(this.taxInclusive);
        sbM833U.append(", total=");
        return C1643a.m814B(sbM833U, this.total, ")");
    }
}
