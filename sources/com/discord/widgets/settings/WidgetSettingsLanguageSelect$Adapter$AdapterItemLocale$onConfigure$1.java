package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsLanguageSelect$Model$Item $data;
    public final /* synthetic */ WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale this$0;

    public WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale$onConfigure$1(WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale widgetSettingsLanguageSelect$Adapter$AdapterItemLocale, WidgetSettingsLanguageSelect$Model$Item widgetSettingsLanguageSelect$Model$Item) {
        this.this$0 = widgetSettingsLanguageSelect$Adapter$AdapterItemLocale;
        this.$data = widgetSettingsLanguageSelect$Model$Item;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsLanguageSelect.access$onLocaleSelected(WidgetSettingsLanguageSelect$Adapter.access$getDialog$p(WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale.access$getAdapter$p(this.this$0)), this.$data.getLocale());
    }
}
