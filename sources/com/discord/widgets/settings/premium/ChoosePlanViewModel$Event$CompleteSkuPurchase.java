package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ChoosePlanViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChoosePlanViewModel$Event$CompleteSkuPurchase extends ChoosePlanViewModel$Event {
    private final String planName;
    private final String skuName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChoosePlanViewModel$Event$CompleteSkuPurchase(String str, String str2) {
        super(null);
        m.checkNotNullParameter(str, "skuName");
        m.checkNotNullParameter(str2, "planName");
        this.skuName = str;
        this.planName = str2;
    }

    public static /* synthetic */ ChoosePlanViewModel$Event$CompleteSkuPurchase copy$default(ChoosePlanViewModel$Event$CompleteSkuPurchase choosePlanViewModel$Event$CompleteSkuPurchase, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = choosePlanViewModel$Event$CompleteSkuPurchase.skuName;
        }
        if ((i & 2) != 0) {
            str2 = choosePlanViewModel$Event$CompleteSkuPurchase.planName;
        }
        return choosePlanViewModel$Event$CompleteSkuPurchase.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSkuName() {
        return this.skuName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPlanName() {
        return this.planName;
    }

    public final ChoosePlanViewModel$Event$CompleteSkuPurchase copy(String skuName, String planName) {
        m.checkNotNullParameter(skuName, "skuName");
        m.checkNotNullParameter(planName, "planName");
        return new ChoosePlanViewModel$Event$CompleteSkuPurchase(skuName, planName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChoosePlanViewModel$Event$CompleteSkuPurchase)) {
            return false;
        }
        ChoosePlanViewModel$Event$CompleteSkuPurchase choosePlanViewModel$Event$CompleteSkuPurchase = (ChoosePlanViewModel$Event$CompleteSkuPurchase) other;
        return m.areEqual(this.skuName, choosePlanViewModel$Event$CompleteSkuPurchase.skuName) && m.areEqual(this.planName, choosePlanViewModel$Event$CompleteSkuPurchase.planName);
    }

    public final String getPlanName() {
        return this.planName;
    }

    public final String getSkuName() {
        return this.skuName;
    }

    public int hashCode() {
        String str = this.skuName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.planName;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CompleteSkuPurchase(skuName=");
        sbU.append(this.skuName);
        sbU.append(", planName=");
        return a.J(sbU, this.planName, ")");
    }
}
