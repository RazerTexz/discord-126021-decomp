package com.discord.widgets.chat.list.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapter$HandlerOfScrolls extends RecyclerView$OnScrollListener {
    private long channelId;
    private int scrollState;
    public final /* synthetic */ WidgetChatListAdapter this$0;

    public WidgetChatListAdapter$HandlerOfScrolls(WidgetChatListAdapter widgetChatListAdapter) {
        this.this$0 = widgetChatListAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, scrollState);
        if (this.scrollState == scrollState && this.this$0.getData().getChannelId() == this.channelId) {
            return;
        }
        this.scrollState = scrollState;
        this.channelId = this.this$0.getData().getChannelId();
        WidgetChatListAdapter.access$publishInteractionState(this.this$0);
    }
}
