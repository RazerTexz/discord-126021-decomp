package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemBlockedBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.widgets.chat.list.entries.BlockedMessagesEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemBlocked.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemBlocked extends WidgetChatListItem {
    private final WidgetChatListAdapterItemBlockedBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemBlocked(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_blocked, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_blocked);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.chat_list_adapter_item_blocked)));
        }
        WidgetChatListAdapterItemBlockedBinding widgetChatListAdapterItemBlockedBinding = new WidgetChatListAdapterItemBlockedBinding((RelativeLayout) view, textView);
        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemBlockedBinding, "WidgetChatListAdapterIte…kedBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemBlockedBinding;
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemBlocked widgetChatListAdapterItemBlocked) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemBlocked.adapter;
    }

    private final CharSequence getBlockedText(Resources resources, Context context, int i) {
        return C1107b.m211c(resources, C5419R.string.blocked_messages, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.blocked_messages_count, i, Integer.valueOf(i))}, (4 & 4) != 0 ? C1107b.d.f1493j : null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        BlockedMessagesEntry blockedMessagesEntry = (BlockedMessagesEntry) data;
        final Message messageComponent1 = blockedMessagesEntry.getMessage();
        int iComponent2 = blockedMessagesEntry.getBlockedCount();
        TextView textView = this.binding.f16168b;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemBlocked");
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        C12238m.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(getBlockedText(resources, C1643a.m885x(this.itemView, "itemView", "itemView.context"), iComponent2));
        this.binding.f16167a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemBlocked.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChatListAdapterItemBlocked.access$getAdapter$p(WidgetChatListAdapterItemBlocked.this).getEventHandler().onMessageBlockedGroupClicked(messageComponent1);
            }
        });
    }
}
