package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetChatListAdapterItemEmptyPinsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EmptyPinsEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmptyPins.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmptyPins extends WidgetChatListItem {
    private final WidgetChatListAdapterItemEmptyPinsBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmptyPins(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_empty_pins, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.chat_list_empty_image;
        ImageView imageView = (ImageView) view.findViewById(R$id.chat_list_empty_image);
        if (imageView != null) {
            i = R$id.chat_list_empty_pins_text;
            TextView textView = (TextView) view.findViewById(R$id.chat_list_empty_pins_text);
            if (textView != null) {
                WidgetChatListAdapterItemEmptyPinsBinding widgetChatListAdapterItemEmptyPinsBinding = new WidgetChatListAdapterItemEmptyPinsBinding((RelativeLayout) view, imageView, textView);
                m.checkNotNullExpressionValue(widgetChatListAdapterItemEmptyPinsBinding, "WidgetChatListAdapterIte…insBinding.bind(itemView)");
                this.binding = widgetChatListAdapterItemEmptyPinsBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.f2317b;
        m.checkNotNullExpressionValue(textView, "binding.chatListEmptyPinsText");
        textView.setText(((EmptyPinsEntry) data).getText());
    }
}
