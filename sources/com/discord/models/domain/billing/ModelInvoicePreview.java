package com.discord.models.domain.billing;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

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
        m.checkNotNullParameter(str, "currency");
        m.checkNotNullParameter(list, "invoiceItems");
        m.checkNotNullParameter(str2, "subscriptionPeriodEnd");
        m.checkNotNullParameter(str3, "subscriptionPeriodStart");
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelInvoicePreview copy$default(ModelInvoicePreview modelInvoicePreview, String str, long j, List list, String str2, String str3, int i, int i2, boolean z2, int i3, int i4, Object obj) {
        return modelInvoicePreview.copy((i4 & 1) != 0 ? modelInvoicePreview.currency : str, (i4 & 2) != 0 ? modelInvoicePreview.id : j, (i4 & 4) != 0 ? modelInvoicePreview.invoiceItems : list, (i4 & 8) != 0 ? modelInvoicePreview.subscriptionPeriodEnd : str2, (i4 & 16) != 0 ? modelInvoicePreview.subscriptionPeriodStart : str3, (i4 & 32) != 0 ? modelInvoicePreview.subtotal : i, (i4 & 64) != 0 ? modelInvoicePreview.tax : i2, (i4 & 128) != 0 ? modelInvoicePreview.taxInclusive : z2, (i4 & 256) != 0 ? modelInvoicePreview.total : i3);
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
        m.checkNotNullParameter(currency, "currency");
        m.checkNotNullParameter(invoiceItems, "invoiceItems");
        m.checkNotNullParameter(subscriptionPeriodEnd, "subscriptionPeriodEnd");
        m.checkNotNullParameter(subscriptionPeriodStart, "subscriptionPeriodStart");
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
        return m.areEqual(this.currency, modelInvoicePreview.currency) && this.id == modelInvoicePreview.id && m.areEqual(this.invoiceItems, modelInvoicePreview.invoiceItems) && m.areEqual(this.subscriptionPeriodEnd, modelInvoicePreview.subscriptionPeriodEnd) && m.areEqual(this.subscriptionPeriodStart, modelInvoicePreview.subscriptionPeriodStart) && this.subtotal == modelInvoicePreview.subtotal && this.tax == modelInvoicePreview.tax && this.taxInclusive == modelInvoicePreview.taxInclusive && this.total == modelInvoicePreview.total;
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
        StringBuilder sbU = a.U("ModelInvoicePreview(currency=");
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
        return a.B(sbU, this.total, ")");
    }
}
