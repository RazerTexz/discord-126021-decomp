package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppActivity;
import com.discord.stores.StoreUserSettings;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsBehavior.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$2<T> implements Action1<Boolean> {
    public final /* synthetic */ StoreUserSettings $userSettings$inlined;
    public final /* synthetic */ WidgetSettingsBehavior this$0;

    public WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$2(WidgetSettingsBehavior widgetSettingsBehavior, StoreUserSettings storeUserSettings) {
        this.this$0 = widgetSettingsBehavior;
        this.$userSettings$inlined = storeUserSettings;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreUserSettings storeUserSettings = this.$userSettings$inlined;
        AppActivity appActivity = this.this$0.getAppActivity();
        m.checkNotNullExpressionValue(bool, "isChecked");
        storeUserSettings.setIsDeveloperMode(appActivity, bool.booleanValue());
    }
}
