package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.views.CheckedSetting;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics$Companion;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.contact_sync.WidgetContactSync$Companion;
import d0.o;
import d0.t.g0;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$configureContactSyncOptions$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsPrivacy$Model $model;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    public WidgetSettingsPrivacy$configureContactSyncOptions$2(WidgetSettingsPrivacy widgetSettingsPrivacy, WidgetSettingsPrivacy$Model widgetSettingsPrivacy$Model) {
        this.this$0 = widgetSettingsPrivacy;
        this.$model = widgetSettingsPrivacy$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingEnabled");
        boolean z2 = !checkedSetting.isChecked();
        if (this.$model.getContactSyncConnection() == null) {
            if (z2) {
                AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits$Location(Traits$Location$Page.USER_SETTINGS, null, null, null, null, 30, null));
                ContactSyncFlowAnalytics$Companion.trackStart$default(ContactSyncFlowAnalytics.Companion, false, g0.mapOf(o.to("location_page", Traits$Location$Page.USER_SETTINGS)), 1, null);
                WidgetContactSync$Companion.launch$default(WidgetContactSync.Companion, this.this$0.requireContext(), null, false, false, false, 30, null);
                return;
            }
            return;
        }
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingPhone");
        boolean zIsChecked = checkedSetting2.isChecked();
        CheckedSetting checkedSetting3 = WidgetSettingsPrivacy.access$getBinding$p(this.this$0).f2635b;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEmail");
        analyticsTracker.contactSyncToggled(z2, zIsChecked, checkedSetting3.isChecked());
        WidgetSettingsPrivacy.access$toggleContactSync(this.this$0, this.$model.getContactSyncConnection(), z2);
    }
}
