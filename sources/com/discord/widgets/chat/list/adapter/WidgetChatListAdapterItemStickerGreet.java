package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetChatListAdapterItemStickerGreetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerGreetEntry;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStickerGreet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStickerGreet extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStickerGreetBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStickerGreet(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_sticker_greet, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_sticker_greet;
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.chat_list_adapter_item_sticker_greet);
        if (stickerView != null) {
            i = C5419R.id.send_sticker_greet_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.send_sticker_greet_button);
            if (materialButton != null) {
                WidgetChatListAdapterItemStickerGreetBinding widgetChatListAdapterItemStickerGreetBinding = new WidgetChatListAdapterItemStickerGreetBinding((LinearLayout) view, stickerView, materialButton);
                C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemStickerGreetBinding, "WidgetChatListAdapterIte…eetBinding.bind(itemView)");
                this.binding = widgetChatListAdapterItemStickerGreetBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemStickerGreet widgetChatListAdapterItemStickerGreet) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemStickerGreet.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.binding.f16300b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StickerGreetEntry stickerGreetEntry = (StickerGreetEntry) data;
        final Sticker sticker = stickerGreetEntry.getSticker();
        final long channelId = stickerGreetEntry.getChannelId();
        String channelName = stickerGreetEntry.getChannelName();
        final int channelType = stickerGreetEntry.getChannelType();
        StickerView.m8613e(this.binding.f16300b, sticker, null, 2);
        this.binding.f16301c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStickerGreet.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemStickerGreet.access$getAdapter$p(WidgetChatListAdapterItemStickerGreet.this).getEventHandler().onSendGreetMessageClicked(channelId, channelType, sticker);
            }
        });
        MaterialButton materialButton = this.binding.f16301c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.sendStickerGreetButton");
        C1107b.m221m(materialButton, C5419R.string.wave_to, new Object[]{channelName}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }
}
