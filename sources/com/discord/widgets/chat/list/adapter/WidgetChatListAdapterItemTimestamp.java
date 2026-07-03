package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemTextDividerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.TimestampEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemTimestamp.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemTimestamp extends WidgetChatListItem {
    private final WidgetChatListAdapterItemTextDividerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemTimestamp(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_text_divider, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        WidgetChatListAdapterItemTextDividerBinding widgetChatListAdapterItemTextDividerBindingM8410a = WidgetChatListAdapterItemTextDividerBinding.m8410a(this.itemView);
        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemTextDividerBindingM8410a, "WidgetChatListAdapterIte…derBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemTextDividerBindingM8410a;
        View view = widgetChatListAdapterItemTextDividerBindingM8410a.f16326b;
        C12238m.checkNotNullExpressionValue(view, "binding.dividerStrokeLeft");
        view.setBackgroundColor(ColorCompat.getThemedColor(view, C5419R.attr.colorTextMuted));
        View view2 = widgetChatListAdapterItemTextDividerBindingM8410a.f16327c;
        C12238m.checkNotNullExpressionValue(view2, "binding.dividerStrokeRight");
        view2.setBackgroundColor(ColorCompat.getThemedColor(view2, C5419R.attr.colorTextMuted));
        TextView textView = widgetChatListAdapterItemTextDividerBindingM8410a.f16328d;
        C12238m.checkNotNullExpressionValue(textView, "binding.dividerText");
        textView.setTextColor(ColorCompat.getThemedColor(textView, C5419R.attr.colorTextMuted));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.f16328d;
        C12238m.checkNotNullExpressionValue(textView, "binding.dividerText");
        textView.setText(TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, ((TimestampEntry) data).getTimestamp(), C1643a.m821I(this.binding.f16328d, "binding.dividerText", "binding.dividerText.context"), 0, 4, null));
    }
}
