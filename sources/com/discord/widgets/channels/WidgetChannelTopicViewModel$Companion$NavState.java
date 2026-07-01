package com.discord.widgets.channels;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelTopicViewModel$Companion$NavState {
    private final boolean isOnHomeTab;
    private final boolean isRightPanelOpened;

    public WidgetChannelTopicViewModel$Companion$NavState(boolean z2, boolean z3) {
        this.isRightPanelOpened = z2;
        this.isOnHomeTab = z3;
    }

    public static /* synthetic */ WidgetChannelTopicViewModel$Companion$NavState copy$default(WidgetChannelTopicViewModel$Companion$NavState widgetChannelTopicViewModel$Companion$NavState, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetChannelTopicViewModel$Companion$NavState.isRightPanelOpened;
        }
        if ((i & 2) != 0) {
            z3 = widgetChannelTopicViewModel$Companion$NavState.isOnHomeTab;
        }
        return widgetChannelTopicViewModel$Companion$NavState.copy(z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsRightPanelOpened() {
        return this.isRightPanelOpened;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsOnHomeTab() {
        return this.isOnHomeTab;
    }

    public final WidgetChannelTopicViewModel$Companion$NavState copy(boolean isRightPanelOpened, boolean isOnHomeTab) {
        return new WidgetChannelTopicViewModel$Companion$NavState(isRightPanelOpened, isOnHomeTab);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelTopicViewModel$Companion$NavState)) {
            return false;
        }
        WidgetChannelTopicViewModel$Companion$NavState widgetChannelTopicViewModel$Companion$NavState = (WidgetChannelTopicViewModel$Companion$NavState) other;
        return this.isRightPanelOpened == widgetChannelTopicViewModel$Companion$NavState.isRightPanelOpened && this.isOnHomeTab == widgetChannelTopicViewModel$Companion$NavState.isOnHomeTab;
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
        boolean z2 = this.isRightPanelOpened;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isOnHomeTab;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isOnHomeTab() {
        return this.isOnHomeTab;
    }

    public final boolean isRightPanelOpened() {
        return this.isRightPanelOpened;
    }

    public String toString() {
        StringBuilder sbU = a.U("NavState(isRightPanelOpened=");
        sbU.append(this.isRightPanelOpened);
        sbU.append(", isOnHomeTab=");
        return a.O(sbU, this.isOnHomeTab, ")");
    }
}
