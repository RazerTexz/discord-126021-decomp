package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.navigation.SystemSettingNavigators;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsNotificationsOs$onViewCreated$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsNotificationsOs this$0;

    public WidgetSettingsNotificationsOs$onViewCreated$3(WidgetSettingsNotificationsOs widgetSettingsNotificationsOs) {
        this.this$0 = widgetSettingsNotificationsOs;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SystemSettingNavigators systemSettingNavigators = SystemSettingNavigators.INSTANCE;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        systemSettingNavigators.openSystemNotification(context);
        this.this$0.dismiss();
    }
}
