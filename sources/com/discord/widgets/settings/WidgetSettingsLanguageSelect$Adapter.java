package com.discord.widgets.settings;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguageSelect$Adapter extends MGRecyclerAdapterSimple<WidgetSettingsLanguageSelect$Model$Item> {
    private final WidgetSettingsLanguageSelect dialog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsLanguageSelect$Adapter(RecyclerView recyclerView, WidgetSettingsLanguageSelect widgetSettingsLanguageSelect) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(widgetSettingsLanguageSelect, "dialog");
        this.dialog = widgetSettingsLanguageSelect;
    }

    public static final /* synthetic */ WidgetSettingsLanguageSelect access$getDialog$p(WidgetSettingsLanguageSelect$Adapter widgetSettingsLanguageSelect$Adapter) {
        return widgetSettingsLanguageSelect$Adapter.dialog;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        return new WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale(R$layout.widget_settings_language_select_item, this);
    }
}
