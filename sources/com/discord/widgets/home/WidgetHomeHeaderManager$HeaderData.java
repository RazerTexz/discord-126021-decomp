package com.discord.widgets.home;

import androidx.annotation.DrawableRes;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHomeHeaderManager$HeaderData {
    private final Integer drawableRes;
    private final boolean leftButtonIsBack;
    private final CharSequence subtitle;
    private final CharSequence title;
    private final Integer trailingDrawable;

    public WidgetHomeHeaderManager$HeaderData(CharSequence charSequence, CharSequence charSequence2, @DrawableRes Integer num, boolean z2, @DrawableRes Integer num2) {
        this.title = charSequence;
        this.subtitle = charSequence2;
        this.drawableRes = num;
        this.leftButtonIsBack = z2;
        this.trailingDrawable = num2;
    }

    public static /* synthetic */ WidgetHomeHeaderManager$HeaderData copy$default(WidgetHomeHeaderManager$HeaderData widgetHomeHeaderManager$HeaderData, CharSequence charSequence, CharSequence charSequence2, Integer num, boolean z2, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = widgetHomeHeaderManager$HeaderData.title;
        }
        if ((i & 2) != 0) {
            charSequence2 = widgetHomeHeaderManager$HeaderData.subtitle;
        }
        CharSequence charSequence3 = charSequence2;
        if ((i & 4) != 0) {
            num = widgetHomeHeaderManager$HeaderData.drawableRes;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            z2 = widgetHomeHeaderManager$HeaderData.leftButtonIsBack;
        }
        boolean z3 = z2;
        if ((i & 16) != 0) {
            num2 = widgetHomeHeaderManager$HeaderData.trailingDrawable;
        }
        return widgetHomeHeaderManager$HeaderData.copy(charSequence, charSequence3, num3, z3, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getSubtitle() {
        return this.subtitle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getDrawableRes() {
        return this.drawableRes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getLeftButtonIsBack() {
        return this.leftButtonIsBack;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getTrailingDrawable() {
        return this.trailingDrawable;
    }

    public final WidgetHomeHeaderManager$HeaderData copy(CharSequence title, CharSequence subtitle, @DrawableRes Integer drawableRes, boolean leftButtonIsBack, @DrawableRes Integer trailingDrawable) {
        return new WidgetHomeHeaderManager$HeaderData(title, subtitle, drawableRes, leftButtonIsBack, trailingDrawable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHomeHeaderManager$HeaderData)) {
            return false;
        }
        WidgetHomeHeaderManager$HeaderData widgetHomeHeaderManager$HeaderData = (WidgetHomeHeaderManager$HeaderData) other;
        return m.areEqual(this.title, widgetHomeHeaderManager$HeaderData.title) && m.areEqual(this.subtitle, widgetHomeHeaderManager$HeaderData.subtitle) && m.areEqual(this.drawableRes, widgetHomeHeaderManager$HeaderData.drawableRes) && this.leftButtonIsBack == widgetHomeHeaderManager$HeaderData.leftButtonIsBack && m.areEqual(this.trailingDrawable, widgetHomeHeaderManager$HeaderData.trailingDrawable);
    }

    public final Integer getDrawableRes() {
        return this.drawableRes;
    }

    public final boolean getLeftButtonIsBack() {
        return this.leftButtonIsBack;
    }

    public final CharSequence getSubtitle() {
        return this.subtitle;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final Integer getTrailingDrawable() {
        return this.trailingDrawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        CharSequence charSequence = this.title;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.subtitle;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Integer num = this.drawableRes;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z2 = this.leftButtonIsBack;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode3 + r2) * 31;
        Integer num2 = this.trailingDrawable;
        return i + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("HeaderData(title=");
        sbU.append(this.title);
        sbU.append(", subtitle=");
        sbU.append(this.subtitle);
        sbU.append(", drawableRes=");
        sbU.append(this.drawableRes);
        sbU.append(", leftButtonIsBack=");
        sbU.append(this.leftButtonIsBack);
        sbU.append(", trailingDrawable=");
        return a.F(sbU, this.trailingDrawable, ")");
    }

    public /* synthetic */ WidgetHomeHeaderManager$HeaderData(CharSequence charSequence, CharSequence charSequence2, Integer num, boolean z2, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, (i & 2) != 0 ? null : charSequence2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : num2);
    }
}
