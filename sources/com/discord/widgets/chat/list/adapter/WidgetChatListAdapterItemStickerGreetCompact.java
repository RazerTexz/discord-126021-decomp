package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetChatListAdapterItemStickerGreetCompactBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerGreetCompactEntry;
import d0.z.d.Intrinsics3;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStickerGreetCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStickerGreetCompact extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStickerGreetCompactBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStickerGreetCompact(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_sticker_greet_compact, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_sticker_greet;
        StickerView stickerView = (StickerView) view.findViewById(R.id.chat_list_adapter_item_sticker_greet);
        if (stickerView != null) {
            i = R.id.chat_list_adapter_item_sticker_greet_text;
            TextView textView = (TextView) view.findViewById(R.id.chat_list_adapter_item_sticker_greet_text);
            if (textView != null) {
                i = R.id.send_sticker_greet_button;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.send_sticker_greet_button);
                if (linearLayout != null) {
                    WidgetChatListAdapterItemStickerGreetCompactBinding widgetChatListAdapterItemStickerGreetCompactBinding = new WidgetChatListAdapterItemStickerGreetCompactBinding((ConstraintLayout) view, stickerView, textView, linearLayout);
                    Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemStickerGreetCompactBinding, "WidgetChatListAdapterIte…actBinding.bind(itemView)");
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
        return this.binding.f2336b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StickerGreetCompactEntry stickerGreetCompactEntry = (StickerGreetCompactEntry) data;
        final Sticker sticker = stickerGreetCompactEntry.getSticker();
        final long channelId = stickerGreetCompactEntry.getChannelId();
        String channelName = stickerGreetCompactEntry.getChannelName();
        final int channelType = stickerGreetCompactEntry.getChannelType();
        StickerView.e(this.binding.f2336b, sticker, null, 2);
        this.binding.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStickerGreetCompact.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemStickerGreetCompact.access$getAdapter$p(WidgetChatListAdapterItemStickerGreetCompact.this).getEventHandler().onSendGreetMessageClicked(channelId, channelType, sticker);
            }
        });
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemStickerGreetText");
        FormatUtils.m(textView, R.string.wave_to, new Object[]{channelName}, (4 & 4) != 0 ? FormatUtils.g.j : null);
    }
}
