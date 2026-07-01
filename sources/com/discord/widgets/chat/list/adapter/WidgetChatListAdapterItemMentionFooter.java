package com.discord.widgets.chat.list.adapter;

import android.graphics.Shader$TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetChatListAdapterItemMentionFooterBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMentionFooter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMentionFooter extends WidgetChatListItem {
    private final WidgetChatListAdapterItemMentionFooterBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMentionFooter(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_mention_footer, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.chat_list_item_mention_footer_divider;
        View viewFindViewById = view.findViewById(R$id.chat_list_item_mention_footer_divider);
        if (viewFindViewById != null) {
            i = R$id.chat_list_item_mention_footer_hand;
            ImageView imageView = (ImageView) view.findViewById(R$id.chat_list_item_mention_footer_hand);
            if (imageView != null) {
                i = R$id.chat_list_item_message_header_channel;
                TextView textView = (TextView) view.findViewById(R$id.chat_list_item_message_header_channel);
                if (textView != null) {
                    i = R$id.tile;
                    View viewFindViewById2 = view.findViewById(R$id.tile);
                    if (viewFindViewById2 != null) {
                        WidgetChatListAdapterItemMentionFooterBinding widgetChatListAdapterItemMentionFooterBinding = new WidgetChatListAdapterItemMentionFooterBinding((LinearLayout) view, viewFindViewById, imageView, textView, viewFindViewById2);
                        m.checkNotNullExpressionValue(widgetChatListAdapterItemMentionFooterBinding, "WidgetChatListAdapterIte…terBinding.bind(itemView)");
                        this.binding = widgetChatListAdapterItemMentionFooterBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    private final void tileBackgroundBitmapDrawable(WidgetChatListAdapterItemMentionFooterBinding widgetChatListAdapterItemMentionFooterBinding) {
        View view = widgetChatListAdapterItemMentionFooterBinding.c;
        m.checkNotNullExpressionValue(view, "tile");
        Drawable background = view.getBackground();
        Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
        bitmapDrawable.mutate();
        Shader$TileMode shader$TileMode = Shader$TileMode.REPEAT;
        bitmapDrawable.setTileModeXY(shader$TileMode, shader$TileMode);
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
        boolean z2 = ((WidgetChatListAdapter) this.adapter).getData().getList().size() == 1;
        View view = this.binding.f2326b;
        m.checkNotNullExpressionValue(view, "binding.chatListItemMentionFooterDivider");
        view.setVisibility(z2 ^ true ? 0 : 8);
        tileBackgroundBitmapDrawable(this.binding);
    }
}
