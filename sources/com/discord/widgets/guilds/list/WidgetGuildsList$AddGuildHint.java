package com.discord.widgets.guilds.list;

import b.d.b.a.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildsList$AddGuildHint {
    public static final WidgetGuildsList$AddGuildHint$Companion Companion = new WidgetGuildsList$AddGuildHint$Companion(null);
    private final boolean isAddGuildHint;
    private final boolean isEligible;

    public WidgetGuildsList$AddGuildHint(boolean z2, boolean z3) {
        this.isEligible = z2;
        this.isAddGuildHint = z3;
    }

    public static /* synthetic */ WidgetGuildsList$AddGuildHint copy$default(WidgetGuildsList$AddGuildHint widgetGuildsList$AddGuildHint, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetGuildsList$AddGuildHint.isEligible;
        }
        if ((i & 2) != 0) {
            z3 = widgetGuildsList$AddGuildHint.isAddGuildHint;
        }
        return widgetGuildsList$AddGuildHint.copy(z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsEligible() {
        return this.isEligible;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsAddGuildHint() {
        return this.isAddGuildHint;
    }

    public final WidgetGuildsList$AddGuildHint copy(boolean isEligible, boolean isAddGuildHint) {
        return new WidgetGuildsList$AddGuildHint(isEligible, isAddGuildHint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildsList$AddGuildHint)) {
            return false;
        }
        WidgetGuildsList$AddGuildHint widgetGuildsList$AddGuildHint = (WidgetGuildsList$AddGuildHint) other;
        return this.isEligible == widgetGuildsList$AddGuildHint.isEligible && this.isAddGuildHint == widgetGuildsList$AddGuildHint.isAddGuildHint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z2 = this.isEligible;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isAddGuildHint;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isAddGuildHint() {
        return this.isAddGuildHint;
    }

    public final boolean isEligible() {
        return this.isEligible;
    }

    public String toString() {
        StringBuilder sbU = a.U("AddGuildHint(isEligible=");
        sbU.append(this.isEligible);
        sbU.append(", isAddGuildHint=");
        return a.O(sbU, this.isAddGuildHint, ")");
    }

    public /* synthetic */ WidgetGuildsList$AddGuildHint(boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, (i & 2) != 0 ? false : z3);
    }
}
