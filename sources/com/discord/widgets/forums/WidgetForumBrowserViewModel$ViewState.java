package com.discord.widgets.forums;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetForumBrowserViewModel$ViewState {
    private final WidgetForumBrowserViewModel$NsfwPanelState nsfwPanelState;

    private WidgetForumBrowserViewModel$ViewState(WidgetForumBrowserViewModel$NsfwPanelState widgetForumBrowserViewModel$NsfwPanelState) {
        this.nsfwPanelState = widgetForumBrowserViewModel$NsfwPanelState;
    }

    public WidgetForumBrowserViewModel$NsfwPanelState getNsfwPanelState() {
        return this.nsfwPanelState;
    }

    public /* synthetic */ WidgetForumBrowserViewModel$ViewState(WidgetForumBrowserViewModel$NsfwPanelState widgetForumBrowserViewModel$NsfwPanelState, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetForumBrowserViewModel$NsfwPanelState);
    }
}
