package com.discord.widgets.chat.list.actions;

import android.view.View;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.MoreEmojisViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActionsEmojisAdapter4 extends MGRecyclerViewHolder<WidgetChatListActionsEmojisAdapter, WidgetChatListActionsEmojisAdapter2> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActionsEmojisAdapter4(WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter) {
        super(R.layout.view_chat_list_actions_emoji_item_more, widgetChatListActionsEmojisAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListActionsEmojisAdapter, "adapter");
    }

    public static final /* synthetic */ WidgetChatListActionsEmojisAdapter access$getAdapter$p(WidgetChatListActionsEmojisAdapter4 widgetChatListActionsEmojisAdapter4) {
        return (WidgetChatListActionsEmojisAdapter) widgetChatListActionsEmojisAdapter4.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, WidgetChatListActionsEmojisAdapter2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.MoreEmojisViewHolder.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListActionsEmojisAdapter4.access$getAdapter$p(WidgetChatListActionsEmojisAdapter4.this).getOnClickMoreEmojis().invoke();
            }
        });
    }
}
