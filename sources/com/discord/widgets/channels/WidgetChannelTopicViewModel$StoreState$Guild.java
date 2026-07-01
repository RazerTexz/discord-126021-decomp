package com.discord.widgets.channels;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChannelTopicViewModel$StoreState$Guild extends WidgetChannelTopicViewModel$StoreState {
    private final boolean isOnHomeTab;
    private final boolean isRightPanelOpened;

    public /* synthetic */ WidgetChannelTopicViewModel$StoreState$Guild(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, z3);
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

    private WidgetChannelTopicViewModel$StoreState$Guild(boolean z2, boolean z3) {
        super(z2, z3, null);
        this.isRightPanelOpened = z2;
        this.isOnHomeTab = z3;
    }
}
