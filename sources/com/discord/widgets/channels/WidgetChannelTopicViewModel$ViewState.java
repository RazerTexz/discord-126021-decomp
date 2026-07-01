package com.discord.widgets.channels;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChannelTopicViewModel$ViewState {
    private final boolean isOnHomeTab;
    private final boolean isRightPanelOpened;

    private WidgetChannelTopicViewModel$ViewState(boolean z2, boolean z3) {
        this.isRightPanelOpened = z2;
        this.isOnHomeTab = z3;
    }

    /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
    public boolean getIsOnHomeTab() {
        return this.isOnHomeTab;
    }

    /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
    public boolean getIsRightPanelOpened() {
        return this.isRightPanelOpened;
    }

    public /* synthetic */ WidgetChannelTopicViewModel$ViewState(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, z3);
    }
}
