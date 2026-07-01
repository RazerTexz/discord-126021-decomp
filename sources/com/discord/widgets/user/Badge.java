package com.discord.widgets.user;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Badge.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Badge {
    public static final Badge$Companion Companion = new Badge$Companion(null);
    private static final int GUILD_BOOST_LEVEL_1_MONTHS = 1;
    private static final int GUILD_BOOST_LEVEL_2_MONTHS = 2;
    private static final int GUILD_BOOST_LEVEL_3_MONTHS = 3;
    private static final int GUILD_BOOST_LEVEL_4_MONTHS = 6;
    private static final int GUILD_BOOST_LEVEL_5_MONTHS = 9;
    private static final int GUILD_BOOST_LEVEL_6_MONTHS = 12;
    private static final int GUILD_BOOST_LEVEL_7_MONTHS = 15;
    private static final int GUILD_BOOST_LEVEL_8_MONTHS = 18;
    private static final int GUILD_BOOST_LEVEL_9_MONTHS = 24;
    private final int icon;
    private final String objectType;
    private final boolean showPremiumUpSell;
    private final CharSequence text;
    private final CharSequence tooltip;

    public Badge() {
        this(0, null, null, false, null, 31, null);
    }

    public Badge(@DrawableRes int i, CharSequence charSequence, CharSequence charSequence2, boolean z2, String str) {
        this.icon = i;
        this.text = charSequence;
        this.tooltip = charSequence2;
        this.showPremiumUpSell = z2;
        this.objectType = str;
    }

    public static /* synthetic */ Badge copy$default(Badge badge, int i, CharSequence charSequence, CharSequence charSequence2, boolean z2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = badge.icon;
        }
        if ((i2 & 2) != 0) {
            charSequence = badge.text;
        }
        CharSequence charSequence3 = charSequence;
        if ((i2 & 4) != 0) {
            charSequence2 = badge.tooltip;
        }
        CharSequence charSequence4 = charSequence2;
        if ((i2 & 8) != 0) {
            z2 = badge.showPremiumUpSell;
        }
        boolean z3 = z2;
        if ((i2 & 16) != 0) {
            str = badge.objectType;
        }
        return badge.copy(i, charSequence3, charSequence4, z3, str);
    }

    public static final Function1<Badge, Unit> onBadgeClick(FragmentManager fragmentManager, Context context) {
        return Companion.onBadgeClick(fragmentManager, context);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CharSequence getTooltip() {
        return this.tooltip;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowPremiumUpSell() {
        return this.showPremiumUpSell;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getObjectType() {
        return this.objectType;
    }

    public final Badge copy(@DrawableRes int icon, CharSequence text, CharSequence tooltip, boolean showPremiumUpSell, String objectType) {
        return new Badge(icon, text, tooltip, showPremiumUpSell, objectType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Badge)) {
            return false;
        }
        Badge badge = (Badge) other;
        return this.icon == badge.icon && m.areEqual(this.text, badge.text) && m.areEqual(this.tooltip, badge.tooltip) && this.showPremiumUpSell == badge.showPremiumUpSell && m.areEqual(this.objectType, badge.objectType);
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final boolean getShowPremiumUpSell() {
        return this.showPremiumUpSell;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final CharSequence getTooltip() {
        return this.tooltip;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int i = this.icon * 31;
        CharSequence charSequence = this.text;
        int iHashCode = (i + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.tooltip;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        boolean z2 = this.showPremiumUpSell;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (iHashCode2 + r1) * 31;
        String str = this.objectType;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Badge(icon=");
        sbU.append(this.icon);
        sbU.append(", text=");
        sbU.append(this.text);
        sbU.append(", tooltip=");
        sbU.append(this.tooltip);
        sbU.append(", showPremiumUpSell=");
        sbU.append(this.showPremiumUpSell);
        sbU.append(", objectType=");
        return a.J(sbU, this.objectType, ")");
    }

    public /* synthetic */ Badge(int i, CharSequence charSequence, CharSequence charSequence2, boolean z2, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : charSequence, (i2 & 4) != 0 ? null : charSequence2, (i2 & 8) == 0 ? z2 : false, (i2 & 16) != 0 ? null : str);
    }
}
