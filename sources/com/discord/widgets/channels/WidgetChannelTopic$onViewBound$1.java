package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelTopic this$0;

    public WidgetChannelTopic$onViewBound$1(WidgetChannelTopic widgetChannelTopic) {
        this.this$0 = widgetChannelTopic;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelTopic.access$onToggleTopicExpansionState(this.this$0);
    }
}
