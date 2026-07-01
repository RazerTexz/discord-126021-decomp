package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccessibility$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsAccessibility this$0;

    public WidgetSettingsAccessibility$configureUI$1(WidgetSettingsAccessibility widgetSettingsAccessibility) {
        this.this$0 = widgetSettingsAccessibility;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        CheckedSetting checkedSetting = WidgetSettingsAccessibility.access$getBinding$p(this.this$0).f2589b;
        CheckedSetting checkedSetting2 = WidgetSettingsAccessibility.access$getBinding$p(this.this$0).f2589b;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
        checkedSetting.g(!checkedSetting2.isChecked(), true);
    }
}
