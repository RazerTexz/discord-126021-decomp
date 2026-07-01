package com.discord.utilities.premium;

import android.view.View;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PremiumUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PremiumUtils$BoostFeatureBadgeData {
    private final int iconColor;
    private final Function1<View, Unit> onClickListener;
    private final CharSequence text;
    private final int textColor;

    /* JADX WARN: Multi-variable type inference failed */
    public PremiumUtils$BoostFeatureBadgeData(Function1<? super View, Unit> function1, int i, CharSequence charSequence, int i2) {
        m.checkNotNullParameter(charSequence, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.onClickListener = function1;
        this.iconColor = i;
        this.text = charSequence;
        this.textColor = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PremiumUtils$BoostFeatureBadgeData copy$default(PremiumUtils$BoostFeatureBadgeData premiumUtils$BoostFeatureBadgeData, Function1 function1, int i, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = premiumUtils$BoostFeatureBadgeData.onClickListener;
        }
        if ((i3 & 2) != 0) {
            i = premiumUtils$BoostFeatureBadgeData.iconColor;
        }
        if ((i3 & 4) != 0) {
            charSequence = premiumUtils$BoostFeatureBadgeData.text;
        }
        if ((i3 & 8) != 0) {
            i2 = premiumUtils$BoostFeatureBadgeData.textColor;
        }
        return premiumUtils$BoostFeatureBadgeData.copy(function1, i, charSequence, i2);
    }

    public final Function1<View, Unit> component1() {
        return this.onClickListener;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIconColor() {
        return this.iconColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CharSequence getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    public final PremiumUtils$BoostFeatureBadgeData copy(Function1<? super View, Unit> onClickListener, int iconColor, CharSequence text, int textColor) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        return new PremiumUtils$BoostFeatureBadgeData(onClickListener, iconColor, text, textColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PremiumUtils$BoostFeatureBadgeData)) {
            return false;
        }
        PremiumUtils$BoostFeatureBadgeData premiumUtils$BoostFeatureBadgeData = (PremiumUtils$BoostFeatureBadgeData) other;
        return m.areEqual(this.onClickListener, premiumUtils$BoostFeatureBadgeData.onClickListener) && this.iconColor == premiumUtils$BoostFeatureBadgeData.iconColor && m.areEqual(this.text, premiumUtils$BoostFeatureBadgeData.text) && this.textColor == premiumUtils$BoostFeatureBadgeData.textColor;
    }

    public final int getIconColor() {
        return this.iconColor;
    }

    public final Function1<View, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public int hashCode() {
        Function1<View, Unit> function1 = this.onClickListener;
        int iHashCode = (((function1 != null ? function1.hashCode() : 0) * 31) + this.iconColor) * 31;
        CharSequence charSequence = this.text;
        return ((iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31) + this.textColor;
    }

    public String toString() {
        StringBuilder sbU = a.U("BoostFeatureBadgeData(onClickListener=");
        sbU.append(this.onClickListener);
        sbU.append(", iconColor=");
        sbU.append(this.iconColor);
        sbU.append(", text=");
        sbU.append(this.text);
        sbU.append(", textColor=");
        return a.B(sbU, this.textColor, ")");
    }
}
