package com.discord.widgets.settings.premium;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: ChoosePlanViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChoosePlanViewModel$Event$ErrorSkuPurchase extends ChoosePlanViewModel$Event {
    private final int message;

    public ChoosePlanViewModel$Event$ErrorSkuPurchase(@StringRes int i) {
        super(null);
        this.message = i;
    }

    public static /* synthetic */ ChoosePlanViewModel$Event$ErrorSkuPurchase copy$default(ChoosePlanViewModel$Event$ErrorSkuPurchase choosePlanViewModel$Event$ErrorSkuPurchase, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = choosePlanViewModel$Event$ErrorSkuPurchase.message;
        }
        return choosePlanViewModel$Event$ErrorSkuPurchase.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMessage() {
        return this.message;
    }

    public final ChoosePlanViewModel$Event$ErrorSkuPurchase copy(@StringRes int message) {
        return new ChoosePlanViewModel$Event$ErrorSkuPurchase(message);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ChoosePlanViewModel$Event$ErrorSkuPurchase) && this.message == ((ChoosePlanViewModel$Event$ErrorSkuPurchase) other).message;
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
        return a.B(a.U("ErrorSkuPurchase(message="), this.message, ")");
    }
}
