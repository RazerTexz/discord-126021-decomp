package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$configureThemeOption$1<T> implements Action1<Boolean> {
    public final /* synthetic */ String $settingTheme;
    public final /* synthetic */ WidgetSettingsAppearance this$0;

    public WidgetSettingsAppearance$configureThemeOption$1(WidgetSettingsAppearance widgetSettingsAppearance, String str) {
        this.this$0 = widgetSettingsAppearance;
        this.$settingTheme = str;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "checked");
        if (bool.booleanValue()) {
            WidgetSettingsAppearance.access$updateTheme(this.this$0, this.$settingTheme);
        }
    }
}
