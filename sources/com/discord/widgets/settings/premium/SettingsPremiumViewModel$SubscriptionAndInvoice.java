package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsPremiumViewModel$SubscriptionAndInvoice {
    private final SettingsPremiumViewModel$InvoicePreviewFetch invoicePreviewFetch;
    private final StoreSubscriptions$SubscriptionsState subscriptionsState;

    public SettingsPremiumViewModel$SubscriptionAndInvoice(StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, SettingsPremiumViewModel$InvoicePreviewFetch settingsPremiumViewModel$InvoicePreviewFetch) {
        m.checkNotNullParameter(storeSubscriptions$SubscriptionsState, "subscriptionsState");
        m.checkNotNullParameter(settingsPremiumViewModel$InvoicePreviewFetch, "invoicePreviewFetch");
        this.subscriptionsState = storeSubscriptions$SubscriptionsState;
        this.invoicePreviewFetch = settingsPremiumViewModel$InvoicePreviewFetch;
    }

    public static /* synthetic */ SettingsPremiumViewModel$SubscriptionAndInvoice copy$default(SettingsPremiumViewModel$SubscriptionAndInvoice settingsPremiumViewModel$SubscriptionAndInvoice, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, SettingsPremiumViewModel$InvoicePreviewFetch settingsPremiumViewModel$InvoicePreviewFetch, int i, Object obj) {
        if ((i & 1) != 0) {
            storeSubscriptions$SubscriptionsState = settingsPremiumViewModel$SubscriptionAndInvoice.subscriptionsState;
        }
        if ((i & 2) != 0) {
            settingsPremiumViewModel$InvoicePreviewFetch = settingsPremiumViewModel$SubscriptionAndInvoice.invoicePreviewFetch;
        }
        return settingsPremiumViewModel$SubscriptionAndInvoice.copy(storeSubscriptions$SubscriptionsState, settingsPremiumViewModel$InvoicePreviewFetch);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreSubscriptions$SubscriptionsState getSubscriptionsState() {
        return this.subscriptionsState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SettingsPremiumViewModel$InvoicePreviewFetch getInvoicePreviewFetch() {
        return this.invoicePreviewFetch;
    }

    public final SettingsPremiumViewModel$SubscriptionAndInvoice copy(StoreSubscriptions$SubscriptionsState subscriptionsState, SettingsPremiumViewModel$InvoicePreviewFetch invoicePreviewFetch) {
        m.checkNotNullParameter(subscriptionsState, "subscriptionsState");
        m.checkNotNullParameter(invoicePreviewFetch, "invoicePreviewFetch");
        return new SettingsPremiumViewModel$SubscriptionAndInvoice(subscriptionsState, invoicePreviewFetch);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsPremiumViewModel$SubscriptionAndInvoice)) {
            return false;
        }
        SettingsPremiumViewModel$SubscriptionAndInvoice settingsPremiumViewModel$SubscriptionAndInvoice = (SettingsPremiumViewModel$SubscriptionAndInvoice) other;
        return m.areEqual(this.subscriptionsState, settingsPremiumViewModel$SubscriptionAndInvoice.subscriptionsState) && m.areEqual(this.invoicePreviewFetch, settingsPremiumViewModel$SubscriptionAndInvoice.invoicePreviewFetch);
    }

    public final SettingsPremiumViewModel$InvoicePreviewFetch getInvoicePreviewFetch() {
        return this.invoicePreviewFetch;
    }

    public final StoreSubscriptions$SubscriptionsState getSubscriptionsState() {
        return this.subscriptionsState;
    }

    public int hashCode() {
        StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState = this.subscriptionsState;
        int iHashCode = (storeSubscriptions$SubscriptionsState != null ? storeSubscriptions$SubscriptionsState.hashCode() : 0) * 31;
        SettingsPremiumViewModel$InvoicePreviewFetch settingsPremiumViewModel$InvoicePreviewFetch = this.invoicePreviewFetch;
        return iHashCode + (settingsPremiumViewModel$InvoicePreviewFetch != null ? settingsPremiumViewModel$InvoicePreviewFetch.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SubscriptionAndInvoice(subscriptionsState=");
        sbU.append(this.subscriptionsState);
        sbU.append(", invoicePreviewFetch=");
        sbU.append(this.invoicePreviewFetch);
        sbU.append(")");
        return sbU.toString();
    }
}
