package com.discord.widgets.settings;

import android.widget.LinearLayout;
import com.discord.utilities.fcm.NotificationClient$SettingsV2;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsNotifications$onViewBoundOrOnResume$1 extends o implements Function1<NotificationClient$SettingsV2, Unit> {
    public final /* synthetic */ WidgetSettingsNotifications this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsNotifications$onViewBoundOrOnResume$1(WidgetSettingsNotifications widgetSettingsNotifications) {
        super(1);
        this.this$0 = widgetSettingsNotifications;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NotificationClient$SettingsV2 notificationClient$SettingsV2) {
        invoke2(notificationClient$SettingsV2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(NotificationClient$SettingsV2 notificationClient$SettingsV2) {
        m.checkNotNullParameter(notificationClient$SettingsV2, "settings");
        LinearLayout linearLayout = WidgetSettingsNotifications.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsNotificationsWrap");
        linearLayout.setVisibility(notificationClient$SettingsV2.isEnabled() ? 0 : 8);
        CheckedSetting checkedSetting = WidgetSettingsNotifications.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsNotificationsEnabled");
        checkedSetting.setChecked(notificationClient$SettingsV2.isEnabled());
        CheckedSetting checkedSetting2 = WidgetSettingsNotifications.access$getBinding$p(this.this$0).f2632b;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsInappNotifsSwitch");
        checkedSetting2.setChecked(notificationClient$SettingsV2.isEnabledInApp());
        CheckedSetting checkedSetting3 = WidgetSettingsNotifications.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsNotificationsBlink");
        checkedSetting3.setChecked(notificationClient$SettingsV2.isDisableBlink());
        CheckedSetting checkedSetting4 = WidgetSettingsNotifications.access$getBinding$p(this.this$0).f;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsNotificationsVibrations");
        checkedSetting4.setChecked(notificationClient$SettingsV2.isDisableVibrate());
        CheckedSetting checkedSetting5 = WidgetSettingsNotifications.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(checkedSetting5, "binding.settingsNotificationsMuteAll");
        checkedSetting5.setChecked(notificationClient$SettingsV2.isDisableSound());
    }
}
