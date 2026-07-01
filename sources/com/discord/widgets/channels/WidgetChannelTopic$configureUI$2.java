package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelTopicViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetChannelTopic this$0;

    public WidgetChannelTopic$configureUI$2(WidgetChannelTopic widgetChannelTopic, WidgetChannelTopicViewModel$ViewState widgetChannelTopicViewModel$ViewState) {
        this.this$0 = widgetChannelTopic;
        this.$viewState = widgetChannelTopicViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelTopic.access$onClickMore(this.this$0, this.$viewState);
    }
}
