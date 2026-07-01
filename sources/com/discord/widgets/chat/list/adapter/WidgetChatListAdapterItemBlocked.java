package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemBlockedBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.widgets.chat.list.entries.BlockedMessagesEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: WidgetChatListAdapterItemBlocked.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemBlocked extends WidgetChatListItem {
    private final WidgetChatListAdapterItemBlockedBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemBlocked(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_blocked, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R.id.chat_list_adapter_item_blocked);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.chat_list_adapter_item_blocked)));
        }
        WidgetChatListAdapterItemBlockedBinding widgetChatListAdapterItemBlockedBinding = new WidgetChatListAdapterItemBlockedBinding((RelativeLayout) view, textView);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemBlockedBinding, "WidgetChatListAdapterIte…kedBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemBlockedBinding;
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemBlocked widgetChatListAdapterItemBlocked) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemBlocked.adapter;
    }

    private final CharSequence getBlockedText(Resources resources, Context context, int i) {
        return FormatUtils.c(resources, R.string.blocked_messages, new Object[]{StringResourceUtils.getI18nPluralString(context, R.plurals.blocked_messages_count, i, Integer.valueOf(i))}, (4 & 4) != 0 ? FormatUtils.d.j : null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        BlockedMessagesEntry blockedMessagesEntry = (BlockedMessagesEntry) data;
        final Message messageComponent1 = blockedMessagesEntry.getMessage();
        int iComponent2 = blockedMessagesEntry.getBlockedCount();
        TextView textView = this.binding.f2312b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemBlocked");
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(getBlockedText(resources, outline.x(this.itemView, "itemView", "itemView.context"), iComponent2));
        this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemBlocked.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChatListAdapterItemBlocked.access$getAdapter$p(WidgetChatListAdapterItemBlocked.this).getEventHandler().onMessageBlockedGroupClicked(messageComponent1);
            }
        });
    }
}
