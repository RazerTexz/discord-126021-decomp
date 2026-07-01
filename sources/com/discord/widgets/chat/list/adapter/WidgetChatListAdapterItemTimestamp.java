package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.TextView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemTextDividerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.TimestampEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: WidgetChatListAdapterItemTimestamp.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemTimestamp extends WidgetChatListItem {
    private final WidgetChatListAdapterItemTextDividerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemTimestamp(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_text_divider, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        WidgetChatListAdapterItemTextDividerBinding widgetChatListAdapterItemTextDividerBindingA = WidgetChatListAdapterItemTextDividerBinding.a(this.itemView);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemTextDividerBindingA, "WidgetChatListAdapterIte…derBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemTextDividerBindingA;
        View view = widgetChatListAdapterItemTextDividerBindingA.f2339b;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.dividerStrokeLeft");
        view.setBackgroundColor(ColorCompat.getThemedColor(view, R.attr.colorTextMuted));
        View view2 = widgetChatListAdapterItemTextDividerBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.dividerStrokeRight");
        view2.setBackgroundColor(ColorCompat.getThemedColor(view2, R.attr.colorTextMuted));
        TextView textView = widgetChatListAdapterItemTextDividerBindingA.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.dividerText");
        textView.setTextColor(ColorCompat.getThemedColor(textView, R.attr.colorTextMuted));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.dividerText");
        textView.setText(TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, ((TimestampEntry) data).getTimestamp(), outline.I(this.binding.d, "binding.dividerText", "binding.dividerText.context"), 0, 4, null));
    }
}
