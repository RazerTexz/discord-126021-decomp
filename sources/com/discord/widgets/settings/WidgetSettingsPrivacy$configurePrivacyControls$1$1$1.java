package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.app.AlertDialog;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$configurePrivacyControls$1$1$1 implements View$OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;
    public final /* synthetic */ WidgetSettingsPrivacy$configurePrivacyControls$1$1 this$0;

    public WidgetSettingsPrivacy$configurePrivacyControls$1$1$1(WidgetSettingsPrivacy$configurePrivacyControls$1$1 widgetSettingsPrivacy$configurePrivacyControls$1$1, AlertDialog alertDialog) {
        this.this$0 = widgetSettingsPrivacy$configurePrivacyControls$1$1;
        this.$dialog = alertDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$dialog.dismiss();
        CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(this.this$0.this$0.this$0).f2639z;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
        checkedSetting.setChecked(true);
        CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(this.this$0.this$0.this$0).f2639z;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyStatistics");
        checkedSetting2.setEnabled(true);
    }
}
