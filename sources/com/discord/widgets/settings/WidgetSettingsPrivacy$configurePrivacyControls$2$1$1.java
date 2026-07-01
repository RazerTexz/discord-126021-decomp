package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.app.AlertDialog;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$configurePrivacyControls$2$1$1 implements View$OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;
    public final /* synthetic */ WidgetSettingsPrivacy$configurePrivacyControls$2$1 this$0;

    public WidgetSettingsPrivacy$configurePrivacyControls$2$1$1(WidgetSettingsPrivacy$configurePrivacyControls$2$1 widgetSettingsPrivacy$configurePrivacyControls$2$1, AlertDialog alertDialog) {
        this.this$0 = widgetSettingsPrivacy$configurePrivacyControls$2$1;
        this.$dialog = alertDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$dialog.dismiss();
        CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(this.this$0.this$0.this$0).v;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
        checkedSetting.setChecked(true);
        CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(this.this$0.this$0.this$0).v;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
        checkedSetting2.setEnabled(true);
    }
}
