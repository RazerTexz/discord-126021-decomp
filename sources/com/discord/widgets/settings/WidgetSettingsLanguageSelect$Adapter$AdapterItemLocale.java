package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsLanguageSelectItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale extends MGRecyclerViewHolder<WidgetSettingsLanguageSelect$Adapter, WidgetSettingsLanguageSelect$Model$Item> {
    private final WidgetSettingsLanguageSelectItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale(@LayoutRes int i, WidgetSettingsLanguageSelect$Adapter widgetSettingsLanguageSelect$Adapter) {
        super(i, widgetSettingsLanguageSelect$Adapter);
        m.checkNotNullParameter(widgetSettingsLanguageSelect$Adapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.flag_icon;
        ImageView imageView = (ImageView) view.findViewById(R$id.flag_icon);
        if (imageView != null) {
            i2 = R$id.flag_icon_barrier;
            Barrier barrier = (Barrier) view.findViewById(R$id.flag_icon_barrier);
            if (barrier != null) {
                i2 = R$id.settings_language_select_item_name;
                TextView textView = (TextView) view.findViewById(R$id.settings_language_select_item_name);
                if (textView != null) {
                    i2 = R$id.settings_language_select_item_name_localized;
                    TextView textView2 = (TextView) view.findViewById(R$id.settings_language_select_item_name_localized);
                    if (textView2 != null) {
                        WidgetSettingsLanguageSelectItemBinding widgetSettingsLanguageSelectItemBinding = new WidgetSettingsLanguageSelectItemBinding((ConstraintLayout) view, imageView, barrier, textView, textView2);
                        m.checkNotNullExpressionValue(widgetSettingsLanguageSelectItemBinding, "WidgetSettingsLanguageSe…temBinding.bind(itemView)");
                        this.binding = widgetSettingsLanguageSelectItemBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetSettingsLanguageSelect$Adapter access$getAdapter$p(WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale widgetSettingsLanguageSelect$Adapter$AdapterItemLocale) {
        return (WidgetSettingsLanguageSelect$Adapter) widgetSettingsLanguageSelect$Adapter$AdapterItemLocale.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetSettingsLanguageSelect$Model$Item widgetSettingsLanguageSelect$Model$Item) {
        onConfigure2(i, widgetSettingsLanguageSelect$Model$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetSettingsLanguageSelect$Model$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.binding.a.setOnClickListener(new WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale$onConfigure$1(this, data));
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.settingsLanguageSelectItemName");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        WidgetSettingsLanguage$Companion widgetSettingsLanguage$Companion = WidgetSettingsLanguage.Companion;
        textView.setText(context.getString(widgetSettingsLanguage$Companion.getLocaleResId(data.getLocale())));
        TextView textView2 = this.binding.d;
        m.checkNotNullExpressionValue(textView2, "binding.settingsLanguageSelectItemNameLocalized");
        textView2.setText(widgetSettingsLanguage$Companion.getAsStringInLocale(data.getLocale()));
        this.binding.f2629b.setImageResource(widgetSettingsLanguage$Companion.getLocaleFlagResId(data.getLocale()));
    }
}
