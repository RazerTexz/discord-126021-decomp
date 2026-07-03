package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemTextDividerBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.locale.LocaleManager;
import java.util.Locale;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemNewMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemNewMessages extends WidgetChatListItem {
    private final WidgetChatListAdapterItemTextDividerBinding binding;
    private final LocaleManager localeManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemNewMessages(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_text_divider, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        WidgetChatListAdapterItemTextDividerBinding widgetChatListAdapterItemTextDividerBindingM8410a = WidgetChatListAdapterItemTextDividerBinding.m8410a(this.itemView);
        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemTextDividerBindingM8410a, "WidgetChatListAdapterIte…derBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemTextDividerBindingM8410a;
        LocaleManager localeManager = new LocaleManager();
        this.localeManager = localeManager;
        View view = widgetChatListAdapterItemTextDividerBindingM8410a.f16326b;
        View view2 = this.itemView;
        C12238m.checkNotNullExpressionValue(view2, "itemView");
        view.setBackgroundColor(ColorCompat.getColor(view2.getContext(), C5419R.color.status_red_500));
        View view3 = widgetChatListAdapterItemTextDividerBindingM8410a.f16327c;
        View view4 = this.itemView;
        C12238m.checkNotNullExpressionValue(view4, "itemView");
        view3.setBackgroundColor(ColorCompat.getColor(view4.getContext(), C5419R.color.status_red_500));
        TextView textView = widgetChatListAdapterItemTextDividerBindingM8410a.f16328d;
        View view5 = this.itemView;
        C12238m.checkNotNullExpressionValue(view5, "itemView");
        textView.setTextColor(ColorCompat.getColor(view5.getContext(), C5419R.color.status_red_500));
        TextView textView2 = widgetChatListAdapterItemTextDividerBindingM8410a.f16328d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.dividerText");
        View view6 = this.itemView;
        C12238m.checkNotNullExpressionValue(view6, "itemView");
        String string = view6.getContext().getString(C5419R.string.new_messages_divider);
        C12238m.checkNotNullExpressionValue(string, "itemView.context.getStri…ing.new_messages_divider)");
        TextView textView3 = widgetChatListAdapterItemTextDividerBindingM8410a.f16328d;
        C12238m.checkNotNullExpressionValue(textView3, "binding.dividerText");
        Locale primaryLocale = localeManager.getPrimaryLocale(textView3.getContext());
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        String upperCase = string.toUpperCase(primaryLocale);
        C12238m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        textView2.setText(upperCase);
    }
}
