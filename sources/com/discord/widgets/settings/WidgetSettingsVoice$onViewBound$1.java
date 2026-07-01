package com.discord.widgets.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$onViewBound$1<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetSettingsVoice this$0;

    public WidgetSettingsVoice$onViewBound$1(WidgetSettingsVoice widgetSettingsVoice) {
        this.this$0 = widgetSettingsVoice;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        if (!bool.booleanValue() || WidgetSettingsVoice$Companion.access$hasOverlayPermission(WidgetSettingsVoice.Companion, this.this$0.requireContext())) {
            StoreUserSettings userSettings = StoreStream.Companion.getUserSettings();
            m.checkNotNullExpressionValue(bool, "isChecked");
            userSettings.setIsMobileOverlayEnabled(bool.booleanValue());
            WidgetSettingsVoice widgetSettingsVoice = this.this$0;
            CheckedSetting checkedSetting = WidgetSettingsVoice.access$getBinding$p(widgetSettingsVoice).u;
            m.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOverlayToggle");
            Context context = checkedSetting.getContext();
            m.checkNotNullExpressionValue(context, "binding.settingsVoiceOverlayToggle.context");
            WidgetSettingsVoice.access$onOverlayToggled(widgetSettingsVoice, context);
            return;
        }
        CheckedSetting checkedSetting2 = WidgetSettingsVoice.access$getBinding$p(this.this$0).u;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOverlayToggle");
        checkedSetting2.setChecked(false);
        AnalyticsTracker.INSTANCE.permissionsRequested("overlay");
        WidgetSettingsVoice widgetSettingsVoice2 = this.this$0;
        StringBuilder sbU = a.U("package:");
        CheckedSetting checkedSetting3 = WidgetSettingsVoice.access$getBinding$p(this.this$0).u;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceOverlayToggle");
        Context context2 = checkedSetting3.getContext();
        m.checkNotNullExpressionValue(context2, "binding.settingsVoiceOverlayToggle.context");
        sbU.append(context2.getPackageName());
        widgetSettingsVoice2.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(sbU.toString())), 2552);
    }
}
