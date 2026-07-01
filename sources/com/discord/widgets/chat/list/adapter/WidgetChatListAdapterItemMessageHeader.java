package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetChatListAdapterItemMessageHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageHeaderEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessageHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessageHeader extends WidgetChatListItem {
    private final WidgetChatListAdapterItemMessageHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessageHeader(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_message_header, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.chat_list_item_message_header_channel;
        TextView textView = (TextView) view.findViewById(R$id.chat_list_item_message_header_channel);
        if (textView != null) {
            i = R$id.chat_list_item_message_header_divider;
            View viewFindViewById = view.findViewById(R$id.chat_list_item_message_header_divider);
            if (viewFindViewById != null) {
                i = R$id.chat_list_item_message_header_guild;
                TextView textView2 = (TextView) view.findViewById(R$id.chat_list_item_message_header_guild);
                if (textView2 != null) {
                    i = R$id.chat_list_item_message_header_spacer;
                    Space space = (Space) view.findViewById(R$id.chat_list_item_message_header_spacer);
                    if (space != null) {
                        WidgetChatListAdapterItemMessageHeaderBinding widgetChatListAdapterItemMessageHeaderBinding = new WidgetChatListAdapterItemMessageHeaderBinding((RelativeLayout) view, textView, viewFindViewById, textView2, space);
                        m.checkNotNullExpressionValue(widgetChatListAdapterItemMessageHeaderBinding, "WidgetChatListAdapterIte…derBinding.bind(itemView)");
                        this.binding = widgetChatListAdapterItemMessageHeaderBinding;
                        return;
                    }
                }
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
        MessageHeaderEntry messageHeaderEntry = (MessageHeaderEntry) data;
        String strComponent2 = messageHeaderEntry.getText();
        String strComponent3 = messageHeaderEntry.getChannelName();
        View view = this.binding.c;
        m.checkNotNullExpressionValue(view, "binding.chatListItemMessageHeaderDivider");
        view.setVisibility(position > 0 ? 0 : 8);
        Space space = this.binding.e;
        m.checkNotNullExpressionValue(space, "binding.chatListItemMessageHeaderSpacer");
        space.setVisibility(position <= 0 ? 0 : 8);
        TextView textView = this.binding.f2327b;
        m.checkNotNullExpressionValue(textView, "binding.chatListItemMessageHeaderChannel");
        textView.setText(strComponent3);
        TextView textView2 = this.binding.d;
        m.checkNotNullExpressionValue(textView2, "binding.chatListItemMessageHeaderGuild");
        textView2.setText(strComponent2);
    }
}
