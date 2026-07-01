package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetChatListAdapterItemStickerGreetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerGreetEntry;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStickerGreet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStickerGreet extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStickerGreetBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStickerGreet(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_sticker_greet, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.chat_list_adapter_item_sticker_greet;
        StickerView stickerView = (StickerView) view.findViewById(R$id.chat_list_adapter_item_sticker_greet);
        if (stickerView != null) {
            i = R$id.send_sticker_greet_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.send_sticker_greet_button);
            if (materialButton != null) {
                WidgetChatListAdapterItemStickerGreetBinding widgetChatListAdapterItemStickerGreetBinding = new WidgetChatListAdapterItemStickerGreetBinding((LinearLayout) view, stickerView, materialButton);
                m.checkNotNullExpressionValue(widgetChatListAdapterItemStickerGreetBinding, "WidgetChatListAdapterIte…eetBinding.bind(itemView)");
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
        return this.binding.f2335b.getCom.discord.utilities.analytics.Traits$Payment$Type.SUBSCRIPTION java.lang.String();
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
        StickerGreetEntry stickerGreetEntry = (StickerGreetEntry) data;
        Sticker sticker = stickerGreetEntry.getSticker();
        long channelId = stickerGreetEntry.getChannelId();
        String channelName = stickerGreetEntry.getChannelName();
        int channelType = stickerGreetEntry.getChannelType();
        StickerView.e(this.binding.f2335b, sticker, null, 2);
        this.binding.c.setOnClickListener(new WidgetChatListAdapterItemStickerGreet$onConfigure$1(this, channelId, channelType, sticker));
        MaterialButton materialButton = this.binding.c;
        m.checkNotNullExpressionValue(materialButton, "binding.sendStickerGreetButton");
        b.n(materialButton, 2131897203, new Object[]{channelName}, null, 4);
    }
}
