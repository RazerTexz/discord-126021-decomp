package com.discord.widgets.guilds.profile;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildProfileSheetViewModel$TabItems {
    private final boolean ableToInstantInvite;
    private final boolean canAccessSettings;
    private final int premiumSubscriptionCount;

    public WidgetGuildProfileSheetViewModel$TabItems(boolean z2, boolean z3, int i) {
        this.canAccessSettings = z2;
        this.ableToInstantInvite = z3;
        this.premiumSubscriptionCount = i;
    }

    public static /* synthetic */ WidgetGuildProfileSheetViewModel$TabItems copy$default(WidgetGuildProfileSheetViewModel$TabItems widgetGuildProfileSheetViewModel$TabItems, boolean z2, boolean z3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = widgetGuildProfileSheetViewModel$TabItems.canAccessSettings;
        }
        if ((i2 & 2) != 0) {
            z3 = widgetGuildProfileSheetViewModel$TabItems.ableToInstantInvite;
        }
        if ((i2 & 4) != 0) {
            i = widgetGuildProfileSheetViewModel$TabItems.premiumSubscriptionCount;
        }
        return widgetGuildProfileSheetViewModel$TabItems.copy(z2, z3, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanAccessSettings() {
        return this.canAccessSettings;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAbleToInstantInvite() {
        return this.ableToInstantInvite;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPremiumSubscriptionCount() {
        return this.premiumSubscriptionCount;
    }

    public final WidgetGuildProfileSheetViewModel$TabItems copy(boolean canAccessSettings, boolean ableToInstantInvite, int premiumSubscriptionCount) {
        return new WidgetGuildProfileSheetViewModel$TabItems(canAccessSettings, ableToInstantInvite, premiumSubscriptionCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildProfileSheetViewModel$TabItems)) {
            return false;
        }
        WidgetGuildProfileSheetViewModel$TabItems widgetGuildProfileSheetViewModel$TabItems = (WidgetGuildProfileSheetViewModel$TabItems) other;
        return this.canAccessSettings == widgetGuildProfileSheetViewModel$TabItems.canAccessSettings && this.ableToInstantInvite == widgetGuildProfileSheetViewModel$TabItems.ableToInstantInvite && this.premiumSubscriptionCount == widgetGuildProfileSheetViewModel$TabItems.premiumSubscriptionCount;
    }

    public final boolean getAbleToInstantInvite() {
        return this.ableToInstantInvite;
    }

    public final boolean getCanAccessSettings() {
        return this.canAccessSettings;
    }

    public final int getPremiumSubscriptionCount() {
        return this.premiumSubscriptionCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        boolean z2 = this.canAccessSettings;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.ableToInstantInvite;
        return ((i + (z3 ? 1 : z3)) * 31) + this.premiumSubscriptionCount;
    }

    public String toString() {
        StringBuilder sbU = a.U("TabItems(canAccessSettings=");
        sbU.append(this.canAccessSettings);
        sbU.append(", ableToInstantInvite=");
        sbU.append(this.ableToInstantInvite);
        sbU.append(", premiumSubscriptionCount=");
        return a.B(sbU, this.premiumSubscriptionCount, ")");
    }
}
