package com.discord.widgets.chat.list.adapter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetChatListItem extends MGRecyclerViewHolder<WidgetChatListAdapter, ChatListEntry> {
    private final Drawable backgroundBlockedExpanded;
    private Drawable defaultBackground;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListItem(int i, WidgetChatListAdapter widgetChatListAdapter) {
        super(i, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        this.defaultBackground = view.getBackground();
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        this.backgroundBlockedExpanded = new ColorDrawable(ColorCompat.getThemedColor(view2, 2130970273));
        this.itemView.setOnTouchListener(new WidgetChatListItem$1(this, widgetChatListAdapter));
    }

    public final void configureCellHighlight(Message message, View highlightView, View gutterView) {
        int themedColor;
        int themedColor2;
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(highlightView, "highlightView");
        m.checkNotNullParameter(gutterView, "gutterView");
        boolean z2 = true;
        if (message.isEphemeralMessage() || message.isFailed()) {
            themedColor = ColorCompat.getThemedColor(highlightView.getContext(), 2130968908);
            themedColor2 = ColorCompat.getThemedColor(gutterView, 2130969062);
        } else if (WidgetChatListItemKt.isUserMentioned((WidgetChatListAdapter) this.adapter, message)) {
            themedColor = ColorCompat.getThemedColor(highlightView.getContext(), 2130970288);
            themedColor2 = ColorCompat.getColor(gutterView, 2131100410);
        } else {
            themedColor = 0;
            themedColor2 = 0;
            z2 = false;
        }
        highlightView.setVisibility(z2 ? 0 : 8);
        gutterView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            highlightView.setBackgroundColor(themedColor);
            gutterView.setBackgroundColor(themedColor2);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        view.setBackground(data.isInExpandedBlockedMessageChunk() ? this.backgroundBlockedExpanded : this.defaultBackground);
    }
}
