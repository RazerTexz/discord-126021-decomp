package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppActivity;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccessibility$onViewBoundOrOnResume$3<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetSettingsAccessibility this$0;

    public WidgetSettingsAccessibility$onViewBoundOrOnResume$3(WidgetSettingsAccessibility widgetSettingsAccessibility) {
        this.this$0 = widgetSettingsAccessibility;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreUserSettings userSettings = StoreStream.Companion.getUserSettings();
        AppActivity appActivity = this.this$0.getAppActivity();
        m.checkNotNullExpressionValue(bool, "checked");
        userSettings.setIsAnimatedEmojisEnabled(appActivity, bool.booleanValue());
    }
}
