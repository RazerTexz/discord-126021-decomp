package com.discord.widgets.chat.list.adapter;

import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemMentionFooterBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMentionFooter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMentionFooter extends WidgetChatListItem {
    private final WidgetChatListAdapterItemMentionFooterBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMentionFooter(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_mention_footer, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_item_mention_footer_divider;
        View viewFindViewById = view.findViewById(C5419R.id.chat_list_item_mention_footer_divider);
        if (viewFindViewById != null) {
            i = C5419R.id.chat_list_item_mention_footer_hand;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.chat_list_item_mention_footer_hand);
            if (imageView != null) {
                i = C5419R.id.chat_list_item_message_header_channel;
                TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_item_message_header_channel);
                if (textView != null) {
                    i = C5419R.id.tile;
                    View viewFindViewById2 = view.findViewById(C5419R.id.tile);
                    if (viewFindViewById2 != null) {
                        WidgetChatListAdapterItemMentionFooterBinding widgetChatListAdapterItemMentionFooterBinding = new WidgetChatListAdapterItemMentionFooterBinding((LinearLayout) view, viewFindViewById, imageView, textView, viewFindViewById2);
                        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemMentionFooterBinding, "WidgetChatListAdapterIte…terBinding.bind(itemView)");
                        this.binding = widgetChatListAdapterItemMentionFooterBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    private final void tileBackgroundBitmapDrawable(WidgetChatListAdapterItemMentionFooterBinding widgetChatListAdapterItemMentionFooterBinding) {
        View view = widgetChatListAdapterItemMentionFooterBinding.f16255c;
        C12238m.checkNotNullExpressionValue(view, "tile");
        Drawable background = view.getBackground();
        Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
        bitmapDrawable.mutate();
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        bitmapDrawable.setTileModeXY(tileMode, tileMode);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        boolean z2 = ((WidgetChatListAdapter) this.adapter).getData().getList().size() == 1;
        View view = this.binding.f16254b;
        C12238m.checkNotNullExpressionValue(view, "binding.chatListItemMentionFooterDivider");
        view.setVisibility(z2 ^ true ? 0 : 8);
        tileBackgroundBitmapDrawable(this.binding);
    }
}
