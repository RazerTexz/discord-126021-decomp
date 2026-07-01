package com.discord.widgets.forums;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetForumBrowserViewModel$ViewState$Loading extends WidgetForumBrowserViewModel$ViewState {
    private final WidgetForumBrowserViewModel$NsfwPanelState nsfwPanelState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel$ViewState$Loading(WidgetForumBrowserViewModel$NsfwPanelState widgetForumBrowserViewModel$NsfwPanelState) {
        super(widgetForumBrowserViewModel$NsfwPanelState, null);
        m.checkNotNullParameter(widgetForumBrowserViewModel$NsfwPanelState, "nsfwPanelState");
        this.nsfwPanelState = widgetForumBrowserViewModel$NsfwPanelState;
    }

    public static /* synthetic */ WidgetForumBrowserViewModel$ViewState$Loading copy$default(WidgetForumBrowserViewModel$ViewState$Loading widgetForumBrowserViewModel$ViewState$Loading, WidgetForumBrowserViewModel$NsfwPanelState widgetForumBrowserViewModel$NsfwPanelState, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetForumBrowserViewModel$NsfwPanelState = widgetForumBrowserViewModel$ViewState$Loading.getNsfwPanelState();
        }
        return widgetForumBrowserViewModel$ViewState$Loading.copy(widgetForumBrowserViewModel$NsfwPanelState);
    }

    public final WidgetForumBrowserViewModel$NsfwPanelState component1() {
        return getNsfwPanelState();
    }

    public final WidgetForumBrowserViewModel$ViewState$Loading copy(WidgetForumBrowserViewModel$NsfwPanelState nsfwPanelState) {
        m.checkNotNullParameter(nsfwPanelState, "nsfwPanelState");
        return new WidgetForumBrowserViewModel$ViewState$Loading(nsfwPanelState);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetForumBrowserViewModel$ViewState$Loading) && m.areEqual(getNsfwPanelState(), ((WidgetForumBrowserViewModel$ViewState$Loading) other).getNsfwPanelState());
        }
        return true;
    }

    @Override // com.discord.widgets.forums.WidgetForumBrowserViewModel$ViewState
    public WidgetForumBrowserViewModel$NsfwPanelState getNsfwPanelState() {
        return this.nsfwPanelState;
    }

    public int hashCode() {
        WidgetForumBrowserViewModel$NsfwPanelState nsfwPanelState = getNsfwPanelState();
        if (nsfwPanelState != null) {
            return nsfwPanelState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loading(nsfwPanelState=");
        sbU.append(getNsfwPanelState());
        sbU.append(")");
        return sbU.toString();
    }
}
