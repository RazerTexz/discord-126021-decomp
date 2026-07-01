package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.databinding.WidgetChatListAdapterItemBlockedBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.widgets.chat.list.entries.BlockedMessagesEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemBlocked.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemBlocked extends WidgetChatListItem {
    private final WidgetChatListAdapterItemBlockedBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemBlocked(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_blocked, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R$id.chat_list_adapter_item_blocked);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.chat_list_adapter_item_blocked)));
        }
        WidgetChatListAdapterItemBlockedBinding widgetChatListAdapterItemBlockedBinding = new WidgetChatListAdapterItemBlockedBinding((RelativeLayout) view, textView);
        m.checkNotNullExpressionValue(widgetChatListAdapterItemBlockedBinding, "WidgetChatListAdapterIte…kedBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemBlockedBinding;
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemBlocked widgetChatListAdapterItemBlocked) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemBlocked.adapter;
    }

    private final CharSequence getBlockedText(Resources resources, Context context, int i) {
        return b.i(resources, 2131887263, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, R$plurals.blocked_messages_count, i, Integer.valueOf(i))}, null, 4);
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
        BlockedMessagesEntry blockedMessagesEntry = (BlockedMessagesEntry) data;
        Message message = blockedMessagesEntry.getMessage();
        int blockedCount = blockedMessagesEntry.getBlockedCount();
        TextView textView = this.binding.f2312b;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemBlocked");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        m.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(getBlockedText(resources, a.x(this.itemView, "itemView", "itemView.context"), blockedCount));
        this.binding.a.setOnClickListener(new WidgetChatListAdapterItemBlocked$onConfigure$1(this, message));
    }
}
