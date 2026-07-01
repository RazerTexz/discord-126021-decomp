package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.discord.stores.StoreEntitlements$State;
import com.discord.stores.StoreGooglePlayPurchases$State;
import com.discord.stores.StoreGooglePlaySkuDetails$State;
import com.discord.stores.StoreGuildBoost$State;
import com.discord.stores.StorePaymentSources$PaymentSourcesState;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsPremiumViewModel$StoreState {
    private final SettingsPremiumViewModel$InvoicePreviewFetch currentInvoicePreviewFetch;
    private final StoreEntitlements$State entitlementState;
    private final StoreGuildBoost$State guildBoostState;
    private final StorePaymentSources$PaymentSourcesState paymentSourcesState;
    private final StoreGooglePlayPurchases$State purchaseState;
    private final SettingsPremiumViewModel$InvoicePreviewFetch renewalInvoicePreviewFetch;
    private final StoreGooglePlaySkuDetails$State skuDetailsState;
    private final StoreSubscriptions$SubscriptionsState subscriptionsState;

    public SettingsPremiumViewModel$StoreState(StorePaymentSources$PaymentSourcesState storePaymentSources$PaymentSourcesState, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, StoreEntitlements$State storeEntitlements$State, StoreGuildBoost$State storeGuildBoost$State, SettingsPremiumViewModel$InvoicePreviewFetch settingsPremiumViewModel$InvoicePreviewFetch, SettingsPremiumViewModel$InvoicePreviewFetch settingsPremiumViewModel$InvoicePreviewFetch2, StoreGooglePlaySkuDetails$State storeGooglePlaySkuDetails$State, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State) {
        m.checkNotNullParameter(storePaymentSources$PaymentSourcesState, "paymentSourcesState");
        m.checkNotNullParameter(storeSubscriptions$SubscriptionsState, "subscriptionsState");
        m.checkNotNullParameter(storeEntitlements$State, "entitlementState");
        m.checkNotNullParameter(storeGuildBoost$State, "guildBoostState");
        m.checkNotNullParameter(settingsPremiumViewModel$InvoicePreviewFetch, "renewalInvoicePreviewFetch");
        m.checkNotNullParameter(settingsPremiumViewModel$InvoicePreviewFetch2, "currentInvoicePreviewFetch");
        m.checkNotNullParameter(storeGooglePlaySkuDetails$State, "skuDetailsState");
        m.checkNotNullParameter(storeGooglePlayPurchases$State, "purchaseState");
        this.paymentSourcesState = storePaymentSources$PaymentSourcesState;
        this.subscriptionsState = storeSubscriptions$SubscriptionsState;
        this.entitlementState = storeEntitlements$State;
        this.guildBoostState = storeGuildBoost$State;
        this.renewalInvoicePreviewFetch = settingsPremiumViewModel$InvoicePreviewFetch;
        this.currentInvoicePreviewFetch = settingsPremiumViewModel$InvoicePreviewFetch2;
        this.skuDetailsState = storeGooglePlaySkuDetails$State;
        this.purchaseState = storeGooglePlayPurchases$State;
    }

    public static /* synthetic */ SettingsPremiumViewModel$StoreState copy$default(SettingsPremiumViewModel$StoreState settingsPremiumViewModel$StoreState, StorePaymentSources$PaymentSourcesState storePaymentSources$PaymentSourcesState, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, StoreEntitlements$State storeEntitlements$State, StoreGuildBoost$State storeGuildBoost$State, SettingsPremiumViewModel$InvoicePreviewFetch settingsPremiumViewModel$InvoicePreviewFetch, SettingsPremiumViewModel$InvoicePreviewFetch settingsPremiumViewModel$InvoicePreviewFetch2, StoreGooglePlaySkuDetails$State storeGooglePlaySkuDetails$State, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State, int i, Object obj) {
        return settingsPremiumViewModel$StoreState.copy((i & 1) != 0 ? settingsPremiumViewModel$StoreState.paymentSourcesState : storePaymentSources$PaymentSourcesState, (i & 2) != 0 ? settingsPremiumViewModel$StoreState.subscriptionsState : storeSubscriptions$SubscriptionsState, (i & 4) != 0 ? settingsPremiumViewModel$StoreState.entitlementState : storeEntitlements$State, (i & 8) != 0 ? settingsPremiumViewModel$StoreState.guildBoostState : storeGuildBoost$State, (i & 16) != 0 ? settingsPremiumViewModel$StoreState.renewalInvoicePreviewFetch : settingsPremiumViewModel$InvoicePreviewFetch, (i & 32) != 0 ? settingsPremiumViewModel$StoreState.currentInvoicePreviewFetch : settingsPremiumViewModel$InvoicePreviewFetch2, (i & 64) != 0 ? settingsPremiumViewModel$StoreState.skuDetailsState : storeGooglePlaySkuDetails$State, (i & 128) != 0 ? settingsPremiumViewModel$StoreState.purchaseState : storeGooglePlayPurchases$State);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StorePaymentSources$PaymentSourcesState getPaymentSourcesState() {
        return this.paymentSourcesState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreSubscriptions$SubscriptionsState getSubscriptionsState() {
        return this.subscriptionsState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreEntitlements$State getEntitlementState() {
        return this.entitlementState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreGuildBoost$State getGuildBoostState() {
        return this.guildBoostState;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SettingsPremiumViewModel$InvoicePreviewFetch getRenewalInvoicePreviewFetch() {
        return this.renewalInvoicePreviewFetch;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SettingsPremiumViewModel$InvoicePreviewFetch getCurrentInvoicePreviewFetch() {
        return this.currentInvoicePreviewFetch;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final StoreGooglePlaySkuDetails$State getSkuDetailsState() {
        return this.skuDetailsState;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final StoreGooglePlayPurchases$State getPurchaseState() {
        return this.purchaseState;
    }

    public final SettingsPremiumViewModel$StoreState copy(StorePaymentSources$PaymentSourcesState paymentSourcesState, StoreSubscriptions$SubscriptionsState subscriptionsState, StoreEntitlements$State entitlementState, StoreGuildBoost$State guildBoostState, SettingsPremiumViewModel$InvoicePreviewFetch renewalInvoicePreviewFetch, SettingsPremiumViewModel$InvoicePreviewFetch currentInvoicePreviewFetch, StoreGooglePlaySkuDetails$State skuDetailsState, StoreGooglePlayPurchases$State purchaseState) {
        m.checkNotNullParameter(paymentSourcesState, "paymentSourcesState");
        m.checkNotNullParameter(subscriptionsState, "subscriptionsState");
        m.checkNotNullParameter(entitlementState, "entitlementState");
        m.checkNotNullParameter(guildBoostState, "guildBoostState");
        m.checkNotNullParameter(renewalInvoicePreviewFetch, "renewalInvoicePreviewFetch");
        m.checkNotNullParameter(currentInvoicePreviewFetch, "currentInvoicePreviewFetch");
        m.checkNotNullParameter(skuDetailsState, "skuDetailsState");
        m.checkNotNullParameter(purchaseState, "purchaseState");
        return new SettingsPremiumViewModel$StoreState(paymentSourcesState, subscriptionsState, entitlementState, guildBoostState, renewalInvoicePreviewFetch, currentInvoicePreviewFetch, skuDetailsState, purchaseState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsPremiumViewModel$StoreState)) {
            return false;
        }
        SettingsPremiumViewModel$StoreState settingsPremiumViewModel$StoreState = (SettingsPremiumViewModel$StoreState) other;
        return m.areEqual(this.paymentSourcesState, settingsPremiumViewModel$StoreState.paymentSourcesState) && m.areEqual(this.subscriptionsState, settingsPremiumViewModel$StoreState.subscriptionsState) && m.areEqual(this.entitlementState, settingsPremiumViewModel$StoreState.entitlementState) && m.areEqual(this.guildBoostState, settingsPremiumViewModel$StoreState.guildBoostState) && m.areEqual(this.renewalInvoicePreviewFetch, settingsPremiumViewModel$StoreState.renewalInvoicePreviewFetch) && m.areEqual(this.currentInvoicePreviewFetch, settingsPremiumViewModel$StoreState.currentInvoicePreviewFetch) && m.areEqual(this.skuDetailsState, settingsPremiumViewModel$StoreState.skuDetailsState) && m.areEqual(this.purchaseState, settingsPremiumViewModel$StoreState.purchaseState);
    }

    public final SettingsPremiumViewModel$InvoicePreviewFetch getCurrentInvoicePreviewFetch() {
        return this.currentInvoicePreviewFetch;
    }

    public final StoreEntitlements$State getEntitlementState() {
        return this.entitlementState;
    }

    public final StoreGuildBoost$State getGuildBoostState() {
        return this.guildBoostState;
    }

    public final StorePaymentSources$PaymentSourcesState getPaymentSourcesState() {
        return this.paymentSourcesState;
    }

    public final StoreGooglePlayPurchases$State getPurchaseState() {
        return this.purchaseState;
    }

    public final SettingsPremiumViewModel$InvoicePreviewFetch getRenewalInvoicePreviewFetch() {
        return this.renewalInvoicePreviewFetch;
    }

    public final StoreGooglePlaySkuDetails$State getSkuDetailsState() {
        return this.skuDetailsState;
    }

    public final StoreSubscriptions$SubscriptionsState getSubscriptionsState() {
        return this.subscriptionsState;
    }

    public int hashCode() {
        StorePaymentSources$PaymentSourcesState storePaymentSources$PaymentSourcesState = this.paymentSourcesState;
        int iHashCode = (storePaymentSources$PaymentSourcesState != null ? storePaymentSources$PaymentSourcesState.hashCode() : 0) * 31;
        StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState = this.subscriptionsState;
        int iHashCode2 = (iHashCode + (storeSubscriptions$SubscriptionsState != null ? storeSubscriptions$SubscriptionsState.hashCode() : 0)) * 31;
        StoreEntitlements$State storeEntitlements$State = this.entitlementState;
        int iHashCode3 = (iHashCode2 + (storeEntitlements$State != null ? storeEntitlements$State.hashCode() : 0)) * 31;
        StoreGuildBoost$State storeGuildBoost$State = this.guildBoostState;
        int iHashCode4 = (iHashCode3 + (storeGuildBoost$State != null ? storeGuildBoost$State.hashCode() : 0)) * 31;
        SettingsPremiumViewModel$InvoicePreviewFetch settingsPremiumViewModel$InvoicePreviewFetch = this.renewalInvoicePreviewFetch;
        int iHashCode5 = (iHashCode4 + (settingsPremiumViewModel$InvoicePreviewFetch != null ? settingsPremiumViewModel$InvoicePreviewFetch.hashCode() : 0)) * 31;
        SettingsPremiumViewModel$InvoicePreviewFetch settingsPremiumViewModel$InvoicePreviewFetch2 = this.currentInvoicePreviewFetch;
        int iHashCode6 = (iHashCode5 + (settingsPremiumViewModel$InvoicePreviewFetch2 != null ? settingsPremiumViewModel$InvoicePreviewFetch2.hashCode() : 0)) * 31;
        StoreGooglePlaySkuDetails$State storeGooglePlaySkuDetails$State = this.skuDetailsState;
        int iHashCode7 = (iHashCode6 + (storeGooglePlaySkuDetails$State != null ? storeGooglePlaySkuDetails$State.hashCode() : 0)) * 31;
        StoreGooglePlayPurchases$State storeGooglePlayPurchases$State = this.purchaseState;
        return iHashCode7 + (storeGooglePlayPurchases$State != null ? storeGooglePlayPurchases$State.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(paymentSourcesState=");
        sbU.append(this.paymentSourcesState);
        sbU.append(", subscriptionsState=");
        sbU.append(this.subscriptionsState);
        sbU.append(", entitlementState=");
        sbU.append(this.entitlementState);
        sbU.append(", guildBoostState=");
        sbU.append(this.guildBoostState);
        sbU.append(", renewalInvoicePreviewFetch=");
        sbU.append(this.renewalInvoicePreviewFetch);
        sbU.append(", currentInvoicePreviewFetch=");
        sbU.append(this.currentInvoicePreviewFetch);
        sbU.append(", skuDetailsState=");
        sbU.append(this.skuDetailsState);
        sbU.append(", purchaseState=");
        sbU.append(this.purchaseState);
        sbU.append(")");
        return sbU.toString();
    }
}
