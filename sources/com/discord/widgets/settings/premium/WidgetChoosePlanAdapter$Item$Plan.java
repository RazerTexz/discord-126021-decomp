package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.android.billingclient.api.SkuDetails;
import com.discord.utilities.billing.GooglePlaySku;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChoosePlanAdapter$Item$Plan extends WidgetChoosePlanAdapter$Item {
    private final GooglePlaySku displaySku;
    private final boolean isCurrentPlan;
    private final String key;
    private final String oldSkuName;
    private final GooglePlaySku purchaseSku;
    private final SkuDetails skuDetails;
    private final SkuDetails upgradeSkuDetails;

    public /* synthetic */ WidgetChoosePlanAdapter$Item$Plan(GooglePlaySku googlePlaySku, SkuDetails skuDetails, GooglePlaySku googlePlaySku2, String str, SkuDetails skuDetails2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(googlePlaySku, skuDetails, googlePlaySku2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : skuDetails2, (i & 32) != 0 ? false : z2);
    }

    public static /* synthetic */ WidgetChoosePlanAdapter$Item$Plan copy$default(WidgetChoosePlanAdapter$Item$Plan widgetChoosePlanAdapter$Item$Plan, GooglePlaySku googlePlaySku, SkuDetails skuDetails, GooglePlaySku googlePlaySku2, String str, SkuDetails skuDetails2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            googlePlaySku = widgetChoosePlanAdapter$Item$Plan.displaySku;
        }
        if ((i & 2) != 0) {
            skuDetails = widgetChoosePlanAdapter$Item$Plan.skuDetails;
        }
        SkuDetails skuDetails3 = skuDetails;
        if ((i & 4) != 0) {
            googlePlaySku2 = widgetChoosePlanAdapter$Item$Plan.purchaseSku;
        }
        GooglePlaySku googlePlaySku3 = googlePlaySku2;
        if ((i & 8) != 0) {
            str = widgetChoosePlanAdapter$Item$Plan.oldSkuName;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            skuDetails2 = widgetChoosePlanAdapter$Item$Plan.upgradeSkuDetails;
        }
        SkuDetails skuDetails4 = skuDetails2;
        if ((i & 32) != 0) {
            z2 = widgetChoosePlanAdapter$Item$Plan.isCurrentPlan;
        }
        return widgetChoosePlanAdapter$Item$Plan.copy(googlePlaySku, skuDetails3, googlePlaySku3, str2, skuDetails4, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GooglePlaySku getDisplaySku() {
        return this.displaySku;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SkuDetails getSkuDetails() {
        return this.skuDetails;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GooglePlaySku getPurchaseSku() {
        return this.purchaseSku;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOldSkuName() {
        return this.oldSkuName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SkuDetails getUpgradeSkuDetails() {
        return this.upgradeSkuDetails;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsCurrentPlan() {
        return this.isCurrentPlan;
    }

    public final WidgetChoosePlanAdapter$Item$Plan copy(GooglePlaySku displaySku, SkuDetails skuDetails, GooglePlaySku purchaseSku, String oldSkuName, SkuDetails upgradeSkuDetails, boolean isCurrentPlan) {
        m.checkNotNullParameter(displaySku, "displaySku");
        m.checkNotNullParameter(skuDetails, "skuDetails");
        return new WidgetChoosePlanAdapter$Item$Plan(displaySku, skuDetails, purchaseSku, oldSkuName, upgradeSkuDetails, isCurrentPlan);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChoosePlanAdapter$Item$Plan)) {
            return false;
        }
        WidgetChoosePlanAdapter$Item$Plan widgetChoosePlanAdapter$Item$Plan = (WidgetChoosePlanAdapter$Item$Plan) other;
        return m.areEqual(this.displaySku, widgetChoosePlanAdapter$Item$Plan.displaySku) && m.areEqual(this.skuDetails, widgetChoosePlanAdapter$Item$Plan.skuDetails) && m.areEqual(this.purchaseSku, widgetChoosePlanAdapter$Item$Plan.purchaseSku) && m.areEqual(this.oldSkuName, widgetChoosePlanAdapter$Item$Plan.oldSkuName) && m.areEqual(this.upgradeSkuDetails, widgetChoosePlanAdapter$Item$Plan.upgradeSkuDetails) && this.isCurrentPlan == widgetChoosePlanAdapter$Item$Plan.isCurrentPlan;
    }

    public final GooglePlaySku getDisplaySku() {
        return this.displaySku;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getOldSkuName() {
        return this.oldSkuName;
    }

    public final GooglePlaySku getPurchaseSku() {
        return this.purchaseSku;
    }

    public final SkuDetails getSkuDetails() {
        return this.skuDetails;
    }

    public final SkuDetails getUpgradeSkuDetails() {
        return this.upgradeSkuDetails;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        GooglePlaySku googlePlaySku = this.displaySku;
        int iHashCode = (googlePlaySku != null ? googlePlaySku.hashCode() : 0) * 31;
        SkuDetails skuDetails = this.skuDetails;
        int iHashCode2 = (iHashCode + (skuDetails != null ? skuDetails.hashCode() : 0)) * 31;
        GooglePlaySku googlePlaySku2 = this.purchaseSku;
        int iHashCode3 = (iHashCode2 + (googlePlaySku2 != null ? googlePlaySku2.hashCode() : 0)) * 31;
        String str = this.oldSkuName;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        SkuDetails skuDetails2 = this.upgradeSkuDetails;
        int iHashCode5 = (iHashCode4 + (skuDetails2 != null ? skuDetails2.hashCode() : 0)) * 31;
        boolean z2 = this.isCurrentPlan;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode5 + r1;
    }

    public final boolean isCurrentPlan() {
        return this.isCurrentPlan;
    }

    public String toString() {
        StringBuilder sbU = a.U("Plan(displaySku=");
        sbU.append(this.displaySku);
        sbU.append(", skuDetails=");
        sbU.append(this.skuDetails);
        sbU.append(", purchaseSku=");
        sbU.append(this.purchaseSku);
        sbU.append(", oldSkuName=");
        sbU.append(this.oldSkuName);
        sbU.append(", upgradeSkuDetails=");
        sbU.append(this.upgradeSkuDetails);
        sbU.append(", isCurrentPlan=");
        return a.O(sbU, this.isCurrentPlan, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlanAdapter$Item$Plan(GooglePlaySku googlePlaySku, SkuDetails skuDetails, GooglePlaySku googlePlaySku2, String str, SkuDetails skuDetails2, boolean z2) {
        super(1, null);
        m.checkNotNullParameter(googlePlaySku, "displaySku");
        m.checkNotNullParameter(skuDetails, "skuDetails");
        this.displaySku = googlePlaySku;
        this.skuDetails = skuDetails;
        this.purchaseSku = googlePlaySku2;
        this.oldSkuName = str;
        this.upgradeSkuDetails = skuDetails2;
        this.isCurrentPlan = z2;
        this.key = getType() + googlePlaySku.getSkuName();
    }
}
