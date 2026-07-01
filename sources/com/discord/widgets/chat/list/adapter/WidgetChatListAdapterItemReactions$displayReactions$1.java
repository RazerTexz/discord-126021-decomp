package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.message.reaction.MessageReaction;

/* JADX INFO: compiled from: WidgetChatListAdapterItemReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemReactions$displayReactions$1 implements View$OnClickListener {
    public final /* synthetic */ boolean $canAddReactions;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ MessageReaction $reaction;
    public final /* synthetic */ WidgetChatListAdapterItemReactions this$0;

    public WidgetChatListAdapterItemReactions$displayReactions$1(WidgetChatListAdapterItemReactions widgetChatListAdapterItemReactions, long j, MessageReaction messageReaction, boolean z2) {
        this.this$0 = widgetChatListAdapterItemReactions;
        this.$messageId = j;
        this.$reaction = messageReaction;
        this.$canAddReactions = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemReactions.access$getAdapter$p(this.this$0).onReactionClicked(this.$messageId, this.$reaction, this.$canAddReactions);
    }
}
