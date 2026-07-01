package com.discord.widgets.chat.list.adapter;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.databinding.WidgetChatListAdapterItemEphemeralMessageBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EphemeralMessageEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEphemeralMessage extends WidgetChatListItem {
    private final WidgetChatListAdapterItemEphemeralMessageBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEphemeralMessage(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_ephemeral_message, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view.findViewById(R$id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = R$id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view.findViewById(R$id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                i = R$id.chat_list_adapter_item_icon_help;
                ImageView imageView = (ImageView) view.findViewById(R$id.chat_list_adapter_item_icon_help);
                if (imageView != null) {
                    i = R$id.chat_list_adapter_item_text_dismiss;
                    TextView textView = (TextView) view.findViewById(R$id.chat_list_adapter_item_text_dismiss);
                    if (textView != null) {
                        i = R$id.chat_list_adapter_item_visibility_icon;
                        ImageView imageView2 = (ImageView) view.findViewById(R$id.chat_list_adapter_item_visibility_icon);
                        if (imageView2 != null) {
                            i = 2131365922;
                            Guideline guideline = (Guideline) view.findViewById(2131365922);
                            if (guideline != null) {
                                WidgetChatListAdapterItemEphemeralMessageBinding widgetChatListAdapterItemEphemeralMessageBinding = new WidgetChatListAdapterItemEphemeralMessageBinding((ConstraintLayout) view, viewFindViewById, viewFindViewById2, imageView, textView, imageView2, guideline);
                                m.checkNotNullExpressionValue(widgetChatListAdapterItemEphemeralMessageBinding, "WidgetChatListAdapterIte…ageBinding.bind(itemView)");
                                this.binding = widgetChatListAdapterItemEphemeralMessageBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemEphemeralMessage widgetChatListAdapterItemEphemeralMessage) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemEphemeralMessage.adapter;
    }

    public static final /* synthetic */ WidgetChatListAdapterItemEphemeralMessageBinding access$getBinding$p(WidgetChatListAdapterItemEphemeralMessage widgetChatListAdapterItemEphemeralMessage) {
        return widgetChatListAdapterItemEphemeralMessage.binding;
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
        Message message = ((EphemeralMessageEntry) data).getMessage();
        View view = this.binding.f2318b;
        m.checkNotNullExpressionValue(view, "binding.chatListAdapterItemGutterBg");
        View view2 = this.binding.c;
        m.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemHighlightedBg");
        configureCellHighlight(message, view2, view);
        this.binding.d.setOnClickListener(new WidgetChatListAdapterItemEphemeralMessage$onConfigure$1(this));
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextDismiss");
        String quantityString = textView.getResources().getQuantityString(R$plurals.only_you_can_see_and_delete_these_count, 1);
        m.checkNotNullExpressionValue(quantityString, "itemDismiss.resources.ge…nd_delete_these_count, 1)");
        String quantityString2 = textView.getResources().getQuantityString(R$plurals.only_you_can_see_and_delete_these_countMessages, 1);
        m.checkNotNullExpressionValue(quantityString2, "itemDismiss.resources.ge…e_these_countMessages, 1)");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(b.d(textView, 2131893516, new Object[]{quantityString, quantityString2}, new WidgetChatListAdapterItemEphemeralMessage$onConfigure$2(this, message)));
    }
}
