package com.discord.widgets.servers.guild_role_subscription.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import b.d.b.a.outline;

/* JADX INFO: compiled from: PayoutStatusMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PayoutStatusMedia {
    private final int iconDrawableRes;
    private final int statusStringRes;

    public PayoutStatusMedia(@DrawableRes int i, @StringRes int i2) {
        this.iconDrawableRes = i;
        this.statusStringRes = i2;
    }

    public static /* synthetic */ PayoutStatusMedia copy$default(PayoutStatusMedia payoutStatusMedia, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = payoutStatusMedia.iconDrawableRes;
        }
        if ((i3 & 2) != 0) {
            i2 = payoutStatusMedia.statusStringRes;
        }
        return payoutStatusMedia.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIconDrawableRes() {
        return this.iconDrawableRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStatusStringRes() {
        return this.statusStringRes;
    }

    public final PayoutStatusMedia copy(@DrawableRes int iconDrawableRes, @StringRes int statusStringRes) {
        return new PayoutStatusMedia(iconDrawableRes, statusStringRes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayoutStatusMedia)) {
            return false;
        }
        PayoutStatusMedia payoutStatusMedia = (PayoutStatusMedia) other;
        return this.iconDrawableRes == payoutStatusMedia.iconDrawableRes && this.statusStringRes == payoutStatusMedia.statusStringRes;
    }

    public final int getIconDrawableRes() {
        return this.iconDrawableRes;
    }

    public final int getStatusStringRes() {
        return this.statusStringRes;
    }

    public int hashCode() {
        return (this.iconDrawableRes * 31) + this.statusStringRes;
    }

    public String toString() {
        StringBuilder sbU = outline.U("PayoutStatusMedia(iconDrawableRes=");
        sbU.append(this.iconDrawableRes);
        sbU.append(", statusStringRes=");
        return outline.B(sbU, this.statusStringRes, ")");
    }
}
