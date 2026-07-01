package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelAddServer$onConfigure$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelsListAdapter$ItemChannelAddServer this$0;

    public WidgetChannelsListAdapter$ItemChannelAddServer$onConfigure$$inlined$apply$lambda$1(WidgetChannelsListAdapter$ItemChannelAddServer widgetChannelsListAdapter$ItemChannelAddServer) {
        this.this$0 = widgetChannelsListAdapter$ItemChannelAddServer;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListAdapter$ItemChannelAddServer.access$getAdapter$p(this.this$0).getOnAddServer().invoke();
    }
}
