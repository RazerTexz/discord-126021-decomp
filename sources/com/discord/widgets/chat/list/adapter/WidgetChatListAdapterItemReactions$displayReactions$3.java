package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChatListAdapterItemReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemReactions$displayReactions$3 implements View$OnClickListener {
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ WidgetChatListAdapterItemReactions this$0;

    public WidgetChatListAdapterItemReactions$displayReactions$3(WidgetChatListAdapterItemReactions widgetChatListAdapterItemReactions, long j) {
        this.this$0 = widgetChatListAdapterItemReactions;
        this.$messageId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemReactions.access$getAdapter$p(this.this$0).onQuickAddReactionClicked(this.$messageId);
    }
}
