package com.discord.widgets.announcements;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;

/* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheet$configureChannelSelector$2 implements View$OnClickListener {
    public final /* synthetic */ Channel $selectedChannel;
    public final /* synthetic */ WidgetChannelFollowSheet this$0;

    public WidgetChannelFollowSheet$configureChannelSelector$2(WidgetChannelFollowSheet widgetChannelFollowSheet, Channel channel) {
        this.this$0 = widgetChannelFollowSheet;
        this.$selectedChannel = channel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelFollowSheet.access$getViewModel$p(this.this$0).followChannel(this.$selectedChannel.getId());
    }
}
