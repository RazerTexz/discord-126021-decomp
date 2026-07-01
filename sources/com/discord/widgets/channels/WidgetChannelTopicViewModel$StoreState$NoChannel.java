package com.discord.widgets.channels;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelTopicViewModel$StoreState$NoChannel extends WidgetChannelTopicViewModel$StoreState {
    private final boolean isOnHomeTab;
    private final boolean isRightPanelOpened;

    public WidgetChannelTopicViewModel$StoreState$NoChannel(boolean z2, boolean z3) {
        super(z2, z3, null);
        this.isRightPanelOpened = z2;
        this.isOnHomeTab = z3;
    }

    public static /* synthetic */ WidgetChannelTopicViewModel$StoreState$NoChannel copy$default(WidgetChannelTopicViewModel$StoreState$NoChannel widgetChannelTopicViewModel$StoreState$NoChannel, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetChannelTopicViewModel$StoreState$NoChannel.getIsRightPanelOpened();
        }
        if ((i & 2) != 0) {
            z3 = widgetChannelTopicViewModel$StoreState$NoChannel.getIsOnHomeTab();
        }
        return widgetChannelTopicViewModel$StoreState$NoChannel.copy(z2, z3);
    }

    public final boolean component1() {
        return getIsRightPanelOpened();
    }

    public final boolean component2() {
        return getIsOnHomeTab();
    }

    public final WidgetChannelTopicViewModel$StoreState$NoChannel copy(boolean isRightPanelOpened, boolean isOnHomeTab) {
        return new WidgetChannelTopicViewModel$StoreState$NoChannel(isRightPanelOpened, isOnHomeTab);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelTopicViewModel$StoreState$NoChannel)) {
            return false;
        }
        WidgetChannelTopicViewModel$StoreState$NoChannel widgetChannelTopicViewModel$StoreState$NoChannel = (WidgetChannelTopicViewModel$StoreState$NoChannel) other;
        return getIsRightPanelOpened() == widgetChannelTopicViewModel$StoreState$NoChannel.getIsRightPanelOpened() && getIsOnHomeTab() == widgetChannelTopicViewModel$StoreState$NoChannel.getIsOnHomeTab();
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
        boolean isRightPanelOpened = getIsRightPanelOpened();
        ?? r0 = isRightPanelOpened;
        if (isRightPanelOpened) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean isOnHomeTab = getIsOnHomeTab();
        return i + (isOnHomeTab ? 1 : isOnHomeTab);
    }

    @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel$StoreState
    /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
    public boolean getIsOnHomeTab() {
        return this.isOnHomeTab;
    }

    @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel$StoreState
    /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
    public boolean getIsRightPanelOpened() {
        return this.isRightPanelOpened;
    }

    public String toString() {
        StringBuilder sbU = a.U("NoChannel(isRightPanelOpened=");
        sbU.append(getIsRightPanelOpened());
        sbU.append(", isOnHomeTab=");
        sbU.append(getIsOnHomeTab());
        sbU.append(")");
        return sbU.toString();
    }
}
