package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetChatListAdapterItemStickerGreetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerGreetEntry;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStickerGreet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStickerGreet extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStickerGreetBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStickerGreet(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_sticker_greet, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_sticker_greet;
        StickerView stickerView = (StickerView) view.findViewById(R.id.chat_list_adapter_item_sticker_greet);
        if (stickerView != null) {
            i = R.id.send_sticker_greet_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.send_sticker_greet_button);
            if (materialButton != null) {
                WidgetChatListAdapterItemStickerGreetBinding widgetChatListAdapterItemStickerGreetBinding = new WidgetChatListAdapterItemStickerGreetBinding((LinearLayout) view, stickerView, materialButton);
                Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemStickerGreetBinding, "WidgetChatListAdapterIte…eetBinding.bind(itemView)");
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
        return this.binding.f2335b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StickerGreetEntry stickerGreetEntry = (StickerGreetEntry) data;
        final Sticker sticker = stickerGreetEntry.getSticker();
        final long channelId = stickerGreetEntry.getChannelId();
        String channelName = stickerGreetEntry.getChannelName();
        final int channelType = stickerGreetEntry.getChannelType();
        StickerView.e(this.binding.f2335b, sticker, null, 2);
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStickerGreet.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemStickerGreet.access$getAdapter$p(WidgetChatListAdapterItemStickerGreet.this).getEventHandler().onSendGreetMessageClicked(channelId, channelType, sticker);
            }
        });
        MaterialButton materialButton = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.sendStickerGreetButton");
        FormatUtils.m(materialButton, R.string.wave_to, new Object[]{channelName}, (4 & 4) != 0 ? FormatUtils.g.j : null);
    }
}
