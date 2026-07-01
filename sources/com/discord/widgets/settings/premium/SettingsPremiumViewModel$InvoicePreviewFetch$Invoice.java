package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.discord.models.domain.billing.ModelInvoicePreview;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsPremiumViewModel$InvoicePreviewFetch$Invoice extends SettingsPremiumViewModel$InvoicePreviewFetch {
    private final ModelInvoicePreview modelInvoicePreview;

    public SettingsPremiumViewModel$InvoicePreviewFetch$Invoice(ModelInvoicePreview modelInvoicePreview) {
        super(null);
        this.modelInvoicePreview = modelInvoicePreview;
    }

    public static /* synthetic */ SettingsPremiumViewModel$InvoicePreviewFetch$Invoice copy$default(SettingsPremiumViewModel$InvoicePreviewFetch$Invoice settingsPremiumViewModel$InvoicePreviewFetch$Invoice, ModelInvoicePreview modelInvoicePreview, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvoicePreview = settingsPremiumViewModel$InvoicePreviewFetch$Invoice.modelInvoicePreview;
        }
        return settingsPremiumViewModel$InvoicePreviewFetch$Invoice.copy(modelInvoicePreview);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvoicePreview getModelInvoicePreview() {
        return this.modelInvoicePreview;
    }

    public final SettingsPremiumViewModel$InvoicePreviewFetch$Invoice copy(ModelInvoicePreview modelInvoicePreview) {
        return new SettingsPremiumViewModel$InvoicePreviewFetch$Invoice(modelInvoicePreview);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SettingsPremiumViewModel$InvoicePreviewFetch$Invoice) && m.areEqual(this.modelInvoicePreview, ((SettingsPremiumViewModel$InvoicePreviewFetch$Invoice) other).modelInvoicePreview);
        }
        return true;
    }

    public final ModelInvoicePreview getModelInvoicePreview() {
        return this.modelInvoicePreview;
    }

    public int hashCode() {
        ModelInvoicePreview modelInvoicePreview = this.modelInvoicePreview;
        if (modelInvoicePreview != null) {
            return modelInvoicePreview.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Invoice(modelInvoicePreview=");
        sbU.append(this.modelInvoicePreview);
        sbU.append(")");
        return sbU.toString();
    }
}
