package com.discord.widgets.settings.billing;

import b.d.b.a.a;
import com.discord.stores.StorePaymentSources$PaymentSourcesState;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsBillingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsBillingViewModel$StoreState {
    private final StorePaymentSources$PaymentSourcesState paymentSourceState;
    private final StoreSubscriptions$SubscriptionsState subscriptionsState;

    public SettingsBillingViewModel$StoreState(StorePaymentSources$PaymentSourcesState storePaymentSources$PaymentSourcesState, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        m.checkNotNullParameter(storePaymentSources$PaymentSourcesState, "paymentSourceState");
        m.checkNotNullParameter(storeSubscriptions$SubscriptionsState, "subscriptionsState");
        this.paymentSourceState = storePaymentSources$PaymentSourcesState;
        this.subscriptionsState = storeSubscriptions$SubscriptionsState;
    }

    public static /* synthetic */ SettingsBillingViewModel$StoreState copy$default(SettingsBillingViewModel$StoreState settingsBillingViewModel$StoreState, StorePaymentSources$PaymentSourcesState storePaymentSources$PaymentSourcesState, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, int i, Object obj) {
        if ((i & 1) != 0) {
            storePaymentSources$PaymentSourcesState = settingsBillingViewModel$StoreState.paymentSourceState;
        }
        if ((i & 2) != 0) {
            storeSubscriptions$SubscriptionsState = settingsBillingViewModel$StoreState.subscriptionsState;
        }
        return settingsBillingViewModel$StoreState.copy(storePaymentSources$PaymentSourcesState, storeSubscriptions$SubscriptionsState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StorePaymentSources$PaymentSourcesState getPaymentSourceState() {
        return this.paymentSourceState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreSubscriptions$SubscriptionsState getSubscriptionsState() {
        return this.subscriptionsState;
    }

    public final SettingsBillingViewModel$StoreState copy(StorePaymentSources$PaymentSourcesState paymentSourceState, StoreSubscriptions$SubscriptionsState subscriptionsState) {
        m.checkNotNullParameter(paymentSourceState, "paymentSourceState");
        m.checkNotNullParameter(subscriptionsState, "subscriptionsState");
        return new SettingsBillingViewModel$StoreState(paymentSourceState, subscriptionsState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsBillingViewModel$StoreState)) {
            return false;
        }
        SettingsBillingViewModel$StoreState settingsBillingViewModel$StoreState = (SettingsBillingViewModel$StoreState) other;
        return m.areEqual(this.paymentSourceState, settingsBillingViewModel$StoreState.paymentSourceState) && m.areEqual(this.subscriptionsState, settingsBillingViewModel$StoreState.subscriptionsState);
    }

    public final StorePaymentSources$PaymentSourcesState getPaymentSourceState() {
        return this.paymentSourceState;
    }

    public final StoreSubscriptions$SubscriptionsState getSubscriptionsState() {
        return this.subscriptionsState;
    }

    public int hashCode() {
        StorePaymentSources$PaymentSourcesState storePaymentSources$PaymentSourcesState = this.paymentSourceState;
        int iHashCode = (storePaymentSources$PaymentSourcesState != null ? storePaymentSources$PaymentSourcesState.hashCode() : 0) * 31;
        StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState = this.subscriptionsState;
        return iHashCode + (storeSubscriptions$SubscriptionsState != null ? storeSubscriptions$SubscriptionsState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(paymentSourceState=");
        sbU.append(this.paymentSourceState);
        sbU.append(", subscriptionsState=");
        sbU.append(this.subscriptionsState);
        sbU.append(")");
        return sbU.toString();
    }
}
