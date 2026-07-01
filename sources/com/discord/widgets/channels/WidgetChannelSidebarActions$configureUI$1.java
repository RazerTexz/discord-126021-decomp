package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActions$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelSidebarActionsViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetChannelSidebarActions this$0;

    public WidgetChannelSidebarActions$configureUI$1(WidgetChannelSidebarActions widgetChannelSidebarActions, WidgetChannelSidebarActionsViewModel$ViewState widgetChannelSidebarActionsViewModel$ViewState) {
        this.this$0 = widgetChannelSidebarActions;
        this.$viewState = widgetChannelSidebarActionsViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelSidebarActions.access$startPrivateCall(this.this$0, ((WidgetChannelSidebarActionsViewModel$ViewState$Private) this.$viewState).getChannelId(), false);
    }
}
