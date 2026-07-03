package com.discord.widgets.chat.list.actions;

import android.view.View;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MoreEmojisViewHolder extends MGRecyclerViewHolder<WidgetChatListActionsEmojisAdapter, EmojiItem> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreEmojisViewHolder(WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter) {
        super(C5419R.layout.view_chat_list_actions_emoji_item_more, widgetChatListActionsEmojisAdapter);
        C12238m.checkNotNullParameter(widgetChatListActionsEmojisAdapter, "adapter");
    }

    public static final /* synthetic */ WidgetChatListActionsEmojisAdapter access$getAdapter$p(MoreEmojisViewHolder moreEmojisViewHolder) {
        return (WidgetChatListActionsEmojisAdapter) moreEmojisViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, EmojiItem data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.MoreEmojisViewHolder.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoreEmojisViewHolder.access$getAdapter$p(MoreEmojisViewHolder.this).getOnClickMoreEmojis().invoke();
            }
        });
    }
}
