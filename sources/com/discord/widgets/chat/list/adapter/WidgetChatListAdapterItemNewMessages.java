package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemTextDividerBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.locale.LocaleManager;
import d0.z.d.Intrinsics3;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetChatListAdapterItemNewMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemNewMessages extends WidgetChatListItem {
    private final WidgetChatListAdapterItemTextDividerBinding binding;
    private final LocaleManager localeManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemNewMessages(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_text_divider, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        WidgetChatListAdapterItemTextDividerBinding widgetChatListAdapterItemTextDividerBindingA = WidgetChatListAdapterItemTextDividerBinding.a(this.itemView);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemTextDividerBindingA, "WidgetChatListAdapterIte…derBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemTextDividerBindingA;
        LocaleManager localeManager = new LocaleManager();
        this.localeManager = localeManager;
        View view = widgetChatListAdapterItemTextDividerBindingA.f2339b;
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        view.setBackgroundColor(ColorCompat.getColor(view2.getContext(), R.color.status_red_500));
        View view3 = widgetChatListAdapterItemTextDividerBindingA.c;
        View view4 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view4, "itemView");
        view3.setBackgroundColor(ColorCompat.getColor(view4.getContext(), R.color.status_red_500));
        TextView textView = widgetChatListAdapterItemTextDividerBindingA.d;
        View view5 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view5, "itemView");
        textView.setTextColor(ColorCompat.getColor(view5.getContext(), R.color.status_red_500));
        TextView textView2 = widgetChatListAdapterItemTextDividerBindingA.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.dividerText");
        View view6 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view6, "itemView");
        String string = view6.getContext().getString(R.string.new_messages_divider);
        Intrinsics3.checkNotNullExpressionValue(string, "itemView.context.getStri…ing.new_messages_divider)");
        TextView textView3 = widgetChatListAdapterItemTextDividerBindingA.d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.dividerText");
        Locale primaryLocale = localeManager.getPrimaryLocale(textView3.getContext());
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        String upperCase = string.toUpperCase(primaryLocale);
        Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        textView2.setText(upperCase);
    }
}
