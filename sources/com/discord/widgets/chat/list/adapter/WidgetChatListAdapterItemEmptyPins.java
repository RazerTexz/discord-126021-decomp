package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemEmptyPinsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EmptyPinsEntry;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmptyPins.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmptyPins extends WidgetChatListItem {
    private final WidgetChatListAdapterItemEmptyPinsBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmptyPins(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_empty_pins, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_empty_image;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.chat_list_empty_image);
        if (imageView != null) {
            i = C5419R.id.chat_list_empty_pins_text;
            TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_empty_pins_text);
            if (textView != null) {
                WidgetChatListAdapterItemEmptyPinsBinding widgetChatListAdapterItemEmptyPinsBinding = new WidgetChatListAdapterItemEmptyPinsBinding((RelativeLayout) view, imageView, textView);
                C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemEmptyPinsBinding, "WidgetChatListAdapterIte…insBinding.bind(itemView)");
                this.binding = widgetChatListAdapterItemEmptyPinsBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.f16201b;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatListEmptyPinsText");
        textView.setText(((EmptyPinsEntry) data).getText());
    }
}
