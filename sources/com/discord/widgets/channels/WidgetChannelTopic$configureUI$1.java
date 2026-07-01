package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.user.WidgetUserMutualGuilds;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelTopicViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetChannelTopic this$0;

    public WidgetChannelTopic$configureUI$1(WidgetChannelTopic widgetChannelTopic, WidgetChannelTopicViewModel$ViewState widgetChannelTopicViewModel$ViewState) {
        this.this$0 = widgetChannelTopic;
        this.$viewState = widgetChannelTopicViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Long recipientUserId = ((WidgetChannelTopicViewModel$ViewState$DM) this.$viewState).getRecipientUserId();
        if (recipientUserId != null) {
            WidgetUserMutualGuilds.Companion.show(this.this$0.requireContext(), recipientUserId.longValue());
        }
    }
}
