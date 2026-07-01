package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.billing.ModelInvoicePreview;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsPremiumViewModel$ViewState$Loaded extends SettingsPremiumViewModel$ViewState {
    private final ModelInvoicePreview currentInvoicePreview;
    private final List<ModelEntitlement> entitlements;
    private final Map<Long, ModelGuildBoostSlot> guildSubscriptions;
    private final boolean hasAnyGuildBoosts;
    private final boolean isBusy;
    private final int pastDueGracePeriodDays;
    private final List<ModelPaymentSource> paymentSources;
    private final ModelSubscription premiumSubscription;
    private final List<Purchase> purchases;
    private final ModelInvoicePreview renewalInvoicePreview;
    private final Map<String, SkuDetails> skuDetails;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsPremiumViewModel$ViewState$Loaded(ModelSubscription modelSubscription, List<? extends ModelPaymentSource> list, boolean z2, List<ModelEntitlement> list2, Map<Long, ModelGuildBoostSlot> map, boolean z3, ModelInvoicePreview modelInvoicePreview, ModelInvoicePreview modelInvoicePreview2, Map<String, ? extends SkuDetails> map2, List<? extends Purchase> list3, int i) {
        super(null);
        m.checkNotNullParameter(list, "paymentSources");
        m.checkNotNullParameter(list2, "entitlements");
        m.checkNotNullParameter(map, "guildSubscriptions");
        m.checkNotNullParameter(map2, "skuDetails");
        m.checkNotNullParameter(list3, "purchases");
        this.premiumSubscription = modelSubscription;
        this.paymentSources = list;
        this.isBusy = z2;
        this.entitlements = list2;
        this.guildSubscriptions = map;
        this.hasAnyGuildBoosts = z3;
        this.renewalInvoicePreview = modelInvoicePreview;
        this.currentInvoicePreview = modelInvoicePreview2;
        this.skuDetails = map2;
        this.purchases = list3;
        this.pastDueGracePeriodDays = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingsPremiumViewModel$ViewState$Loaded copy$default(SettingsPremiumViewModel$ViewState$Loaded settingsPremiumViewModel$ViewState$Loaded, ModelSubscription modelSubscription, List list, boolean z2, List list2, Map map, boolean z3, ModelInvoicePreview modelInvoicePreview, ModelInvoicePreview modelInvoicePreview2, Map map2, List list3, int i, int i2, Object obj) {
        return settingsPremiumViewModel$ViewState$Loaded.copy((i2 & 1) != 0 ? settingsPremiumViewModel$ViewState$Loaded.premiumSubscription : modelSubscription, (i2 & 2) != 0 ? settingsPremiumViewModel$ViewState$Loaded.paymentSources : list, (i2 & 4) != 0 ? settingsPremiumViewModel$ViewState$Loaded.isBusy : z2, (i2 & 8) != 0 ? settingsPremiumViewModel$ViewState$Loaded.entitlements : list2, (i2 & 16) != 0 ? settingsPremiumViewModel$ViewState$Loaded.guildSubscriptions : map, (i2 & 32) != 0 ? settingsPremiumViewModel$ViewState$Loaded.hasAnyGuildBoosts : z3, (i2 & 64) != 0 ? settingsPremiumViewModel$ViewState$Loaded.renewalInvoicePreview : modelInvoicePreview, (i2 & 128) != 0 ? settingsPremiumViewModel$ViewState$Loaded.currentInvoicePreview : modelInvoicePreview2, (i2 & 256) != 0 ? settingsPremiumViewModel$ViewState$Loaded.skuDetails : map2, (i2 & 512) != 0 ? settingsPremiumViewModel$ViewState$Loaded.purchases : list3, (i2 & 1024) != 0 ? settingsPremiumViewModel$ViewState$Loaded.pastDueGracePeriodDays : i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelSubscription getPremiumSubscription() {
        return this.premiumSubscription;
    }

    public final List<Purchase> component10() {
        return this.purchases;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getPastDueGracePeriodDays() {
        return this.pastDueGracePeriodDays;
    }

    public final List<ModelPaymentSource> component2() {
        return this.paymentSources;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsBusy() {
        return this.isBusy;
    }

    public final List<ModelEntitlement> component4() {
        return this.entitlements;
    }

    public final Map<Long, ModelGuildBoostSlot> component5() {
        return this.guildSubscriptions;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getHasAnyGuildBoosts() {
        return this.hasAnyGuildBoosts;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ModelInvoicePreview getRenewalInvoicePreview() {
        return this.renewalInvoicePreview;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ModelInvoicePreview getCurrentInvoicePreview() {
        return this.currentInvoicePreview;
    }

    public final Map<String, SkuDetails> component9() {
        return this.skuDetails;
    }

    public final SettingsPremiumViewModel$ViewState$Loaded copy(ModelSubscription premiumSubscription, List<? extends ModelPaymentSource> paymentSources, boolean isBusy, List<ModelEntitlement> entitlements, Map<Long, ModelGuildBoostSlot> guildSubscriptions, boolean hasAnyGuildBoosts, ModelInvoicePreview renewalInvoicePreview, ModelInvoicePreview currentInvoicePreview, Map<String, ? extends SkuDetails> skuDetails, List<? extends Purchase> purchases, int pastDueGracePeriodDays) {
        m.checkNotNullParameter(paymentSources, "paymentSources");
        m.checkNotNullParameter(entitlements, "entitlements");
        m.checkNotNullParameter(guildSubscriptions, "guildSubscriptions");
        m.checkNotNullParameter(skuDetails, "skuDetails");
        m.checkNotNullParameter(purchases, "purchases");
        return new SettingsPremiumViewModel$ViewState$Loaded(premiumSubscription, paymentSources, isBusy, entitlements, guildSubscriptions, hasAnyGuildBoosts, renewalInvoicePreview, currentInvoicePreview, skuDetails, purchases, pastDueGracePeriodDays);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsPremiumViewModel$ViewState$Loaded)) {
            return false;
        }
        SettingsPremiumViewModel$ViewState$Loaded settingsPremiumViewModel$ViewState$Loaded = (SettingsPremiumViewModel$ViewState$Loaded) other;
        return m.areEqual(this.premiumSubscription, settingsPremiumViewModel$ViewState$Loaded.premiumSubscription) && m.areEqual(this.paymentSources, settingsPremiumViewModel$ViewState$Loaded.paymentSources) && this.isBusy == settingsPremiumViewModel$ViewState$Loaded.isBusy && m.areEqual(this.entitlements, settingsPremiumViewModel$ViewState$Loaded.entitlements) && m.areEqual(this.guildSubscriptions, settingsPremiumViewModel$ViewState$Loaded.guildSubscriptions) && this.hasAnyGuildBoosts == settingsPremiumViewModel$ViewState$Loaded.hasAnyGuildBoosts && m.areEqual(this.renewalInvoicePreview, settingsPremiumViewModel$ViewState$Loaded.renewalInvoicePreview) && m.areEqual(this.currentInvoicePreview, settingsPremiumViewModel$ViewState$Loaded.currentInvoicePreview) && m.areEqual(this.skuDetails, settingsPremiumViewModel$ViewState$Loaded.skuDetails) && m.areEqual(this.purchases, settingsPremiumViewModel$ViewState$Loaded.purchases) && this.pastDueGracePeriodDays == settingsPremiumViewModel$ViewState$Loaded.pastDueGracePeriodDays;
    }

    public final ModelInvoicePreview getCurrentInvoicePreview() {
        return this.currentInvoicePreview;
    }

    public final List<ModelEntitlement> getEntitlements() {
        return this.entitlements;
    }

    public final Map<Long, ModelGuildBoostSlot> getGuildSubscriptions() {
        return this.guildSubscriptions;
    }

    public final boolean getHasAnyGuildBoosts() {
        return this.hasAnyGuildBoosts;
    }

    public final int getPastDueGracePeriodDays() {
        return this.pastDueGracePeriodDays;
    }

    public final List<ModelPaymentSource> getPaymentSources() {
        return this.paymentSources;
    }

    public final ModelSubscription getPremiumSubscription() {
        return this.premiumSubscription;
    }

    public final List<Purchase> getPurchases() {
        return this.purchases;
    }

    public final ModelInvoicePreview getRenewalInvoicePreview() {
        return this.renewalInvoicePreview;
    }

    public final Map<String, SkuDetails> getSkuDetails() {
        return this.skuDetails;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        ModelSubscription modelSubscription = this.premiumSubscription;
        int iHashCode = (modelSubscription != null ? modelSubscription.hashCode() : 0) * 31;
        List<ModelPaymentSource> list = this.paymentSources;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isBusy;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        List<ModelEntitlement> list2 = this.entitlements;
        int iHashCode3 = (i + (list2 != null ? list2.hashCode() : 0)) * 31;
        Map<Long, ModelGuildBoostSlot> map = this.guildSubscriptions;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z3 = this.hasAnyGuildBoosts;
        int i2 = (iHashCode4 + (z3 ? 1 : z3)) * 31;
        ModelInvoicePreview modelInvoicePreview = this.renewalInvoicePreview;
        int iHashCode5 = (i2 + (modelInvoicePreview != null ? modelInvoicePreview.hashCode() : 0)) * 31;
        ModelInvoicePreview modelInvoicePreview2 = this.currentInvoicePreview;
        int iHashCode6 = (iHashCode5 + (modelInvoicePreview2 != null ? modelInvoicePreview2.hashCode() : 0)) * 31;
        Map<String, SkuDetails> map2 = this.skuDetails;
        int iHashCode7 = (iHashCode6 + (map2 != null ? map2.hashCode() : 0)) * 31;
        List<Purchase> list3 = this.purchases;
        return ((iHashCode7 + (list3 != null ? list3.hashCode() : 0)) * 31) + this.pastDueGracePeriodDays;
    }

    public final boolean isBusy() {
        return this.isBusy;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(premiumSubscription=");
        sbU.append(this.premiumSubscription);
        sbU.append(", paymentSources=");
        sbU.append(this.paymentSources);
        sbU.append(", isBusy=");
        sbU.append(this.isBusy);
        sbU.append(", entitlements=");
        sbU.append(this.entitlements);
        sbU.append(", guildSubscriptions=");
        sbU.append(this.guildSubscriptions);
        sbU.append(", hasAnyGuildBoosts=");
        sbU.append(this.hasAnyGuildBoosts);
        sbU.append(", renewalInvoicePreview=");
        sbU.append(this.renewalInvoicePreview);
        sbU.append(", currentInvoicePreview=");
        sbU.append(this.currentInvoicePreview);
        sbU.append(", skuDetails=");
        sbU.append(this.skuDetails);
        sbU.append(", purchases=");
        sbU.append(this.purchases);
        sbU.append(", pastDueGracePeriodDays=");
        return a.B(sbU, this.pastDueGracePeriodDays, ")");
    }
}
