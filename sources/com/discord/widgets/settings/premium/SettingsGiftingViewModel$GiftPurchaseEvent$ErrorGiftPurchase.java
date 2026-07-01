package com.discord.widgets.settings.premium;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase extends SettingsGiftingViewModel$GiftPurchaseEvent {
    private final int message;

    public SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase(@StringRes int i) {
        super(null);
        this.message = i;
    }

    public static /* synthetic */ SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase copy$default(SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase settingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = settingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase.message;
        }
        return settingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMessage() {
        return this.message;
    }

    public final SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase copy(@StringRes int message) {
        return new SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase(message);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase) && this.message == ((SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase) other).message;
        }
        return true;
    }

    public final int getMessage() {
        return this.message;
    }

    public int hashCode() {
        return this.message;
    }

    public String toString() {
        return a.B(a.U("ErrorGiftPurchase(message="), this.message, ")");
    }
}
