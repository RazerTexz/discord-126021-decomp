package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguage$onViewBoundOrOnResume$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsLanguage this$0;

    public WidgetSettingsLanguage$onViewBoundOrOnResume$3(WidgetSettingsLanguage widgetSettingsLanguage) {
        this.this$0 = widgetSettingsLanguage;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsLanguageSelect.Companion.show(this.this$0);
    }
}
