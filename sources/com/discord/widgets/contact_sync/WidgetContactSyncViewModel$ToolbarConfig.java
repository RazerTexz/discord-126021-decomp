package com.discord.widgets.contact_sync;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetContactSyncViewModel$ToolbarConfig {
    private final boolean showBackButton;
    private final boolean showSkip;

    public WidgetContactSyncViewModel$ToolbarConfig(boolean z2, boolean z3) {
        this.showBackButton = z2;
        this.showSkip = z3;
    }

    public static /* synthetic */ WidgetContactSyncViewModel$ToolbarConfig copy$default(WidgetContactSyncViewModel$ToolbarConfig widgetContactSyncViewModel$ToolbarConfig, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetContactSyncViewModel$ToolbarConfig.showBackButton;
        }
        if ((i & 2) != 0) {
            z3 = widgetContactSyncViewModel$ToolbarConfig.showSkip;
        }
        return widgetContactSyncViewModel$ToolbarConfig.copy(z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowBackButton() {
        return this.showBackButton;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowSkip() {
        return this.showSkip;
    }

    public final WidgetContactSyncViewModel$ToolbarConfig copy(boolean showBackButton, boolean showSkip) {
        return new WidgetContactSyncViewModel$ToolbarConfig(showBackButton, showSkip);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetContactSyncViewModel$ToolbarConfig)) {
            return false;
        }
        WidgetContactSyncViewModel$ToolbarConfig widgetContactSyncViewModel$ToolbarConfig = (WidgetContactSyncViewModel$ToolbarConfig) other;
        return this.showBackButton == widgetContactSyncViewModel$ToolbarConfig.showBackButton && this.showSkip == widgetContactSyncViewModel$ToolbarConfig.showSkip;
    }

    public final boolean getShowBackButton() {
        return this.showBackButton;
    }

    public final boolean getShowSkip() {
        return this.showSkip;
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
        boolean z2 = this.showBackButton;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.showSkip;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("ToolbarConfig(showBackButton=");
        sbU.append(this.showBackButton);
        sbU.append(", showSkip=");
        return a.O(sbU, this.showSkip, ")");
    }
}
