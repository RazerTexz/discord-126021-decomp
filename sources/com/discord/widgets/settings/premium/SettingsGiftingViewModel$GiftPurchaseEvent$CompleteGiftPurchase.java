package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase extends SettingsGiftingViewModel$GiftPurchaseEvent {
    private final String newGiftCode;
    private final String skuName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase(String str, String str2) {
        super(null);
        m.checkNotNullParameter(str, "skuName");
        m.checkNotNullParameter(str2, "newGiftCode");
        this.skuName = str;
        this.newGiftCode = str2;
    }

    public static /* synthetic */ SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase copy$default(SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase settingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = settingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase.skuName;
        }
        if ((i & 2) != 0) {
            str2 = settingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase.newGiftCode;
        }
        return settingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSkuName() {
        return this.skuName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNewGiftCode() {
        return this.newGiftCode;
    }

    public final SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase copy(String skuName, String newGiftCode) {
        m.checkNotNullParameter(skuName, "skuName");
        m.checkNotNullParameter(newGiftCode, "newGiftCode");
        return new SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase(skuName, newGiftCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase)) {
            return false;
        }
        SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase settingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase = (SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase) other;
        return m.areEqual(this.skuName, settingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase.skuName) && m.areEqual(this.newGiftCode, settingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase.newGiftCode);
    }

    public final String getNewGiftCode() {
        return this.newGiftCode;
    }

    public final String getSkuName() {
        return this.skuName;
    }

    public int hashCode() {
        String str = this.skuName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.newGiftCode;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CompleteGiftPurchase(skuName=");
        sbU.append(this.skuName);
        sbU.append(", newGiftCode=");
        return a.J(sbU, this.newGiftCode, ")");
    }
}
