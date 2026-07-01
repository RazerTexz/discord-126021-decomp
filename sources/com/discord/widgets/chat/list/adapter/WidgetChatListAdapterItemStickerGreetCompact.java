package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetChatListAdapterItemStickerGreetCompactBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerGreetCompactEntry;
import d0.z.d.m;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStickerGreetCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStickerGreetCompact extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStickerGreetCompactBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStickerGreetCompact(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_sticker_greet_compact, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.chat_list_adapter_item_sticker_greet;
        StickerView stickerView = (StickerView) view.findViewById(R$id.chat_list_adapter_item_sticker_greet);
        if (stickerView != null) {
            i = R$id.chat_list_adapter_item_sticker_greet_text;
            TextView textView = (TextView) view.findViewById(R$id.chat_list_adapter_item_sticker_greet_text);
            if (textView != null) {
                i = R$id.send_sticker_greet_button;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.send_sticker_greet_button);
                if (linearLayout != null) {
                    WidgetChatListAdapterItemStickerGreetCompactBinding widgetChatListAdapterItemStickerGreetCompactBinding = new WidgetChatListAdapterItemStickerGreetCompactBinding((ConstraintLayout) view, stickerView, textView, linearLayout);
                    m.checkNotNullExpressionValue(widgetChatListAdapterItemStickerGreetCompactBinding, "WidgetChatListAdapterIte…actBinding.bind(itemView)");
                    this.binding = widgetChatListAdapterItemStickerGreetCompactBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemStickerGreetCompact widgetChatListAdapterItemStickerGreetCompact) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemStickerGreetCompact.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.binding.f2336b.getCom.discord.utilities.analytics.Traits$Payment$Type.SUBSCRIPTION java.lang.String();
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
        StickerGreetCompactEntry stickerGreetCompactEntry = (StickerGreetCompactEntry) data;
        Sticker sticker = stickerGreetCompactEntry.getSticker();
        long channelId = stickerGreetCompactEntry.getChannelId();
        String channelName = stickerGreetCompactEntry.getChannelName();
        int channelType = stickerGreetCompactEntry.getChannelType();
        StickerView.e(this.binding.f2336b, sticker, null, 2);
        this.binding.d.setOnClickListener(new WidgetChatListAdapterItemStickerGreetCompact$onConfigure$1(this, channelId, channelType, sticker));
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemStickerGreetText");
        b.n(textView, 2131897203, new Object[]{channelName}, null, 4);
    }
}
