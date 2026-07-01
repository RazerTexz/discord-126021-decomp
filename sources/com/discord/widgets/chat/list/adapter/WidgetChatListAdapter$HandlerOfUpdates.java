package com.discord.widgets.chat.list.adapter;


/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapter$HandlerOfUpdates implements Runnable {
    private long channelId;
    private long oldestMessageId;
    public final /* synthetic */ WidgetChatListAdapter this$0;

    public WidgetChatListAdapter$HandlerOfUpdates(WidgetChatListAdapter widgetChatListAdapter) {
        this.this$0 = widgetChatListAdapter;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.channelId != this.this$0.getData().getChannelId()) {
            boolean z2 = this.channelId != 0;
            this.channelId = this.this$0.getData().getChannelId();
            if (z2) {
                this.this$0.scrollToMessageId(0L, WidgetChatListAdapter$HandlerOfUpdates$run$1.INSTANCE);
            }
            WidgetChatListAdapter.access$setTouchedSinceLastJump$p(this.this$0, false);
        }
        if (this.oldestMessageId != this.this$0.getData().getOldestMessageId()) {
            this.oldestMessageId = this.this$0.getData().getOldestMessageId();
            this.this$0.getEventHandler().onOldestMessageId(this.channelId, this.oldestMessageId);
        }
        WidgetChatListAdapter.access$publishInteractionState(this.this$0);
    }
}
