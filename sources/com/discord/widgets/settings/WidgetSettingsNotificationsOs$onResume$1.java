package com.discord.widgets.settings;

import com.discord.utilities.fcm.NotificationClient$SettingsV2;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsNotificationsOs$onResume$1 extends o implements Function1<NotificationClient$SettingsV2, Unit> {
    public final /* synthetic */ WidgetSettingsNotificationsOs this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsNotificationsOs$onResume$1(WidgetSettingsNotificationsOs widgetSettingsNotificationsOs) {
        super(1);
        this.this$0 = widgetSettingsNotificationsOs;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NotificationClient$SettingsV2 notificationClient$SettingsV2) {
        invoke2(notificationClient$SettingsV2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(NotificationClient$SettingsV2 notificationClient$SettingsV2) {
        m.checkNotNullParameter(notificationClient$SettingsV2, "settings");
        CheckedSetting checkedSetting = WidgetSettingsNotificationsOs.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsNotificationSwitch");
        checkedSetting.setChecked(notificationClient$SettingsV2.isEnabled());
        CheckedSetting checkedSetting2 = WidgetSettingsNotificationsOs.access$getBinding$p(this.this$0).f2631b;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsInappNotifsSwitch");
        checkedSetting2.setChecked(notificationClient$SettingsV2.isEnabledInApp());
    }
}
