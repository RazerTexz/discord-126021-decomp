package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetChatListAdapterItemStickerGreetCompactBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerGreetCompactEntry;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStickerGreetCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStickerGreetCompact extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStickerGreetCompactBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStickerGreetCompact(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_sticker_greet_compact, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_sticker_greet;
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.chat_list_adapter_item_sticker_greet);
        if (stickerView != null) {
            i = C5419R.id.chat_list_adapter_item_sticker_greet_text;
            TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_sticker_greet_text);
            if (textView != null) {
                i = C5419R.id.send_sticker_greet_button;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.send_sticker_greet_button);
                if (linearLayout != null) {
                    WidgetChatListAdapterItemStickerGreetCompactBinding widgetChatListAdapterItemStickerGreetCompactBinding = new WidgetChatListAdapterItemStickerGreetCompactBinding((ConstraintLayout) view, stickerView, textView, linearLayout);
                    C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemStickerGreetCompactBinding, "WidgetChatListAdapterIte…actBinding.bind(itemView)");
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
        return this.binding.f16303b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StickerGreetCompactEntry stickerGreetCompactEntry = (StickerGreetCompactEntry) data;
        final Sticker sticker = stickerGreetCompactEntry.getSticker();
        final long channelId = stickerGreetCompactEntry.getChannelId();
        String channelName = stickerGreetCompactEntry.getChannelName();
        final int channelType = stickerGreetCompactEntry.getChannelType();
        StickerView.m8613e(this.binding.f16303b, sticker, null, 2);
        this.binding.f16305d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStickerGreetCompact.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemStickerGreetCompact.access$getAdapter$p(WidgetChatListAdapterItemStickerGreetCompact.this).getEventHandler().onSendGreetMessageClicked(channelId, channelType, sticker);
            }
        });
        TextView textView = this.binding.f16304c;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemStickerGreetText");
        C1107b.m221m(textView, C5419R.string.wave_to, new Object[]{channelName}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }
}
