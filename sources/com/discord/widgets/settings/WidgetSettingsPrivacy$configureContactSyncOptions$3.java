package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$configureContactSyncOptions$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    public WidgetSettingsPrivacy$configureContactSyncOptions$3(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        this.this$0 = widgetSettingsPrivacy;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingPhone");
        boolean z2 = !checkedSetting.isChecked();
        CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(this.this$0).f2635b;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingEmail");
        boolean zIsChecked = checkedSetting2.isChecked();
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        CheckedSetting checkedSetting3 = WidgetSettingsPrivacy.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEnabled");
        boolean zIsChecked2 = checkedSetting3.isChecked();
        CheckedSetting checkedSetting4 = WidgetSettingsPrivacy.access$getBinding$p(this.this$0).f2635b;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingEmail");
        analyticsTracker.contactSyncToggled(zIsChecked2, z2, checkedSetting4.isChecked());
        WidgetSettingsPrivacy.access$updateFriendDiscoveryFlags(this.this$0, z2, zIsChecked);
    }
}
