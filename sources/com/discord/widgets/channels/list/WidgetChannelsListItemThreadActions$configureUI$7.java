package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions$configureUI$7 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelsListItemThreadActions$Model $this_configureUI;
    public final /* synthetic */ WidgetChannelsListItemThreadActions this$0;

    public WidgetChannelsListItemThreadActions$configureUI$7(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions, WidgetChannelsListItemThreadActions$Model widgetChannelsListItemThreadActions$Model) {
        this.this$0 = widgetChannelsListItemThreadActions;
        this.$this_configureUI = widgetChannelsListItemThreadActions$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListItemThreadActions.access$leaveThread(this.this$0, this.$this_configureUI.getChannel());
    }
}
